from tkinter import Tk, Frame, Menu, Label, Button
from gui.patient_records import PatientRecords
from gui.appointment_scheduler import AppointmentScheduler

class MainWindow:
    def __init__(self, master):
        self.master = master
        self.master.title("Barangay Health Center System")
        self.master.geometry("800x600")

        self.create_menu()
        self.create_widgets()

    def create_menu(self):
        menu = Menu(self.master)
        self.master.config(menu=menu)

        file_menu = Menu(menu)
        menu.add_cascade(label="File", menu=file_menu)
        file_menu.add_command(label="Exit", command=self.master.quit)

        records_menu = Menu(menu)
        menu.add_cascade(label="Records", menu=records_menu)
        records_menu.add_command(label="Patient Records", command=self.show_patient_records)
        records_menu.add_command(label="Appointment Scheduler", command=self.show_appointment_scheduler)

    def create_widgets(self):
        self.label = Label(self.master, text="Welcome to the Barangay Health Center System", font=("Arial", 16))
        self.label.pack(pady=20)

        self.patient_records_button = Button(self.master, text="Manage Patient Records", command=self.show_patient_records)
        self.patient_records_button.pack(pady=10)

        self.appointment_scheduler_button = Button(self.master, text="Schedule Appointments", command=self.show_appointment_scheduler)
        self.appointment_scheduler_button.pack(pady=10)

        self.frame = Frame(self.master)
        self.frame.pack(fill="both", expand=True)

    def show_patient_records(self):
        self.clear_frame()
        self.patient_records = PatientRecords(self.frame)
        self.patient_records.pack(fill="both", expand=True)

    def show_appointment_scheduler(self):
        self.clear_frame()
        self.appointment_scheduler = AppointmentScheduler(self.frame)
        self.appointment_scheduler.pack(fill="both", expand=True)

    def clear_frame(self):
        for widget in self.frame.winfo_children():
            widget.destroy()