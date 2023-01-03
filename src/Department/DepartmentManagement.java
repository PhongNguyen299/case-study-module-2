package Department;
import Personnel.Personnel;
import Project.Project;
import Project.ProjectManagement;

import static Personnel.PersonnelManagement.getPersonnelManagement;
import static Personnel.PersonnelManagement.listPersonnel;

import java.util.*;


public final class DepartmentManagement {
    private static volatile DepartmentManagement departmentManagement;
    public List <Department> listDepartment;

    private Scanner input = new Scanner(System.in);

    private DepartmentManagement(){
        listDepartment = new LinkedList<>();
        listDepartment.add( new Department(1,"Marketing",10));
        listDepartment.add( new Department(2,"Accounting",7));
        listDepartment.add( new Department(3,"Finance",9));
    };

    public static DepartmentManagement getDepartmentManagement(){
        if(departmentManagement == null){
            synchronized (DepartmentManagement.class){
                if (departmentManagement == null){
                    departmentManagement = new DepartmentManagement();
                }
            }
        }
        return departmentManagement;
    }

    public void addNewDepartment(){
        System.out.println("Please enter information new Department: ");
        System.out.print("Enter id Department (number): ");

        int id = input.nextInt();
        input.nextLine();
        List arr = new ArrayList();
        for (Department department: listDepartment) {
            arr.add(department.getId());
            while (arr.contains(id)){
                System.out.println("Your Id is exist, please try other id");
                System.out.println("Ids are exist: ");
                for (Department depart: listDepartment) {
                    System.out.println("ID: " + depart.getId());
                }
                System.out.print("\n");
                System.out.print("Enter id: ");
                id = input.nextInt();
                input.nextLine();
            }
        }
        System.out.print("Enter name's Department: ");
        String name = input.nextLine();

        listDepartment.add(new Department(id,name));
    }

    public void searchDepartment(){
        System.out.println("Choose Department: ");
        for (Department element : DepartmentManagement.getDepartmentManagement().listDepartment) {
            System.out.println(element.getId() +". "+ element.getName() + " Department " );
        }
        int choiceDepartment = input.nextInt()-1;
        System.out.println("Member of " + DepartmentManagement.getDepartmentManagement().listDepartment.get(choiceDepartment).getName()+ ":" );
        for (Map.Entry<Integer, Personnel> entry: listPersonnel.entrySet()) {
            Integer key = entry.getKey();
            Personnel value = entry.getValue();
            if (DepartmentManagement.getDepartmentManagement().listDepartment.get(choiceDepartment).getName().equals(value.getBelongDepartment()))
                System.out.println( value.getName() + " - Gender: "+value.getGender()
                        + " - Position: " + value.getPosition() +".");
        }
    }
    public void removeDepartment(){
        System.out.println("Choose Department you want to remove: ");
        for (Department element : DepartmentManagement.getDepartmentManagement().listDepartment) {
            System.out.println(element.getId() +". "+ element.getName() + " Department " );
        }
        int indexRemove = input.nextInt()-1;

        input.nextLine();

        for (Map.Entry<Integer, Personnel> entry: listPersonnel.entrySet()) {
            Integer key = entry.getKey();
            Personnel value = entry.getValue();
            if (DepartmentManagement.getDepartmentManagement().listDepartment.get(indexRemove).getName().equals(value.getBelongDepartment()))
                value.setBelongDepartment("none");
                value.setPosition("none");
        }
        DepartmentManagement.getDepartmentManagement().listDepartment.remove(indexRemove);
    }

    public void fixDepartment(){
        System.out.println("Choose Department you want to fix: ");
        for (Department element : DepartmentManagement.getDepartmentManagement().listDepartment) {
            System.out.println(element.getId() +". "+ element.getName() + " Department " );
        }
        int index = input.nextInt()-1;
        input.nextLine();
        Department choiceDepartment = DepartmentManagement.getDepartmentManagement().listDepartment.get(index);

        int choice = -1;
        while (choice !=0){
            System.out.println("what's information you want to dix?");
            System.out.println("1. Name");
            System.out.println("2. Chang the employer of department");
            System.out.println("0. Cancel");
            choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter new ID: ");
                    choiceDepartment.setName(input.nextLine());
                    break;
                case 2:
                    System.out.println("Choose one of them: ");
                    System.out.println("1. Add new employer: ");
                    System.out.println("2. Remove employer: ");
                    int choiceChangeEmp = input.nextInt();
                    switch (choiceChangeEmp){
                        case 1:
                            getPersonnelManagement().addMember();
                            break;
                        case 2:
                            getPersonnelManagement().removeMember();
                            break;
                    }
            }
        }
    }

    public void displayDepartment() {
        String text = "";
        for (Department elements : listDepartment) {
            text += "ID "  + elements.getId() + ": " + elements.getName() + " Department " +
                    "has " + elements.getAmount() + " officer " + "\n";
        }
        System.out.println(text);
    }
}
