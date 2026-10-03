import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid option. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = 0;
                    if (scanner.hasNextInt()) {
                        age = scanner.nextInt();
                        scanner.nextLine(); 
                    } else {
                        System.out.println("Invalid age format.");
                        scanner.nextLine();
                        break;
                    }

                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();

                    Contact contact = new Contact(name, email, age, phone);
                    addressBook.addContact(contact);
                    break;

                case 2:
                    addressBook.viewContacts();
                    break;

                case 3:
                    System.out.print("Enter the email of the contact to search: ");
                    email = scanner.nextLine();
                    addressBook.searchContact(email);
                    break;

                case 4:
                    System.out.print("Enter the email of the contact to delete: ");
                    email = scanner.nextLine();
                    addressBook.deleteContact(email);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        } while (option != 5);

        scanner.close();
    }
}