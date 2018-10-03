import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DecisionTree {
	private DecisionNode root;


	public int countObjects() {
		return root.countObjects();
	}


	public void guess(Scanner in) {
		root = root.guess(in);
	}

	private void writeH (DecisionNode cur, FileWriter out) throws IOException {
		if (cur != null) {
			cur.write(out);
			out.write("\n");
			writeH(cur.getYes(), out);
			writeH(cur.getNo(), out);
		}
	}
	public void write(FileWriter out) throws IOException {
		writeH(root, out);

	}
	public DecisionTree() {
		root = new GuessNode("Dog");
	}

	private DecisionNode constructorH(Scanner in) {
		if (in.hasNext()) {
			String present = in.nextLine();
			if(present.charAt(0) == '#') {//this line is a question
				QuestionNode cur = new QuestionNode(present.substring(1));
				cur.setYes(constructorH(in));
				cur.setNo(constructorH(in));
				return cur;
			} else {//this line is a guess
				return new GuessNode(present);
			}
		} else {
			return null;
		}
	}

	public DecisionTree(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		if (!(in.hasNext())) {
			root = new GuessNode("Dog");
		} else {
			this.root = constructorH(in);
		}
	}
}
























