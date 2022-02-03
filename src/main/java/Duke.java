import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        String[] tasks = new String[100];
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String greeting = "----------------------\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "----------------------\n";
        String bye = "Bye. Hope to see you again soon!\n";
        System.out.println(greeting);

        while(true){
            String input = sc.nextLine();
            System.out.println("----------------------");
            if(input.equals("bye")){
                System.out.println(bye);
                break;
            }
            else if(input.equals("list")){
                for(int i = 0; i<count ; i++){
                    System.out.println((i+1) + ". " + tasks[i]);
                }
            }
            else{
                System.out.println("added: " + input);
                tasks[count] = input;
                count++;
            }
            System.out.println("----------------------");
        }
    }
}
