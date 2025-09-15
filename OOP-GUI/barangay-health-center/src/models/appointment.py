class Appointment:
    def __init__(self, date, time, patient, purpose):
        self.date = date
        self.time = time
        self.patient = patient
        self.purpose = purpose

    def __str__(self):
        return f"Appointment on {self.date} at {self.time} for {self.patient} - Purpose: {self.purpose}"

    def to_dict(self):
        return {
            "date": self.date,
            "time": self.time,
            "patient": self.patient,
            "purpose": self.purpose
        }