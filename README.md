# RentersListView.js explained

This file defines a single view object used to render the renter list and attach click handlers for edit and delete actions.

The code is intentionally compact: it builds the list markup as a string, injects the data from the model, and lets the rest of the app react to the buttons in that generated HTML.

---

## High-level purpose

`RentersListView` is responsible for:

- selecting the container element `.renter-list`
- handling click events for edit and delete buttons
- creating the HTML for each renter item
- formatting date ranges, money, and display labels
- showing a friendly empty state when no renters exist

---

## 1) Imports

```js
import View from './View.js';
import { formatDate, formatPeso } from '../helpers/format.js';
```

### Meaning

- `View` is the shared base class for app views.
- `formatDate` formats dates consistently for the UI.
- `formatPeso` converts a numeric fee to a peso-formatted string, such as `₱1,500.00`.

This means the view does not need to build formatting logic itself; it depends on reusable helper functions.

---

## 2) SVG helper and icon constants

```js
const svg = paths =>
  `<svg viewBox="0 0 24 24" width="15" height="15" fill="none" stroke="currentColor" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true">${paths}</svg>`;
```

### What it does

This is a tiny wrapper that takes a string of SVG path data and returns a complete inline SVG tag.

- `paths` is the raw SVG path markup
- The function wraps it in a consistent `svg` element used throughout the app
- That makes icon creation short and consistent

Then the icons are defined:

```js
const CAR_ICON = svg(
  '<path d="M19 17h2c.6 0 1-.4 1-1v-3c0-.9-.7-1.7-1.5-1.9C18.7 10.6 16 10 16 10s-1.3-1.4-2.2-2.3c-.5-.4-1.1-.7-1.8-.7H5c-.6 0-1.1.4-1.4.9l-1.4 2.9A3.7 3.7 0 0 0 2 12v4c0 .6.4 1 1 1h2"/><circle cx="7" cy="17" r="2"/><path d="M9 17h6"/><circle cx="17" cy="17" r="2"/>'
);
const CALENDAR_ICON = svg('<rect x="3" y="4" width="18" height="18" rx="2"/><path d="M16 2v4M8 2v4M3 10h18"/>');
const PENCIL_ICON = svg('<path d="M17 3a2.85 2.85 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5Z"/>');
const TRASH_ICON = svg('<path d="M3 6h18M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6M8 6V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"/>');
```

### Why this matters

These constants are reused inside the generated renter HTML so the list shows:

- a car icon next to the car name
- a calendar icon next to the rental dates
- a pencil icon for editing
- a trash icon for deleting

This keeps the UI compact without needing external image files.

---

## 3) Initials helper

```js
// "Leandro Lolo" -> "LL", "Ana" -> "A" (first and last word only; text formatting, no photo)
const initials = name => {
  const words = name.trim().split(/\s+/).filter(Boolean);
  if (words.length === 0) return '?';
  return (words[0][0] + (words.length > 1 ? words.at(-1)[0] : '')).toUpperCase();
};
```

### Function behavior

- `name.trim()` removes leading/trailing spaces
- `.split(/\s+/)` splits the name into words by spaces
- `.filter(Boolean)` removes empty entries
- If the name is empty, it returns `?`
- Otherwise it takes:
  - the first letter of the first name
  - the first letter of the last name if the person has a last name
- It uppercases the result

### Examples

- `Leandro Lolo` -> `LL`
- `Ana` -> `A`
- empty/blank -> `?`

This is used to create the circular avatar text in each renter row.

---

## 4) Class definition and parent element

```js
class RentersListView extends View {
  _parentElement = document.querySelector('.renter-list');
```

### Meaning

This establishes the view class and stores the DOM element where the renter list will be rendered.

- `document.querySelector('.renter-list')` finds the existing list container in the page
- `_parentElement` is the root element the view will append or update content into
- Because it extends `View`, it inherits the base logic used across the app for rendering and updating UI

---

## 5) `addHandlerEdit(handler)`

```js
  addHandlerEdit(handler) {
    this._parentElement.addEventListener('click', e => {
      const btn = e.target.closest('.btn-edit');
      if (!btn) return;
      handler(Number(btn.closest('.renter').dataset.id));
    });
  }
```

### What it does

This method attaches a click listener to the parent list element.

#### Step by step

1. It listens for a click anywhere inside `.renter-list`
2. It checks whether the clicked element is inside an element with class `.btn-edit`
3. If not, it exits immediately
4. If yes, it finds the nearest `.renter` parent and reads its `data-id`
5. It converts that ID to a number and calls the passed `handler`

### Why this is useful

When the user clicks the edit button for a renter, the app can open the edit form/popup with that renter's ID.

Example flow:

- user clicks “Edit”
- handler receives `renter.id`
- controller/model updates the form state for that renter

---

## 6) `addHandlerDelete(handler)`

```js
 
