import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String greeting = "----------------------\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "----------------------\n";
        String bye = "Bye. Hope to see you again soon!\n";
        System.out.println(greeting);

        String input = sc.next();
        while(true){
            if(input.equals("bye")){
                System.out.println(bye);
                break;
            }
            else{
                System.out.println(input);
                input = sc.next();
            }
        }
    }
}
