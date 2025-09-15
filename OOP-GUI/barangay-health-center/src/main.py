from gui.main_window import MainWindow
from database.mysql_connector import MySQLConnector

def main():
    # Initialize the database connection
    db_connector = MySQLConnector()
    db_connector.connect()

    # Initialize the main application window
    app = MainWindow(db_connector)
    app.run()

if __name__ == "__main__":
    main()