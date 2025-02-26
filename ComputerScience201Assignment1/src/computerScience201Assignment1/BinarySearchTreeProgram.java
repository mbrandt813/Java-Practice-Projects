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
    /*Options one and two in the menu require the user to be able to add values into
     * the tree. To be able to add values into the tree I will make an inserter. This
     * won't do anything yet because I need to make the insertNode method next to do 
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
    		 * to the left. This part here is recursive and will start the method over.*/
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
    	
    /*Option three in the menu requires the user to be able to delete a node. Here
     * I will create a new method to do that. This will look to the next recursive
     * method deleteNode to find the node in the tree.*/
    	public void delete(int number) {
    		root = deleteNode(root, number);
    	}
    	
    	public Node deleteNode(Node cNode, int number) {
    		//when this returns as true, the number does not exist in the tree.
    		if (cNode == null) {
    			return null;
    		}
    		/*Check if the node is greater then or less then the node we are currently
    		looking at.*/
    		if (number < cNode.data) {
    			cNode.leftCNode = deleteNode(cNode.leftCNode, number);
    		} else if (number > cNode.data) {
    			cNode.rightCNode = deleteNode(cNode.rightCNode, number);
    		} 
    		/*Now that I have found the node I need to decide what to do with it.
    		 * first scenario is if it has no children.*/
    		   else {
    			   if (cNode.leftCNode == null && cNode.rightCNode == null) {
    				   return null;
    			   }
    		/*Now decide what to do if it has one child.*/
    			   if (cNode.leftCNode == null) {
    				   return cNode.rightCNode;
    			   } else if (cNode.rightCNode == null) {
    				   return cNode.leftCNode;
    			   } else {
    			   
    		/*I also need to handle if the node had two children.*/
    			   Node moveUp = findMin(cNode.rightCNode);
    			   cNode.data = moveUp.data; 
    			   cNode.rightCNode = deleteNode(cNode.rightCNode, moveUp.data);
    			   }
    		 }
    		return cNode;
    	}
    	
    	/*In the method above I needed to find the min value in the right side of the
    	 *section of the tree, here I'll make that method to find the lowest value.*/
    	public Node findMin(Node cNode) {
    		while (cNode.leftCNode != null) {
    			cNode = cNode.leftCNode;
    		}
    		return cNode;
    	}
    	
    	/*Options four five and six on the menu should allow the user to print out
    	 * the nodes in certain orders - InOrder, PreOrder, and PostOder. To do that
    	 * I need to make some methods to print them each way.*/
    	//First I'll do in order, printing from the left to the right of the tree.
        public void pInOrder() {
        	inOrder(root);
        	System.out.println();
        }
        public void inOrder(Node cNode) {
        	if (cNode == null) {
        		return;
        	}
        	inOrder(cNode.leftCNode);
        	System.out.print(cNode.data + " ");
        	inOrder(cNode.rightCNode);
        }
        
        /*Next I will do preorder, which will start at the root and go down through the
        children, starting on the left.*/
        public void pPreOrder() {
        	preOrder(root);
        	System.out.println();
        }
        public void preOrder(Node cNode) {
        	if (cNode ==null) {
        		return;
        	}
        	System.out.print(cNode.data + " ");
        	preOrder(cNode.leftCNode);
        	preOrder(cNode.rightCNode);
        }
        /*Last I will do the post order. This will start from the left-most child node
         * and will end with the root.*/
       public void pPostOrder() {
    	   postOrder(root);
    	   System.out.println();
       }
       public void postOrder(Node cNode) {
    	   if (cNode == null) {
    		   return;
    	   }
    	   postOrder(cNode.leftCNode);
    	   postOrder(cNode.rightCNode);
    	   System.out.print(cNode.data + " ");
       }
    }
    
	
	
}
