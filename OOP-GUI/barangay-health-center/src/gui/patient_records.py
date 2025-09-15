class PatientRecords:
    def __init__(self, database_connector):
        self.database_connector = database_connector

    def add_patient(self, name, age, gender, contact_info):
        # Code to add a patient record to the database
        pass

    def update_patient(self, patient_id, name, age, gender, contact_info):
        # Code to update a patient record in the database
        pass

    def delete_patient(self, patient_id):
        # Code to delete a patient record from the database
        pass

    def get_patient_records(self):
        # Code to retrieve all patient records from the database
        pass

    def search_patient(self, search_term):
        # Code to search for a patient record in the database
        pass

    def display_patient_records(self):
        # Code to display patient records in the GUI
        pass