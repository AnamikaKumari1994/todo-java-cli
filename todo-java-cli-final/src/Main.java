
import java.util.Scanner;

import service.TaskManager;

public class Main {
    public static void main(String[] args){
        TaskManager manager = new TaskManager("data/tasks.json");
        Scanner sc = new Scanner(System.in);
        System.out.println("TODO List CLI - Commands: add, list, remove, complete, list-category, exit");
        while(true){
            System.out.print("> ");
            String cmd = sc.nextLine().trim();
            switch(cmd){
                case "add":
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter category: ");
                    String cat = sc.nextLine();
                    manager.addTask(desc, cat);
                    break;
                case "list":
                    manager.listTasks();
                    break;
                case "remove":
                    System.out.print("Enter task ID to remove: ");
                    int rid = Integer.parseInt(sc.nextLine());
                    manager.removeTask(rid);
                    break;
                case "complete":
                    System.out.print("Enter task ID to mark as completed: ");
                    int cid = Integer.parseInt(sc.nextLine());
                    manager.markTaskAsCompleted(cid);
                    break;
                case "list-category":
                    System.out.print("Enter category to filter: ");
                    String fcat = sc.nextLine();
                    manager.listTasksByCategory(fcat);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }
}
