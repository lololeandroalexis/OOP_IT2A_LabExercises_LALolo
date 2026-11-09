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
  addHandlerDelete(handler) {
    this._parentElement.addEventListener('click', e => {
      const btn = e.target.closest('.btn-delete');
      if (!btn) return;
      if (!confirm('Are you sure you want to delete this renter?')) return;
      handler(Number(btn.closest('.renter').dataset.id));
    });
  }
```

### What it does

This method adds a delete button click handler with a confirmation prompt.

#### Step by step

1. It listens to clicks on the renter list container
2. It checks whether the click came from `.btn-delete`
3. If the click is not from delete, it does nothing
4. It shows a confirmation popup:
   - `confirm('Are you sure you want to delete this renter?')`
5. If the user cancels, the function exits and nothing is deleted
6. If the user confirms, it reads the renter ID from the closest `.renter` row and calls the `handler`

### Why this matters

This makes the delete action safe by preventing accidental deletion without confirmation.

---

## 7) `_generateMarkup()`

```js
  _generateMarkup() {
    if (this._data.length === 0) {
      return '<li class="empty">No renters yet. Click Rent Now on a car to add one.</li>';
    }

    return this._data
      .map(renter => {
        // Old saved renters may have no day count, so only show it when there is one
        const days = renter.days ? ` (${renter.days} ${renter.days === 1 ? 'day' : 'days'})` : '';
        const dates = renter.hasDates
          ? `${formatDate(renter.startDate)} – ${formatDate(renter.endDate)}${days}`
          : 'No dates';

        return `
          <li class="renter" data-id="${renter.id}">
            <span class="avatar" aria-hidden="true">${initials(renter.name)}</span>
            <div class="renter-body">
              <div class="renter-top">
                <strong class="renter-name">${renter.name}</strong>
                <span class="badge badge-${renter.status.toLowerCase()}">${renter.status}</span>
              </div>
              <span class="renter-meta">${CAR_ICON} ${renter.carName}${renter.carPlate ? ` (${renter.carPlate})` : ''}</span>
              <span class="renter-meta">${CALENDAR_ICON} ${dates}</span>
              <div class="renter-bottom">
                <span class="renter-fee">${formatPeso(renter.fee)}</span>
                <div class="renter-actions">
                  <button type="button" class="btn btn-outline btn-sm btn-edit">${PENCIL_ICON} Edit</button>
                  <button type="button" class="btn btn-danger btn-sm btn-delete">${TRASH_ICON} Delete</button>
                </div>
              </div>
            </div>
          </li>`;
      })
      .join('');
  }
```

This is the main rendering method.

### Part 1: empty state

```js
if (this._data.length === 0) {
  return '<li class="empty">No renters yet. Click Rent Now on a car to add one.</li>';
}
```

If the model has no renters, the view renders a friendly empty list item instead of a blank area.

### Part 2: formatting the rental date string

```js
const days = renter.days ? ` (${renter.days} ${renter.days === 1 ? 'day' : 'days'})` : '';
const dates = renter.hasDates
  ? `${formatDate(renter.startDate)} – ${formatDate(renter.endDate)}${days}`
  : 'No dates';
```

This code builds a readable date string.

- If `renter.days` exists, it appends something like ` (3 days)`
- If `renter.hasDates` is true, it shows the date range
- Otherwise it shows `No dates`

This is helpful because older saved renters may not include all day-count information.

### Part 3: generating each renter row

```js
return `
  <li class="renter" data-id="${renter.id}">
    <span class="avatar" aria-hidden="true">${initials(renter.name)}</span>
    <div class="renter-body">
      <div class="renter-top">
        <strong class="renter-name">${renter.name}</strong>
        <span class="badge badge-${renter.status.toLowerCase()}">${renter.status}</span>
      </div>
      <span class="renter-meta">${CAR_ICON} ${renter.carName}${renter.carPlate ? ` (${renter.carPlate})` : ''}</span>
      <span class="renter-meta">${CALENDAR_ICON} ${dates}</span>
      <div class="renter-bottom">
        <span class="renter-fee">${formatPeso(renter.fee)}</span>
        <div class="renter-actions">
          <button type="button" class="btn btn-outline btn-sm btn-edit">${PENCIL_ICON} Edit</button>
          <button type="button" class="btn btn-danger btn-sm btn-delete">${TRASH_ICON} Delete</button>
        </div>
      </div>
    </div>
  </li>`;
```

This builds each renter row as HTML.

Key pieces:

- `data-id="${renter.id}"` stores the renter’s unique id in the DOM for later button click handling
- `.avatar` displays the generated initials from the renter name
- `.renter-name` shows the renter’s full name
- `.badge-badgestatus` uses the status to apply a CSS class such as active, pending, or completed
- `CAR_ICON` and `CALENDAR_ICON` show the car and date metadata
- `formatPeso(renter.fee)` displays the rental fee in a formatted currency string
- The two buttons have classes `btn-edit` and `btn-delete` so the event handlers know which button was clicked

### Part 4: joining all rows

```js
      })
      .join('');
```

- `.map(...)` produces an array of HTML strings
- `.join('')` merges them into one big markup string
- This is then inserted into the DOM by the base `View` class or a render method elsewhere in the app

---

## 8) Export

```js
export default new RentersListView();
```

This creates one instance of the view and exports it as the default value.

That means other files can import it like this:

```js
import rentersListView from './views/RentersListView.js';
```

In practice, that singleton instance is reused across the app so the UI updates from the same object instead of creating duplicates.

---

## Summary

This file is a classic simple view layer:

- it knows how to read the list data
- it formats it for display
- it renders the HTML with icons, date info, and actions
- it listens for click events on edit/delete buttons
- it keeps row data attached via `data-id` so later handlers can work with the correct renter

In short, it is the UI representation of the renter list and the bridge between the visual list and the app’s controller logic.
