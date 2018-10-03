import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public interface DecisionNode {
	/*
	 * @param: counts how many guessNode this DecisionNode is
	 * @return: int, 1 if this.getClass() = guessNode.class;
	 *               0 if this.getClass() = questionNode.class;
	 */
	public int countObjects();
	
	/*performs the guessing game starting at this node using the given Scannerobject to query 
	 *the user for input; returns an updated node that is the result of any knowledge learned 
	 *during the game.
	 * @param: in, the Scanner
	 * @return: the updated node
	 */
	public DecisionNode guess(Scanner in);
	
	/* writes this node in the serialized format described above to out. 
	 * @param: out, the FileWriter linked to the given file. 
	 * @return: nothing, call for side effect. 
	 */
	public void write(FileWriter out) throws IOException;
	
	/* get the node of yes field. 
	 * @param: nothing
	 * @return: yes, a DecisionNode
	 */
	public DecisionNode getYes();
	
	/* get the node of no field. 
	 * @param: nothing
	 * @return: yes, a DecisionNode
	 */
    public DecisionNode getNo();
    
    /* reset the value of yes field. 
	 * @param: node, a new value
	 * @return: nothing, call for the side effect. 
	 */
    public void setYes(DecisionNode node); 
    
    /* reset the value of no field. 
	 * @param: node, a new value
	 * @return: nothing, call for the side effect. 
	 */
    public void setNo(DecisionNode node);
}
