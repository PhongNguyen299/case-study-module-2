package Personnel;

import Department.Department;
import Department.DepartmentManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class PersonnelManagement<K,V>{
    private static volatile PersonnelManagement personnelManagement;
    public static Map <Integer, Personnel> listPersonnel;
    private static Scanner input = new Scanner(System.in);

    private PersonnelManagement(){
      listPersonnel = new HashMap<>();
        listPersonnel.put(1,new Personnel(1,"Luong","Male","Manager","Finance"));
        listPersonnel.put(2,new Personnel(2,"Hieu","Male","StaffWC","Marketing"));
        listPersonnel.put(3,new Personnel(3,"Phong Xoan","Male","Design","Accounting"));
       listPersonnel.put(4,new Personnel(4,"Hien","Female","Thief","Marketing"));
       listPersonnel.put(5,new Personnel(5,"Vu","Male","Staff","Marketing"));
        listPersonnel.put(6,new Personnel(6,"Tung","Bisexual","Dancer","Accounting"));
        listPersonnel.put(7,new Personnel(7,"Minh","Male","Teacher","Finance"));
        listPersonnel.put(8,new Personnel(8,"Tran","Female","QA","Marketing"));
       listPersonnel.put(9,new Personnel(9,"Si Phong","Male","Boss","Accounting"));
    }

    public static PersonnelManagement getPersonnelManagement(){
        if(personnelManagement == null){
            synchronized (DepartmentManagement.class){
                if (personnelManagement == null){
                    personnelManagement = new PersonnelManagement();
                }
            }
        }
        return personnelManagement;
    }

    public int checkID(int id){
        if(!listPersonnel.isEmpty()){
            while (listPersonnel.containsKey(id)){
                System.out.println("Your Id is exist, please try other id");
                System.out.println("Ids are exist: ");
                for (Map.Entry<Integer, Personnel> entry: listPersonnel.entrySet()) {
                    Integer key = entry.getKey();
                    System.out.print(key + " ");
                }
                System.out.println("\n");
                System.out.print("Enter id: ");
                id = input.nextInt();
                input.nextLine();
            }
        }
        return id;
    };

    public void addMember(){
        System.out.println("Please enter information new member");
        System.out.print("Enter id: ");
        int id =  input.nextInt();
        input.nextLine();
        checkID(id);

        System.out.print("Enter name: ");
        String name = input.nextLine();

        System.out.print("Enter gender: ");
        String gender = input.nextLine();

        System.out.print("Enter position: ");
        String position = input.nextLine();

        System.out.print("Enter Department: ");
        String department = input.nextLine();

        Personnel obj = new Personnel(id,name, gender,position,department);
        listPersonnel.put(id,obj);
        for (Department el: DepartmentManagement.getDepartmentManagement().listDepartment) {
            if (el.getName().equals(department)){
                el.setAmount(el.getAmount()+1);
            }
        }
    }

    public void searchById(){
        System.out.println("Enter Officer's ID you want to search:");
        int idSearch = input.nextInt();
        input.nextLine();
        String textId = "";
        for (Map.Entry<Integer, Personnel> entry: listPersonnel.entrySet()) {
            Integer key = entry.getKey();
            Personnel value = entry.getValue();
            if (idSearch == key){
                textId += key +" "+ value.getName() + " - Gender: "+value.getGender() + " - Position: " + value.getPosition()
                        + " of Department: " +value.getBelongDepartment()+".\n";
            }
        }
        System.out.println(textId);
    }

    public void searchByName(){
        System.out.println("Enter Officer's name you want to search:");
        String nameSearch = input.nextLine();
        String textName = "";
        for (Map.Entry<Integer, Personnel> entry: listPersonnel.entrySet()) {
            Integer key = entry.getKey();
            Personnel value = entry.getValue();
            if (nameSearch.equals(value.getName())){
                textName += key+" "+ value.getName() + " - Gender: "+value.getGender() + " - Position: " + value.getPosition()
                        + " of Department: " +value.getBelongDepartment()+".\n";
            }
        }
        System.out.println(textName);
    }

    public void searchByGender(){
        System.out.println("Enter Officer's name you want to search:");
        String genderSearch = input.nextLine();
        String textGender = "";
        for (Map.Entry<Integer, Personnel> entry: listPersonnel.entrySet()) {
            Integer key = entry.getKey();
            Personnel value = entry.getValue();
            if (genderSearch.equals(value.getGender())){
                textGender += key+" "+ value.getName() + " - Gender: "+value.getGender() + " - Position: " + value.getPosition()
                        + " of Department: " +value.getBelongDepartment()+".\n";
            }
        }
        System.out.println(textGender);
    }

    public void searchByDepartment(){
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
    public void search(){
        int choice = -1;
        while (choice !=0){
            System.out.println("what's information you want to search?");
            System.out.println("1. Id");
            System.out.println("2. Name");
            System.out.println("3. Gender");
            System.out.println("4. Department");
            System.out.println("0. Cancel");
            choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 1: searchById();
                    break;
                case 2: searchByName();
                    break;
                case 3:searchByGender();
                    break;
                case 4: searchByDepartment();
                    break;
            }
        }
    }

    public void removeMember(){
        displayAllMember();
        System.out.print("Enter member you want to remove (by id): ");
        int delId = input.nextInt();
        input.nextLine();
        System.out.print("You want to remove this member:");
        System.out.println(" Yes/No");
        String confirm = input.nextLine().toLowerCase().trim();
        if (confirm.equals("yes")) {
            listPersonnel.remove(delId);
        }
    }

    public void fixMember(){
        displayAllMember();
        System.out.print("Enter member you want to fix (by id): ");
        int fixId = input.nextInt();
        input.nextLine();
        System.out.println(listPersonnel.get(fixId).getName());

        int choice = -1;
        while (choice !=0){
            System.out.println("1. Fix name: ");
            System.out.println("2. Fix position: ");
            System.out.println("3. Fix department: ");
            System.out.println("0. Cancel: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter your name to change: ");
                    String nameReplace = input.nextLine();
                    listPersonnel.get(fixId).setName(nameReplace);
                    break;
                case 2:
                    System.out.println("Enter your position to change: ");
                    String positionReplace = input.nextLine();
                    listPersonnel.get(fixId).setPosition(positionReplace);
                    break;
                case 3:
                    System.out.println("Enter your department to change: ");
                    String departmentReplace = input.nextLine();
                    listPersonnel.get(fixId).setBelongDepartment(departmentReplace);
                    break;
            }
        }
    }

    public void checkInDaily(){
        System.out.print("Please input your ID: ");

        System.out.println("Please input 'HAHA' to check-in");
        String text = input.nextLine().toLowerCase();
        while (!text.equals("haha")){
            System.out.println("Please input again");
        }
        listPersonnel.get(input.nextInt()).checkin();
        input.nextLine();
    }

    public void displaySalary(){
        String text = "";
        for (Map.Entry<Integer, Personnel> entry: listPersonnel.entrySet()) {
            Integer key = entry.getKey();
            Personnel value = entry.getValue();
            String positionS = value.getPosition().toLowerCase();
            switch (positionS){
                case "boss":
                    final double BOSS_SALARY = 30.000;
                    value.setSalary(BOSS_SALARY-value.getAttendance().size()*1.000);
                    text += key+" "+ value.getName() + " || Position: " + value.getPosition()
                             +" || salary : " +value.getSalary()+" per/month"+".\n";
                    break;
                case "manager":
                    final double MANAGER_SALARY = 24.000;
                    value.setSalary(MANAGER_SALARY-value.getAttendance().size()*1.000);
                    text += key+" "+ value.getName() + " || Position: " + value.getPosition()
                            +" || salary : " +value.getSalary()+" per/month"+".\n";
                    break;
                default:
                    final double STAFF_SALARY = 15.000;
                    value.setSalary(STAFF_SALARY-value.getAttendance().size()*1.000);
                    text += key+" "+ value.getName() + " || Position: " + value.getPosition()
                            +" || Salary : " +value.getSalary()+" per/month"+".\n";
                    break;
            }
        }
        System.out.println(text);
    }

    public void displayAllMember() {
        String text = "";
        for (Map.Entry<Integer, Personnel> entry: listPersonnel.entrySet()) {
            Integer key = entry.getKey();
            Personnel value = entry.getValue();
            text += key+"  || "+ value.getName() + "|| Gender: "+value.getGender()+"|| Position: "
                    + value.getPosition() +"|| Department: " +value.getBelongDepartment()+".\n";
        }
        System.out.println(text);
    }
}
