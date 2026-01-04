# Barangay Health Center Management System - Class Hierarchy Documentation

## Overview

This document describes the complete class hierarchy for the Barangay Health Center Management System. The system follows Object-Oriented Programming (OOP) principles with a well-defined hierarchy of abstract base classes and concrete implementations.

## Class Hierarchy Structure

### 1. Base Classes

#### UIComponent (Abstract)
- **Location**: `UIComponent.java`
- **Purpose**: Base class for all GUI components in the system
- **Key Features**:
  - Defines standard colors and fonts for consistency
  - Provides common initialization methods
  - Extends `JFrame` for window management
  - Encapsulates UI-related constants

**Key Methods**:
- `initializeUI()` - Abstract method to create UI
- `displayComponent()` - Display the component centered on screen
- `getWindowTitle()` / `setWindowTitle()` - Window title management

#### DomainModel (Abstract)
- **Location**: `DomainModel.java`
- **Purpose**: Base class for all business domain entities
- **Key Features**:
  - Handles ID management
  - Tracks creation and modification dates
  - Provides common entity behavior

**Key Methods**:
- `getId()` / `setId()` - ID management
- `getCreatedDate()` / `getLastModifiedDate()` - Date tracking
- `updateLastModifiedDate()` - Update modification timestamp

---

### 2. User Hierarchy (extends DomainModel)

#### User (Abstract)
- **Location**: `User.java`
- **Purpose**: Base class for all system users
- **Key Attributes**:
  - email, password, firstName, lastName
  - role, phoneNumber

**Key Methods**:
- `authenticate()` - Abstract user authentication
- `displayDashboard()` - Abstract dashboard display
- `getFullName()` - Combine first and last name

#### Patient (extends User)
- **Location**: `Patient.java`
- **Role**: PATIENT
- **Additional Attributes**:
  - dateOfBirth, gender, address
  - medicalHistory, bloodType

**Purpose**: Represents patient users with medical information

#### Admin (extends User)
- **Location**: `Admin.java`
- **Role**: ADMIN
- **Additional Attributes**:
  - departmentName, accessLevel
  - canManageUsers, canManageBilling, canManageSettings

**Purpose**: Represents administrator users with system permissions

#### Staff (extends User)
- **Location**: `Staff.java`
- **Role**: STAFF
- **Additional Attributes**:
  - profession, specialization, licenseNumber
  - department, workSchedule

**Purpose**: Represents healthcare personnel with professional credentials

---

### 3. Document Hierarchy (extends DomainModel)

#### Document (Abstract)
- **Location**: `Document.java`
- **Purpose**: Base class for all system documents
- **Key Attributes**:
  - documentType, status, description
  - documentNumber (auto-generated)

**Key Methods**:
- `approve()` - Abstract approval method
- `reject(String reason)` - Abstract rejection method
- `getDocumentNumber()` - Get unique document ID

#### Appointment (extends Document)
- **Location**: `Appointment.java`
- **Document Type**: APPOINTMENT
- **Additional Attributes**:
  - patientId, staffId
  - appointmentDate, appointmentTime
  - serviceType, notes, diagnosis, treatment

**Purpose**: Represents healthcare appointments with workflow support

---

### 4. UI Component Hierarchy (extends UIComponent)

#### LoginScreenUI
- **Location**: `LoginScreenUI.java`
- **Size**: 500x750
- **Purpose**: Handles user authentication
- **Key Features**:
  - Email and password input fields
  - Sign In and Sign Up buttons
  - Status label for feedback

#### PatientDashboardUI
- **Location**: `PatientDashboardUI.java`
- **Size**: 1200x700
- **Purpose**: Main interface for patient users
- **Key Sections**:
  - Profile view
  - Appointments management
  - Staff information
- **Features**:
  - Left sidebar navigation
  - Dynamic content panel
  - Logout functionality

#### AdminDashboardUI
- **Location**: `AdminDashboardUI.java`
- **Size**: 1200x750
- **Purpose**: Main interface for admin users
- **Key Sections**:
  - Dashboard overview with statistics
  - Staff management
  - Billing records
  - User management
  - System settings
- **Features**:
  - Multi-section navigation
  - Statistics display
  - Administrative tools

#### StaffDashboardUI
- **Location**: `StaffDashboardUI.java`
- **Size**: 1200x750
- **Purpose**: Main interface for healthcare staff
- **Key Sections**:
  - Dashboard overview
  - Appointment management
  - Patient records
  - Appointment history
  - Billing history
- **Features**:
  - Clinical workflow support
  - Patient data access
  - Appointment scheduling

#### AppointmentManagerUI
- **Location**: `AppointmentManagerUI.java`
- **Size**: 900x700
- **Purpose**: Window for managing appointments
- **Fields**:
  - Patient name, appointment date
  - Service type selection
  - Notes/description area
- **Actions**: Submit and Cancel buttons

#### BillingRecordFormUI
- **Location**: `BillingRecordFormUI.java`
- **Size**: 900x800
- **Purpose**: Window for billing records
- **Fields**:
  - Invoice number, patient name
  - Service description, total amount
  - Payment status
- **Actions**: Save and Print buttons

#### PatientProfileEditorUI
- **Location**: `PatientProfileEditorUI.java`
- **Size**: 600x700
- **Purpose**: Edit patient profile information
- **Fields**:
  - Name, email, phone, date of birth
  - Gender, address
- **Actions**: Save and Cancel buttons

#### ContactInformationUI
- **Location**: `ContactInformationUI.java`
- **Size**: 950x850
- **Purpose**: Display facility contact and hours
- **Sections**:
  - Address information
  - Phone number
  - Email address
  - Operating hours

#### HealthPersonnelDirectoryUI
- **Location**: `HealthPersonnelDirectoryUI.java`
- **Size**: 1000x700
- **Purpose**: Manage and view staff directory
- **Features**:
  - Staff information table
  - Add/Edit/Delete functionality
  - Staff details display

---

### 5. Utility Classes

#### DatabaseHelper
- **Location**: `DatabaseHelper.java`
- **Purpose**: Database connection and operations management
- **Key Methods**:
  - `getConnection()` - Establish DB connection
  - `authenticateUser()` - User authentication
  - `registerUser()` - User registration
  - `getUserId()` - Retrieve user ID
  - `getAllAppointments()` - Fetch appointments
  - `insertAppointment()` - Create appointments
  - `closeConnection()` - Clean up connections

#### SimpleProfileEditor
- **Location**: `SimpleProfileEditor.java`
- **Purpose**: Profile management and validation utilities
- **Key Methods**:
  - `isValidEmail()` - Email format validation
  - `isValidPassword()` - Password strength check
  - `isValidPhoneNumber()` - Phone validation
  - `isValidDate()` - Date format validation
  - `isValidName()` - Name validation
  - `sanitizeInput()` - SQL injection prevention
  - `updatePatientProfile()` - Patient profile updates
  - `updateStaffProfile()` - Staff profile updates
  - `getPatientProfile()` - Fetch patient data
  - `getStaffProfile()` - Fetch staff data
  - `hashPassword()` - Password hashing
  - `formatDate()` - Date formatting

---

## Complete Class List

### Base Classes (2)
1. UIComponent
2. DomainModel

### Domain Model Classes (5)
3. User
4. Patient
5. Admin
6. Staff
7. Document
8. Appointment

### UI Component Classes (9)
9. LoginScreenUI
10. PatientDashboardUI
11. AdminDashboardUI
12. StaffDashboardUI
13. AppointmentManagerUI
14. BillingRecordFormUI
15. PatientProfileEditorUI
16. ContactInformationUI
17. HealthPersonnelDirectoryUI

### Utility Classes (2)
18. DatabaseHelper
19. SimpleProfileEditor

### Tester Class (1)
20. ProjectTester

**Total: 20 Classes**

---

## Relationships Summary

```
Inheritance Relationships:
├── UIComponent (Abstract)
│   ├── LoginScreenUI
│   ├── PatientDashboardUI
│   ├── AdminDashboardUI
│   ├── StaffDashboardUI
│   ├── AppointmentManagerUI
│   ├── BillingRecordFormUI
│   ├── PatientProfileEditorUI
│   ├── ContactInformationUI
│   └── HealthPersonnelDirectoryUI
│
└── DomainModel (Abstract)
    ├── User (Abstract)
    │   ├── Patient
    │   ├── Admin
    │   └── Staff
    │
    └── Document (Abstract)
        └── Appointment

Composition Relationships:
├── PatientDashboard uses Patient
├── AdminDashboard uses Admin
├── StaffDashboard uses Staff
├── AppointmentManager uses Appointment
├── SimpleProfileEditor uses Patient and Staff
└── DatabaseHelper manages all persistence
```

---

## Usage Example

### Creating and Testing Instances

```java
// Create a Patient
Patient patient = new Patient(
    1001,
    "john@email.com",
    "password123",
    "John",
    "Doe",
    "(555) 123-4567",
    "1990-05-15",
    "Male",
    "123 Main Street"
);

// Create an Appointment
Appointment appointment = new Appointment(
    5001,
    1001,    // patientId
    3001,    // staffId
    "2024-01-15",
    "09:30 AM",
    "General Checkup",
    "Follow-up appointment"
);

// Approve appointment
appointment.approve();

// Create Patient Dashboard UI
PatientDashboardUI dashboard = new PatientDashboardUI(1001, "john@email.com");

// Validate patient data
if (SimpleProfileEditor.updatePatientProfile(patient)) {
    System.out.println("Patient profile updated successfully");
}
```

---

## Key Design Patterns Used

### 1. **Abstract Base Class Pattern**
- `UIComponent` and `DomainModel` provide common functionality
- Subclasses override abstract methods for specific behavior

### 2. **Inheritance Hierarchy**
- Multi-level inheritance for code reuse
- User hierarchy for different user roles
- Document hierarchy for different document types

### 3. **Separation of Concerns**
- Domain models separate from UI components
- Utility classes handle specific concerns
- DatabaseHelper centralizes data access

### 4. **Template Method Pattern**
- UIComponent defines UI creation template
- Subclasses implement `initializeUI()`

---

## Running the ProjectTester

The `ProjectTester` class demonstrates all classes and their functionality:

```bash
javac *.java
java ProjectTester
```

This will:
1. Create instances of all domain model classes
2. Test authentication methods
3. Create all UI component instances
4. Test utility class methods
5. Display comprehensive test results

---

## File Organization

```
ClassHierarchy/
├── CLASS_HIERARCHY_DIAGRAM.txt     (Visual diagram)
├── README.md                       (This file)
│
├── Base Classes
├── UIComponent.java
├── DomainModel.java
│
├── Domain Models
├── User.java
├── Patient.java
├── Admin.java
├── Staff.java
├── Document.java
├── Appointment.java
│
├── UI Components
├── LoginScreenUI.java
├── PatientDashboardUI.java
├── AdminDashboardUI.java
├── StaffDashboardUI.java
├── AppointmentManagerUI.java
├── BillingRecordFormUI.java
├── PatientProfileEditorUI.java
├── ContactInformationUI.java
├── HealthPersonnelDirectoryUI.java
│
├── Utilities
├── DatabaseHelper.java
├── SimpleProfileEditor.java
│
└── Tester
    └── ProjectTester.java
```

---

## Summary

This class hierarchy provides a robust, extensible foundation for the Barangay Health Center Management System. The design follows SOLID principles and object-oriented best practices, making it easy to maintain, test, and extend with new features.
