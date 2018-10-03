import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LearningGenie {

	/*
	 * the start point point of the program. It links to a txt file and reads it. Then it instantiates a 
	 * tree with default guessNode Dog. Also this part is responsible for the prompt and to let the user 
	 * quit the program if they want. Finally it writes everything in the tree to the file. 
	 */
    public static void main(String [] args) throws IOException {
    		File file = new File("classes.txt");
    		DecisionTree tree = new DecisionTree(file);
        FileWriter out = new FileWriter(file);
        System.out.println("I am the learning genie!");
        System.out.println("I can figure out whatever you are thinking of by asking questions.");
        int number = tree.countObjects(); 
        System.out.println("I know " + number + (number > 1? " things" : " thing"));
        
        Scanner in = new Scanner(System.in);
        String answer;
        do {
        	    System.out.println("\n");
            System.out.println("Think of a class!");
            tree.guess(in);
            System.out.print("Do you want to continue? ");
            answer = in.next();
            while (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no"))) {
                System.out.print("Invalid input, please only use \"Yes\" or \"No\": ");
                answer = in.next();
            }
        } while (answer.equalsIgnoreCase("yes"));
        tree.write(out);
        out.close();
        
    }

}
