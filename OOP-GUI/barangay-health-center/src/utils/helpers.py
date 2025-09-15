def validate_patient_data(name, age, gender, contact):
    if not name or not isinstance(name, str):
        return False, "Invalid name"
    if not isinstance(age, int) or age <= 0:
        return False, "Invalid age"
    if gender not in ['Male', 'Female', 'Other']:
        return False, "Invalid gender"
    if not contact or not isinstance(contact, str):
        return False, "Invalid contact information"
    return True, "Valid data"

def format_date(date):
    return date.strftime("%Y-%m-%d")

def format_time(time):
    return time.strftime("%H:%M")