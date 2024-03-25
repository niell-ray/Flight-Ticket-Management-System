import java.awt.*;
import java.awt.event.*;
import java.util.Random;

// Class representing the customer
class Customer {
    private String name;
    private String dob;
    private String gender;
    private String phoneNumber;

    // Constructor to initialize customer details
    public Customer(String name, String dob, String gender, String phoneNumber) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    // Method to display customer details
    public void displayDetails() {
        System.out.println("Customer Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phoneNumber);
    }
}

// Class representing the flight ticket management system
public class FlightTicketManagementSystem extends Frame implements ActionListener {
    TextField nameField, dobField, genderField, phoneField;
    Dialog ticketDialog;

    // Constructor for FlightTicketManagementSystem
    public FlightTicketManagementSystem() {
        // Set window title
        super("Flight Ticket Management System");

        // Set layout manager
        setLayout(new GridLayout(6, 2));

        // Create components
        Label nameLabel = new Label("Name:");
        nameField = new TextField(20);
        Label dobLabel = new Label("Date of Birth:");
        dobField = new TextField(20);
        Label genderLabel = new Label("Gender:");
        genderField = new TextField(20);
        Label phoneLabel = new Label("Phone Number:");
        phoneField = new TextField(20);
        Button registerButton = new Button("Register");

        // Add event listener for register button
        registerButton.addActionListener(this);

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(dobLabel);
        add(dobField);
        add(genderLabel);
        add(genderField);
        add(phoneLabel);
        add(phoneField);
        add(new Label()); // Empty label for spacing
        add(registerButton); // Add register button with empty label for centering

        // Set frame properties
        setSize(400, 300);
        setVisible(true);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Handle window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose(); // Dispose the frame when window is closed
            }
        });
    }

    // Event handling method
    public void actionPerformed(ActionEvent ae) {
        // Handle registration button click event
        if (ae.getActionCommand().equals("Register")) {
            String name = nameField.getText();
            String dob = dobField.getText();
            String gender = genderField.getText();
            String phoneNumber = phoneField.getText();

            // Validate input
            if (name.isEmpty() || dob.isEmpty() || gender.isEmpty() || phoneNumber.isEmpty()) {
                showMessageDialog("Please fill in all fields.");
            } else {
                showMessageDialog("Registration done.");

                // Open dialog for flight details
                showTicketDialog();
            }
        }
        // Handle done button click event in ticket dialog
        else if (ae.getActionCommand().equals("Done")) {
            // Generate a random seat number
            int seatNumber = new Random().nextInt(100) + 1;

            // Retrieve values from ticket dialog
            String departurePlace = ((TextField) ticketDialog.getComponent(1)).getText();
            String departureTime = ((TextField) ticketDialog.getComponent(3)).getText();
            String departureDate = ((TextField) ticketDialog.getComponent(5)).getText();
            String arrivalPlace = ((TextField) ticketDialog.getComponent(7)).getText();
            String arrivalTime = ((TextField) ticketDialog.getComponent(9)).getText();
            String airlineName = ((TextField) ticketDialog.getComponent(11)).getText();

            // Display ticket details
            String details = "Customer Name: " + nameField.getText()
                            + "\nDate of Birth: " + dobField.getText()
                            + "\nGender: " + genderField.getText()
                            + "\nPhone Number: " + phoneField.getText()
                            + "\nDeparture Place: " + departurePlace
                            + "\nDeparture Time: " + departureTime
                            + "\nDeparture Date: " + departureDate
                            + "\nArrival Place: " + arrivalPlace
                            + "\nArrival Time: " + arrivalTime
                            + "\nAirline Name: " + airlineName
                            + "\nSeat Number: " + seatNumber;

            showMessageDialog(details);
            // Close ticket dialog
            ticketDialog.dispose();
        }
    }

    // Method to display a message dialog
    private void showMessageDialog(String message) {
        Dialog dialog = new Dialog(this, "Message", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label(message));
        Button okButton = new Button("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose(); // Close the dialog when OK button is clicked
            }
        });
        dialog.add(okButton);
        dialog.setSize(200, 100);
        dialog.setVisible(true);
    }

    // Method to open ticket dialog
    private void showTicketDialog() {
        ticketDialog = new Dialog(this, "Flight Details", true);
        ticketDialog.setLayout(new GridLayout(8, 2));
        ticketDialog.add(new Label("Departure Place:"));
        ticketDialog.add(new TextField(20));
        ticketDialog.add(new Label("Departure Time:"));
        ticketDialog.add(new TextField(20));
        ticketDialog.add(new Label("Departure Date:"));
        ticketDialog.add(new TextField(20));
        ticketDialog.add(new Label("Arrival Place:"));
        ticketDialog.add(new TextField(20));
        ticketDialog.add(new Label("Arrival Time:"));
        ticketDialog.add(new TextField(20));
        ticketDialog.add(new Label("Airline Name:"));
        ticketDialog.add(new TextField(20));
        Button doneButton = new Button("Done");
        doneButton.addActionListener(this);
        ticketDialog.add(doneButton);
        ticketDialog.setSize(400, 300);
        ticketDialog.setVisible(true);
    }

    public static void main(String[] args) {
        new FlightTicketManagementSystem();
   
    }
}
