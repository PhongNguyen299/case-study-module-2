package MainMenu;

import Department.DepartmentManagement;
import Personnel.PersonnelManagement;
import Personnel.PersonnelMenu;
import Project.ProjectManagement;
import Project.ProjectMenu;

public class Menu {
    public static void main(String[] args) {
        PersonnelManagement pm = PersonnelManagement.getPersonnelManagement();
        DepartmentManagement dm = DepartmentManagement.getDepartmentManagement();
        ProjectManagement proM = ProjectManagement.getProjectManagement();
        showMainMenu();

    }
    public static void showMainMenu() {
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
}