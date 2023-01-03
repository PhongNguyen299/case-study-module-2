package Department;

import java.util.Scanner;

public class DepartmentMenu {
    private static void showMenuDepartment() {
        System.out.println("*******************************************************");
        System.out.println("*                         MENU                        *");
        System.out.println("*   1. Add new department.                            *");
        System.out.println("*   2. Remove department.                             *");
        System.out.println("*   3. Change department.                             *");
        System.out.println("*   4. Search information department                  *");
        System.out.println("*   5. Display all department.                        *");
        System.out.println("*   6. Return main Menu                               *");
        System.out.println("*******************************************************");
    }

    static Scanner input = new Scanner(System.in);
    public static void menuDepartment(){
        int choice = -1;
        while (choice != 6){
            showMenuDepartment();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 1: DepartmentManagement.getDepartmentManagement().addNewDepartment();
                break;
                case 2: DepartmentManagement.getDepartmentManagement().removeDepartment();
                break;
                case 3:DepartmentManagement.getDepartmentManagement().fixDepartment();
                break;
                case 4: DepartmentManagement.getDepartmentManagement().searchDepartment();
                break;
                case 5:DepartmentManagement.getDepartmentManagement().displayDepartment();
                    break;
            }
        }
    }
}
