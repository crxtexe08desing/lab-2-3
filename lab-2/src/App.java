import grades.gradeManager;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        gradeManager gradeManager = new gradeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add grade");
            System.out.println("2. View average grade");
            System.out.println("3. View number of passing grades");
            System.out.println("4. Remove a grade (DESAFÍO)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid option. Please try again.");
                scanner.next();
                continue;
            }

            Integer choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a grade: ");
                    if (scanner.hasNextDouble()) {
                        Double grade = scanner.nextDouble();
                        gradeManager.addGrade(grade);
                        System.out.println("Grade added successfully.");
                    } else {
                        System.out.println("Invalid grade. Must be a number.");
                        scanner.next();
                    }
                    break;

                case 2:
                    System.out.println("Average grade: " + gradeManager.calculateAverage());
                    break;

                case 3:
                    System.out.println("Number of passing grades: " + gradeManager.countPassingGrades());
                    break;

                case 4:
                    if (gradeManager.getGradesCount() == 0) {
                        System.out.println("No grades available to remove.");
                        break;
                    }

                    System.out.println("\nCurrent grades:");
                    gradeManager.printGrades();

                    System.out.println("\nRemove by:");
                    System.out.println("1. Index (position)");
                    System.out.println("2. Value");
                    System.out.print("Choose sub-option: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid option.");
                        scanner.next();
                        break;
                    }

                    int removeType = scanner.nextInt();

                    if (removeType == 1) {
                        System.out.print("Enter position index: ");
                        if (scanner.hasNextInt()) {
                            int idx = scanner.nextInt();
                            if (gradeManager.removeGradeByIndex(idx)) {
                                System.out.println("Grade removed successfully.");
                            } else {
                                System.out.println("Error: Index out of bounds.");
                            }
                        } else {
                            System.out.println("Invalid index.");
                            scanner.next();
                        }
                    } else if (removeType == 2) {
                        System.out.print("Enter grade value to remove: ");
                        if (scanner.hasNextDouble()) {
                            Double val = scanner.nextDouble();
                            if (gradeManager.removeGradeByValue(val)) {
                                System.out.println("Grade removed successfully.");
                            } else {
                                System.out.println("Error: Grade value not found in the list.");
                            }
                        } else {
                            System.out.println("Invalid grade value.");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}