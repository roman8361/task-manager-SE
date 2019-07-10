package ru.kravchenko.tm;

import ru.kravchenko.tm.constant.CommandConstant;
import ru.kravchenko.tm.repository.ProjectServiceBean;
import ru.kravchenko.tm.repository.TaskServiceBean;

import java.util.Scanner;

/**
 * @author Roman Kravchenko
 */

public class App {

    private static ProjectServiceBean projectServiceBean = ProjectServiceBean.getInstance();

    private static TaskServiceBean taskServiceBean = TaskServiceBean.getInstance();

     public static void main( String[] args ) {

         System.out.println("*** WELCOME TO TASK MANAGER ***");

         while (true) {
             Scanner scanner = new Scanner(System.in);
             System.out.println("Please enter command (help: Show all command) :");
             String userSelect = scanner.next();

             switch(userSelect) {

                 case CommandConstant.HELP :
                     projectServiceBean.showAllCommand();
                     break;

                 case CommandConstant.EXIT :
                     System.out.println("Good bay! Came back later...");
                     projectServiceBean.exit();

                 case CommandConstant.PROJECT_CREATE :
                     projectServiceBean.createProject();
                     System.out.println("Project is create");
                     break;

                 case CommandConstant.PROJECT_LIST :
                     projectServiceBean.showAllProject();
                     break;

                 case CommandConstant.PROJECT_REMOVE :
                     projectServiceBean.removeById(projectServiceBean.getIdFromUser());
                     System.out.println("Project remove...");
                     break;

                 case CommandConstant.PROJECT_CLEAR :
                     projectServiceBean.removeAllProject();
                     System.out.println("All project is remove");
                     break;

                 case CommandConstant.FIND_PROJECT : // тестовая команда
                     projectServiceBean.findByIdProject();
                     break;

                 case CommandConstant.TASK_CREATE :
                     taskServiceBean.createTask();
                     System.out.println("Task is create");
                     break;

                 case CommandConstant.TASK_LIST :
                     taskServiceBean.showAllTask();
                     break;

                 case CommandConstant.TASK_REMOVE :
                     taskServiceBean.removeById(taskServiceBean.getIdFromUser());
                     System.out.println("Task remove...");
                     break;

                 case CommandConstant.TASK_CLEAR :
                     taskServiceBean.removeAllTask();
                     System.out.println("All task is remove");
                     break;

                 default :
                     System.out.println("Unidentified command, please try again");
             }
         }
    }

}
