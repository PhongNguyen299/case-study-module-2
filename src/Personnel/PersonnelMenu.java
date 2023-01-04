package Personnel;

import java.util.Scanner;

public class PersonnelMenu {
    public static void showMenuPersonnel() {
        System.out.println("*******************************************************");
        System.out.println("*                         MENU                        *");
        System.out.println("*   1. Add new personnel.                             *");
        System.out.println("*   2. Remove personnel.                              *");
        System.out.println("*   3. Change personnel.                              *");
        System.out.println("*   4. Search information personnel.                  *");
        System.out.println("*   5. Display all personnel.                         *");
        System.out.println("*   6. Display salary.                                *");
        System.out.println("*   7. Return main Menu.                              *");
        System.out.println("*******************************************************");
    }

    static Scanner input = new Scanner(System.in);
    public static void menuPersonnel() {
        int choice = -1;
        while (choice != 7) {
            showMenuPersonnel();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: PersonnelManagement.getPersonnelManagement().addMember();
                break;
                case 2: PersonnelManagement.getPersonnelManagement().removeMember();
                break;
                case 3: PersonnelManagement.getPersonnelManagement().fixMember();
                break;
                case 4: PersonnelManagement.getPersonnelManagement().search();
                break;
                case 5: PersonnelManagement.getPersonnelManagement().displayAllMember();
                break;
                case 6: PersonnelManagement.getPersonnelManagement().displaySalary();
                break;
                case 7:
                    break;
            }
        }
    }
}