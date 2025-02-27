import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        viewTasks();
                        break;
                    case 3:
                        removeTask();
                        break;
                    case 4:
                        markTaskComplete();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Goodbye!!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== To-Do List Manager ===");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Mark Task as Complete");
        System.out.println("5. Exit");
        System.out.println("Enter your choice (1-5): ");
    }

    private static void addTask() {
        System.out.println("Enter the task:");
        String taskDesc = scanner.nextLine();
        tasks.add(new Task(taskDesc));
        System.out.println("Task added:" + taskDesc);
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No Tasks to remove.");
            return;
        }
        viewTasks();
        System.out.println("Enter the task number to remove.");
        try {
            int taskNumber = scanner.nextInt();
            scanner.nextLine();
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                Task removedTask = tasks.remove(taskNumber - 1);
                System.out.println("Removed task: " + removedTask);
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    private static void markTaskComplete() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to mark.");
            return;
        }
        viewTasks();
        System.out.println("Enter the task number to mark as complete: ");
        try {
        int completeNumber = scanner.nextInt();
        scanner.nextLine();
        if (completeNumber > 0 && completeNumber <= tasks.size()) {
            Task task = tasks.get(completeNumber - 1);
            if (!task.isCompleted()) {
                task.markCompleted();
                System.out.println("Task marked as complete: " + task);
            } else {
                System.out.println("Task is already completed.");
            }
        } else {
            System.out.println("Invalid task number.");
        }
    } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
}


}