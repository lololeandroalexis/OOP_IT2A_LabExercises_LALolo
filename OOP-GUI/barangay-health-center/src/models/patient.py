class Patient:
    def __init__(self, name, age, gender, contact_info):
        self.name = name
        self.age = age
        self.gender = gender
        self.contact_info = contact_info

    def update_info(self, name=None, age=None, gender=None, contact_info=None):
        if name is not None:
            self.name = name
        if age is not None:
            self.age = age
        if gender is not None:
            self.gender = gender
        if contact_info is not None:
            self.contact_info = contact_info

    def __str__(self):
        return f"Patient(Name: {self.name}, Age: {self.age}, Gender: {self.gender}, Contact: {self.contact_info})"