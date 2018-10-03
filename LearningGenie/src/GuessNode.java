import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuessNode implements DecisionNode{
    private String guess;
    public DecisionNode yes;
    public DecisionNode no;
    public GuessNode(String guess) {
        this.guess = guess;
        yes = null;
        no = null;
    }



	public int countObjects() {
		return 1;
	}


	public DecisionNode guess(Scanner in) {
		System.out.print("Are you thinking of " + guess + "? ");
		String answer = in.next();
		while (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no"))) {
		    System.out.print("Invalid input, please only use \"Yes\" or \"No\": ");
		    answer = in.next();
        }

		if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Excellent, thanks!");
            return this;
        } else {
		    System.out.println("Oh no, I was wrong!");
            System.out.print("What were you thinking of? ");
            in.nextLine();
            String newThing = in.nextLine();
            System.out.print("What is a yes/no question that distinguishes a " + guess +" from a " + newThing + "?\n");
            System.out.print("(Yes corresponds to "+ guess + "; No corresponds to " + newThing + ") ");
            //
            //
            //
            String question = in.nextLine();
            //
            //
            //
            System.out.println("Thanks!  I'll learn from this experience!");
            //build the new node
            QuestionNode questionNode = new QuestionNode(question);
            questionNode.yes = this;
            questionNode.no = new GuessNode(newThing);
            return questionNode;
        }
	}

	public void write(FileWriter out) throws IOException {
		out.write(guess);
	}

	public DecisionNode getYes () {
        return yes;
    }


    public DecisionNode getNo() {
        return no;
    }




	public void setYes(DecisionNode node) {
		this.yes = node; 
		
	}

	
	public void setNo(DecisionNode node) {
		this.no = node; 
	}

}
