import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Task[] tasks = new Task[100];
        String by = new String();
        String at = new String();
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String greeting = "----------------------------------------------\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "----------------------------------------------\n";
        String bye = "Bye. Hope to see you again soon!\n";
        System.out.println(greeting);

        while(true){
            String userInput = sc.nextLine();
            System.out.println("----------------------------------------------");
            if(userInput.equals("bye")){
                System.out.println(bye);
                break;
            }
            else if(userInput.equals("list")){//show list
                System.out.println("Here are the tasks in your list:");
                for(int i = 0; i<count ; i++)
                    System.out.println(i+1 + "." + tasks[i]);
            }
            else if(userInput.split(" ")[0].equals("mark")){//mark task
                //get the integer k in the string
                System.out.println("Nice! I've marked this task as done:");
                int k = Integer.parseInt(userInput.split(" ")[1]);
                tasks[k-1].markAsDone();
                System.out.println(tasks[k-1]);
            }
            else if(userInput.split(" ")[0].equals("unmark")){//unmark task
                //get the integer k in the string
                System.out.println("OK, I've marked this task as not done yet:");
                int k = Integer.parseInt(userInput.split(" ")[1]);
                tasks[k-1].markAsNotDone();
                System.out.println(tasks[k-1]);
            }
            else if(userInput.startsWith("todo")){
                String toDoDescription = userInput.split("todo")[1].trim();
                Task t = new ToDo(toDoDescription);
                tasks[count] = t;
                count++;
                System.out.println("Got it! I've added this task: ");
                System.out.println(t);
                System.out.println("Now you have " + count + " tasks in the list.");
            }
            else if(userInput.split(" ")[0].equals("deadline")){//add deadline
                //split description and time
                String[] input = userInput.split("/by");
                by = input[1].trim();
                String deadlineDescription = input[0].split("deadline")[1].trim();
                Task d = new Deadline(deadlineDescription, by);
                tasks[count] = d;
                count++;
                System.out.println("Got it! I've added this task: ");
                System.out.println(d);
                System.out.println("Now you have " + count + " tasks in the list.");
            }
            else if(userInput.split(" ")[0].equals("event")){//add deadline
                //split description and time
                String[] input = userInput.split("/at");
                at = input[1].trim();
                String eventDescription = input[0].split("event")[1].trim();
                Task e = new Event(eventDescription, at);
                tasks[count] = e;
                count++;
                System.out.println("Got it! I've added this task: ");
                System.out.println(e);
                System.out.println("Now you have " + count + " tasks in the list.");
            }
            else{
                System.out.println("I don't understand D:");
            }
            System.out.println("----------------------------------------------");
        }
    }
}
