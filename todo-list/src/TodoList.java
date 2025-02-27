import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    public static void main(String[] args) {

        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTo-Do List Manager");
            System.out.println("1. Add task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");
            System.out.println("Enter your choice (1-5): ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter the task:");
                String taskDesc = scanner.nextLine();
                tasks.add(new Task(taskDesc));
                System.out.println("Task added:" + taskDesc);
                break;
            case 2:
                if (tasks.isEmpty()) {
                    System.out.println("No tasks to display.");
                } else {
                    System.out.println("\nYour Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                }
                break;
            case 3:
                if (tasks.isEmpty()) {
                    System.out.println("No Tasks to remove.");
                } else {
                    System.out.println("\nYour Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    System.out.println("Enter the task number to remove.");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine();
                    if (taskNumber > 0 && taskNumber <= tasks.size()) {
                        Task removedTask = tasks.remove(taskNumber - 1);
                        System.out.println("Removed task: " + removedTask);
                    } else {
                        System.out.println("Invalid task number.");
                    }
                }
                break;
            case 4:
                if (tasks.isEmpty()) {
                    System.out.println("No tasks to mark.");
                } else {
                    System.out.println("\nYour Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    System.out.println("Enter the task number to mark as complete: ");
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
                }
                break;
            case 5:
                running = false;
                System.out.println("Goodbye!!");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }
        scanner.close();
}
}