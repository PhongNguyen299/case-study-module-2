package Project;

import Department.Department;
import Department.DepartmentManagement;
import Personnel.Personnel;

import java.util.*;

import static Personnel.PersonnelManagement.listPersonnel;

public final class ProjectManagement {

    private volatile static ProjectManagement projectManagement;

    public List <Project> listProject;
    ProjectManagement (){
        listProject = new LinkedList<Project>();
        listProject.add(new Project(1,"autoFix","auto find and fix bug","1/1/2023"));
        listProject.add(new Project(2,"skyCar","creat Car can fly","9/9/2023"));
    };

    public static ProjectManagement getProjectManagement(){
        if(projectManagement == null){
            synchronized (ProjectManagement.class){
                if (projectManagement == null){
                    projectManagement = new ProjectManagement();
                }
            }
        }
        return projectManagement;
    }

    Scanner input = new Scanner(System.in);
    public void addProject(){
        System.out.println("Please Enter new project");
        System.out.print("Enter id: ");
        int id =  input.nextInt();
        input.nextLine();
        List arr = new ArrayList();
        for (Project project: listProject) {
            arr.add(project.getId());
            while (arr.contains(id)){
                System.out.println("Your Id is exist, please try other id");
                System.out.println("Ids are exist: ");
                for (Project element: listProject) {
                    System.out.println("ID: " + element.getId());
                }
                System.out.print("\n");
                System.out.print("Enter id: ");
                id = input.nextInt();
                input.nextLine();
            }
        }
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter description: ");
        String description = input.nextLine();
        System.out.print("Enter startTime: ");
        String startTime = input.nextLine();
        System.out.println("You want to choose department responsible");
        System.out.println("Yes/No");
        String answer = input.nextLine().toLowerCase();
        if (answer.equals("yes")){
            DepartmentManagement.getDepartmentManagement().displayDepartment();
            System.out.print("Choose Department: ");
            int choice = input.nextInt();
            input.nextLine();
            listProject.add(new Project(id,name,description,startTime,DepartmentManagement.getDepartmentManagement().listDepartment.get(choice)));
        } else {
            listProject.add(new Project(id,name,description,startTime));
        }
    }

    public void search(){
        int choice = -1;
        while (choice !=0){
            System.out.println("what's information you want to search?");
            System.out.println("1. Id");
            System.out.println("2. Name");
            System.out.println("0. Cancel");
            choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter Project's ID you want to search:");
                    int idSearch = input.nextInt();
                    input.nextLine();
                    String textId = "";
                    for (Project element: listProject) {
                        if (element.getId() == idSearch) {
                            textId += element.getId() +" "+ element.getName() + " - Department responsible: "
                                    +element.getDepartmentResponsible() + " - Processing: " + element.getProcess();
                        }
                    }
                    System.out.println(textId);
                    break;
                case 2:
                    System.out.println("Enter Project's name you want to search:");
                    String nameSearch = input.nextLine();
                    String textName = "";
                    for (Project element: listProject) {
                        if (element.getName().equals(nameSearch)) {
                            textName += element.getId() +" "+ element.getName() + " - Department responsible: "
                                    +element.getDepartmentResponsible() + " - Processing: " + element.getProcess();
                        }
                    }
                    System.out.println(textName);
                    break;
            }
        }
    }

    public void displayProject(){
        for (Project element: listProject) {
            System.out.println("ID:" + element.getId()+ " || Project: " + element.getName() +" || Description: "
            + element.getDescription() +" || status: " + element.getProcess());
        }
    }

    public void removeProject(){
        System.out.println("Choose project you want to remove: ");
        for (Project element : ProjectManagement.getProjectManagement().listProject) {
            System.out.println(element.getId() +". "+ element.getName() + " Department " );
        }
        int index = input.nextInt()-1;
        input.nextLine();
        projectManagement.listProject.remove(index);
    }
}
