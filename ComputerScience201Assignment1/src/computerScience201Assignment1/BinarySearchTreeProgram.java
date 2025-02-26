package computerScience201Assignment1;

//I want to get input from the user so I will import the scanner class.
import java.util.Scanner;

public class BinarySearchTreeProgram {
	/*First I need to create my node class and constructor. The node class will
	hold the data and the left and right child nodes. */
	static class Node {
		int data;
		Node leftCNode;
		Node rightCNode;
		//Node constructor class. Nodes start with null children.
		Node(int data) {
			this.data = data;
			this.leftCNode = null;
			this.rightCNode = null;
		}
	}
	
	/*Now I need to make a class and constructor for the tree.*/
    static class BTree {
    	Node root;
    	
    	public BTree() {
    		root = null;
    	}
    /*I want to be able to add values into the tree so I will make an inserter. This
     * wont do anything yet because I need to make the insertNode method next to do 
     * recursive piece.*/
    	public void insert(int number) {
    		root = insertNode(root, number);
    	}
    	
    	public Node insertNode(Node cNode, int number) {
    		//If the node we are looking at here is empty I will add the node in here.
    		if (cNode == null) {
    			return new Node(number);
    		}
    		/*If the number is less than the node we are looking at i will add it 
    		 * to the left. This part here is recursive and will start the method over. */
    		if (number > cNode.data) {
    			cNode.leftCNode = insertNode(cNode.leftCNode, number);
    		}
    		/*If the number is greater then the node we are looking at I will add it
    		 * to the right. This is also recursive.
    		 */
    		else if (number > cNode.data) {
    			cNode.rightCNode = insertNode(cNode.rightCNode, number);
    		}
    		return cNode;
    	}
    }
    
	
	
}
