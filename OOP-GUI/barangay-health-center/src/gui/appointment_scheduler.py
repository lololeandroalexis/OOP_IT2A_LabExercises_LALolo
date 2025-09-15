class AppointmentScheduler:
    def __init__(self, master):
        self.master = master
        self.master.title("Appointment Scheduler")
        
        # Create UI elements
        self.create_widgets()

    def create_widgets(self):
        # Labels and Entry fields for appointment details
        self.label_date = Label(self.master, text="Date (YYYY-MM-DD):")
        self.label_date.grid(row=0, column=0)
        self.entry_date = Entry(self.master)
        self.entry_date.grid(row=0, column=1)

        self.label_time = Label(self.master, text="Time (HH:MM):")
        self.label_time.grid(row=1, column=0)
        self.entry_time = Entry(self.master)
        self.entry_time.grid(row=1, column=1)

        self.label_patient = Label(self.master, text="Patient Name:")
        self.label_patient.grid(row=2, column=0)
        self.entry_patient = Entry(self.master)
        self.entry_patient.grid(row=2, column=1)

        self.label_purpose = Label(self.master, text="Purpose:")
        self.label_purpose.grid(row=3, column=0)
        self.entry_purpose = Entry(self.master)
        self.entry_purpose.grid(row=3, column=1)

        # Buttons for scheduling and viewing appointments
        self.button_schedule = Button(self.master, text="Schedule Appointment", command=self.schedule_appointment)
        self.button_schedule.grid(row=4, column=0, columnspan=2)

        self.button_view = Button(self.master, text="View Appointments", command=self.view_appointments)
        self.button_view.grid(row=5, column=0, columnspan=2)

    def schedule_appointment(self):
        # Logic to schedule an appointment
        date = self.entry_date.get()
        time = self.entry_time.get()
        patient = self.entry_patient.get()
        purpose = self.entry_purpose.get()
        
        # Here you would add code to save the appointment to the database
        print(f"Scheduled appointment for {patient} on {date} at {time} for {purpose}")

    def view_appointments(self):
        # Logic to view appointments
        # Here you would add code to retrieve and display appointments from the database
        print("Viewing appointments...")