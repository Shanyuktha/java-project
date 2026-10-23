import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    String ownerName;
    String vehicleModel;
    String serviceStatus;

    Vehicle(String number, String owner, String model) {
        vehicleNumber = number;
        ownerName = owner;
        vehicleModel = model;
        serviceStatus = "Pending";
    }

    void display() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Model: " + vehicleModel);
        System.out.println("Service Status: " + serviceStatus);
        System.out.println("-----------------------------");
    }
}

public class VehicleServiceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[100];
        int count = 0;
        int choice;

        do {
            System.out.println("\n=== VEHICLE SERVICE TRACKER ===");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Update Service Status");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (count >= vehicles.length) {
                        System.out.println("Vehicle storage is full!");
                        break;
                    }

                    System.out.print("Enter Vehicle Number: ");
                    String number = sc.nextLine();

                    System.out.print("Enter Owner Name: ");
                    String owner = sc.nextLine();

                    System.out.print("Enter Vehicle Model: ");
                    String model = sc.nextLine();

                    vehicles[count] = new Vehicle(number, owner, model);
                    count++;

                    System.out.println("Vehicle added successfully!");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No vehicles registered.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            vehicles[i].display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Vehicle Number to search: ");
                    String searchNumber = sc.nextLine();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (vehicles[i].vehicleNumber.equalsIgnoreCase(searchNumber)) {
                            vehicles[i].display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Vehicle not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Vehicle Number: ");
                    String updateNumber = sc.nextLine();
                    boolean updated = false;

                    for (int i = 0; i < count; i++) {
                        if (vehicles[i].vehicleNumber.equalsIgnoreCase(updateNumber)) {
                            System.out.print("Enter new status (Pending/In Progress/Completed): ");
                            vehicles[i].serviceStatus = sc.nextLine();
                            System.out.println("Service status updated successfully!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Vehicle not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Vehicle Service Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}