package MainMenu;

import Department.DepartmentManagement;
import Personnel.PersonnelManagement;
import Personnel.PersonnelMenu;
import Project.ProjectManagement;

public class Menu {
    public static void main(String[] args) {
        PersonnelManagement pm = PersonnelManagement.getPersonnelManagement();
        DepartmentManagement dm = DepartmentManagement.getDepartmentManagement();
        ProjectManagement proM = ProjectManagement.getProjectManagement();
//        dm.addNewDepartment();
//        pm.search();
//        pm.displayAllMember();
//        pm.search();
//        dm.displayDepartment();
//        dm.addNewDepartment();
//        dm.displayDepartment();
//        dm.searchDepartment();
//        dm.removeDepartment();
//        dm.displayDepartment();
//
//        pm.displayAllMember();

//            pm.search();
//            pm.addMember();
//        dm.fixDepartment();


//        proM.search();
//        pm.displaySalary();
//        proM.addProject();

//        DepartmentMenu.menuDepartment();
        PersonnelMenu.menuPersonnel();
    }
}