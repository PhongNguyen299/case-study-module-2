package Project;

import java.util.Scanner;

public class ProjectMenu {
    public static void showMenuProject() {
        System.out.println("|*|==================================================|*|");
        System.out.println("|*|                     ** MENU **                   |*|");
        System.out.println("|*|   1. Add new project.                            |*|");
        System.out.println("|*|   2. Remove project.                             |*|");
        System.out.println("|*|   3. Change project.                             |*|");
        System.out.println("|*|   4. Search information project.                 |*|");
        System.out.println("|*|   5. Display all project.                        |*|");
        System.out.println("|*|   6. Return main Menu.                           |*|");
        System.out.println("|*|==================================================|*|");
    }
    static Scanner input = new Scanner(System.in);

    public static void menuProject() {
        int choice = -1;
        while (choice != 6) {
            showMenuProject();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: ProjectManagement.getProjectManagement().addProject();
                    break;
                case 2: ProjectManagement.getProjectManagement().removeProject();
                    break;
                case 3: ProjectManagement.getProjectManagement().fixProject();
                    break;
                case 4: ProjectManagement.getProjectManagement().searchIdProject();
                    break;
                case 5: ProjectManagement.getProjectManagement().displayProject();
                    break;
                case 6:
                    break;
            }
        }
    }
}
