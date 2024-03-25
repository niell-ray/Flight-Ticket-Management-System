import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

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
    static Scanner scanner = new Scanner(System.in);
    static int seatNumber = 1; // Initial seat number

    // Constructor for FlightTicketManagementSystem
    public FlightTicketManagementSystem() {
        // Set window title
        super("Flight Ticket Management System");

        // Set layout manager
        setLayout(new FlowLayout());

        // Create components
        Button registerButton = new Button("Register Customer");
        Button bookButton = new Button("Book Ticket");

        // Add event listeners
        registerButton.addActionListener(this);
        bookButton.addActionListener(this);

        // Add components to the frame
        add(registerButton);
        add(bookButton);

        // Set frame properties
        setSize(300, 100);
        setVisible(true);

        // Handle window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose(); // Dispose the frame when window is closed
            }
        });
    }

    // Method to create a customer account
    public static void registerCustomer() {
        try {
            System.out.println("Enter customer's name:");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            System.out.println("Enter customer's date of birth:");
            String dob = scanner.nextLine();
            System.out.println("Enter customer's gender:");
            String gender = scanner.nextLine();
            System.out.println("Enter customer's phone number:");
            String phoneNumber = scanner.nextLine();
            System.out.println("Customer registered successfully.");
            Customer customer = new Customer(name, dob, gender, phoneNumber);
            customer.displayDetails();
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    // Method to book a flight ticket
    public static void bookTicket() {
        System.out.println("Enter departure place:");
        String departurePlace = scanner.nextLine();
        System.out.println("Enter date of departure:");
        String departureDate = scanner.nextLine();
        System.out.println("Enter date of arrival:");
        String arrivalDate = scanner.nextLine();
        System.out.println("Enter place of arrival:");
        String arrivalPlace = scanner.nextLine();
        System.out.println("Enter airline name:");
        String airlineName = scanner.nextLine();
        System.out.println("Ticket booked successfully.");
        System.out.println("Your seat number is: " + seatNumber++);
    }

    // Event handling method
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
            case "Register Customer":
                registerCustomer();
                break;
            case "Book Ticket":
                bookTicket();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void main(String[] args) {
        new FlightTicketManagementSystem();
    }
}
