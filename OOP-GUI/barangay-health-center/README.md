# Barangay Health Center System

This project is a Barangay Health Center system implemented using Python with an Object-Oriented Programming (OOP) approach. It features a graphical user interface (GUI) for managing patient records and appointment scheduling, utilizing MySQL as the database for data storage.

## Features

- **Patient Records Management**: Add, update, and delete patient information.
- **Appointment Scheduling**: View, add, and modify appointments for patients.
- **User-Friendly GUI**: Intuitive interface for easy navigation and management of health center operations.

## Project Structure

```
barangay-health-center
├── src
│   ├── main.py                # Entry point of the application
│   ├── gui                    # GUI components
│   │   ├── __init__.py
│   │   ├── main_window.py      # Main application window
│   │   ├── patient_records.py   # Patient records management
│   │   └── appointment_scheduler.py # Appointment scheduling
│   ├── models                 # Data models
│   │   ├── __init__.py
│   │   ├── patient.py          # Patient entity
│   │   └── appointment.py       # Appointment entity
│   ├── database               # Database connection
│   │   ├── __init__.py
│   │   └── mysql_connector.py   # MySQL connection handling
│   └── utils                  # Utility functions
│       ├── __init__.py
│       └── helpers.py          # Helper functions
├── requirements.txt           # Project dependencies
└── README.md                  # Project documentation
```

## Setup Instructions

1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd barangay-health-center
   ```

2. **Install dependencies**:
   Use pip to install the required packages listed in `requirements.txt`.
   ```
   pip install -r requirements.txt
   ```

3. **Configure the database**:
   Ensure you have a MySQL server running and create a database for the application. Update the database connection settings in `src/database/mysql_connector.py`.

4. **Run the application**:
   Execute the main script to start the application.
   ```
   python src/main.py
   ```

## Usage Guidelines

- Upon launching the application, you will be presented with the main window.
- Navigate through the application to manage patient records and schedule appointments.
- Follow the prompts to add or modify records as needed.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue for any enhancements or bug fixes.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.