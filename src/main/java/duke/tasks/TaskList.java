package duke.tasks;

import duke.Storage;
import duke.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    private static ArrayList<Task> tasks;
    private Storage storage;
    private Ui ui;

    public TaskList(Storage storage) {
        tasks = new ArrayList<>();
        this.storage = storage;
    }

    public void loadTaskList() throws IOException {
        try {
            tasks = storage.loadFile();
        } catch (IOException e) {
            throw e;
        }
    }

    public void processTasks() throws IOException {
        Scanner sc = new Scanner(System.in);
        String by = new String();
        String at = new String();

            while(true){
                String userInput = sc.nextLine();
                String choice = userInput.split(" ")[0];

                System.out.println("----------------------------------------------");
                if(userInput.equals("bye")) {
                    Storage.saveFile(tasks);
                    break;
                }
                else if(userInput.equals("list")) {
                    listTask();
                }
                else if(choice.equals("mark")) {
                    int taskIndex = Integer.parseInt(userInput.split(" ")[1]);
                    markTask(taskIndex);
                }
                else if(choice.equals("unmark")) {
                    int taskIndex = Integer.parseInt(userInput.split(" ")[1]);
                    unmarkTask(taskIndex);
                }
                else if(choice.equals("todo")) {
                    String toDoDescription = userInput.split("todo")[1].trim();
                    Task t = new ToDo(toDoDescription, false);
                    addTask(t);
                }
                else if(choice.equals("deadline")) {
                    String[] input = userInput.split("/by");
                    by = input[1].trim();
                    String deadlineDescription = input[0].split("deadline")[1].trim();
                    Task d = new Deadline(deadlineDescription, false, by);
                    addTask(d);
                }
                else if(choice.equals("event")) {
                    String[] input = userInput.split("/at");
                    at = input[1].trim();
                    String eventDescription = input[0].split("event")[1].trim();
                    Task e = new Event(eventDescription, false, at);
                    addTask(e);
                }
                else if(choice.equals("delete")) {
                    int taskIndex = Integer.parseInt(userInput.split(" ")[1]);
                    deleteTask(taskIndex);
                }
                else{
                    System.out.println("I don't understand D:");
                }
                System.out.println("----------------------------------------------");
            }
    }

    public void listTask() {
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; i<tasks.size() ; i++)
            System.out.println(i+1 + "." + tasks.get(i));
    }

    private static void markTask(int taskIndex) {
        System.out.println("Nice! I've marked this task as done:");
        tasks.get(taskIndex-1).markAsDone();
        System.out.println(tasks.get(taskIndex-1));
    }

    private static void unmarkTask(int taskIndex) {
        System.out.println("OK, I've marked this task as not done yet:");
        tasks.get(taskIndex-1).markAsNotDone();
        System.out.println(tasks.get(taskIndex-1));
    }

    private static void addTask(Task t) {
        tasks.add(t);
        System.out.println("Got it! I've added this task: ");
        System.out.println(t);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    private static void deleteTask(int taskIndex) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(tasks.get(taskIndex -1));
        tasks.remove(taskIndex -1);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}
