import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String name;
    private String description;
    private boolean completed;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return name + " - " + description + " - Completed: " + completed;
    }
}

class TodoApp {
    private ArrayList<Task> tasks;

    public TodoApp() {
        tasks = new ArrayList<>();
    }

    public void addTask(String name, String description) {
        Task task = new Task(name, description);
        tasks.add(task);
    }

    public void completeTask(String name) {
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.setCompleted(true);
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void displayTasks() {
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public static void main(String[] args) {
        TodoApp todoApp = new TodoApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Task\n2. Complete Task\n3. Display Tasks\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    todoApp.addTask(name, description);
                    break;
                case 2:
                    System.out.print("Enter task name to complete: ");
                    String taskName = scanner.nextLine();
                    todoApp.completeTask(taskName);
                    break;
                case 3:
                    todoApp.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
