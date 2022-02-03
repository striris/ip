import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Task[] tasks = new Task[100];
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String greeting = "----------------------------------------------\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "----------------------------------------------\n";
        String bye = "Bye. Hope to see you again soon!\n";
        System.out.println(greeting);

        while(true){
            String input = sc.nextLine();
            System.out.println("----------------------------------------------");
            if(input.equals("bye")){
                System.out.println(bye);
                break;
            }
            else if(input.equals("list")){
                System.out.println("Here are the tasks in your list:");
                for(int i = 0; i<count ; i++)
                    System.out.println((i + 1) + ".[" + tasks[i].getStatusIcon() + "] " + tasks[i].description);
            }
            else if(input.split(" ")[0].equals("mark")){
                //get the integer k in the string
                System.out.println("Nice! I've marked this task as done:");
                int k = Integer.parseInt(input.split(" ")[1]);
                tasks[k-1].markAsDone();
                System.out.println(k + ".[" + tasks[k-1].getStatusIcon() + "] " + tasks[k-1].description);
            }
            else if(input.split(" ")[0].equals("unmark")){
                //get the integer k in the string
                System.out.println("OK, I've marked this task as not done yet:");
                int k = Integer.parseInt(input.split(" ")[1]);
                tasks[k-1].markAsNotDone();
                System.out.println(k + ".[" + tasks[k-1].getStatusIcon() + "] " + tasks[k-1].description);
            }
            else{
                System.out.println("added: " + input);
                Task t = new Task(input);
                tasks[count] = t;
                count++;
            }
            System.out.println("----------------------------------------------");
        }
    }
}
