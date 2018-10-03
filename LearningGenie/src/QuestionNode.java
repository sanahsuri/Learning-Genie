import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuestionNode implements DecisionNode{

    private String question;
    public DecisionNode yes;
    public DecisionNode no;
    public QuestionNode(String question) {
        this.question = question;
        yes = null;
        no = null;
    }


	public int countObjects() {
		return (yes.countObjects() + no.countObjects());
	}

	public DecisionNode guess(Scanner in) {
		System.out.print(question + " ");
        String answer = in.next();
        while (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no"))) {
            System.out.print("Invalid input, please only use \"Yes\" or \"No\": ");
            answer = in.next();
        }

        if (answer.equalsIgnoreCase("yes")) {
        	this.yes = this.yes.guess(in);
        } else {
            this.no= this.no.guess(in); 
        }
        
        return this; 
	}

	public void write(FileWriter out) throws IOException {
		out.write("#");
		out.write(question);
	}

    public DecisionNode getYes() {
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
