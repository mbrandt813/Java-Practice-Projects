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
    	
    /*Correction: Here I will make a method to create a balanced binary tree when the numbers are
     * inserted, regardless of what order they are inserted. */
    public void balancedBTree(int[] numbers) {
    	//Clear out the tree if it was previously filled in.
    	root = null;
    	root = makeBalancedBTree(numbers, 0, numbers.length -1);
    }
    //Determine where to place node in tree.
    public Node makeBalancedBTree(int[] numbers, int begin, int end) {
    	if (begin > end) {
    		return null;
    	}
        int middle = (begin + end) / 2;
        
        Node newNode = new Node(numbers[middle]);
        newNode.leftCNode = makeBalancedBTree(numbers, begin, middle - 1);
        newNode.rightCNode = makeBalancedBTree(numbers, middle + 1, end);
        return newNode;
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
    		if (number < cNode.data) {
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
    	
    	/*Options four, five, and six on the menu should allow the user to print out
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
        
        /*Next I will do pre order, which will start at the root and go down through the
        children, starting on the left.*/
        public void pPreOrder() {
        	preOrder(root);
        	System.out.println();
        }
        public void preOrder(Node cNode) {
        	if (cNode == null) {
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
    
    //Now I will create my main method that will hold the menu.
    public static void main(String[] args) {
    	//Make a scanner instance to get response from user.
    	Scanner scanner = new Scanner(System.in);
    	//Make an empty tree for the numbers to be add into.
    	BTree newTree = new BTree();
    	
    	//I don't want the user to get stuck in the menu so I will make an exit.
    	boolean exitProgramStatus = false;
    	
    	/*Now I will make a while look that will allow the user to pick options 
    	 * from the list until they decide to exit the program.*/
    	while(!exitProgramStatus) {
    		System.out.println("Welcome to the Tree Builder!");
    		System.out.println("Select an option from the menu below.");
    		System.out.println("1. Create a binary search tree.");
    		System.out.println("2. Add a node.");
    		System.out.println("3. Delete a node.");
    		System.out.println("4. Print nodes by InOrder .");
    		System.out.println("5. Print nodes by PreOrder.");
    		System.out.println("6. Print nodes by PostOrder.");
    		System.out.println("7. Exit program.");
    		System.out.println("Selection: ");
    		
    		//Collect the answer from the user.
    		int choice = scanner.nextInt();
    		
    		/*I will use a switch statement to use the correct methods based on the 
    		 * users response.*/
    		switch (choice) {
    		/*If they pick one, I will create the binary search tree with the numbers 
    		provided in the assignment.*/
    		case 1:
    			int[] treeNumbers = {1,2,3,4,5,6,7};
    			newTree.balancedBTree(treeNumbers);
    			
    			System.out.println("New binary search tree created!");
    			break;
    			
    		case 2: 
    			/*If they pick two, I will ask them what number they want to add to the tree
    			and add it as a new node.*/
    			System.out.println("Enter a number to add to the tree: ");
    			int newNumber = scanner.nextInt();
    			newTree.insert(newNumber);
    			System.out.println("A new node " + newNumber + " was added to the tree!");
    			break;
    			
    		case 3:
    			/*If they pick three, I will ask them what number they want to delete from the tree
    			and use the delete method to remove it.*/
    			System.out.println("Enter a number to delete from the tree: ");
    			int deleteNumber = scanner.nextInt();
    			newTree.delete(deleteNumber);
    			System.out.println("A node " + deleteNumber + " was deleted from the tree!");
    			break;
    			
    		case 4:
    			//If they pick four, I will use the pInOrder method to display the tree by InOrder.
    			System.out.print("The tree in InOrder: ");
    			newTree.pInOrder();
    			break;
    			
    		case 5:
    			//If they pick five, I will use the pPreOrder method to display the tree by PreOrder.
    			System.out.print("The tree in PreOrder: ");
    			newTree.pPreOrder();
    			break;
    			
    		case 6:
    			//If they pick five, I will use the pPostOrder method to display the tree by PostOrder.
    			System.out.print("The tree in PostOrder: ");
    			newTree.pPostOrder();
    			break;
    			
    		case 7:
    			//If they pick five, I will use the pPostOrder method to display the tree by PostOrder.
    			exitProgramStatus = true;
    			System.out.print("Thank you for making a tree!");
    			break;
    			
    		default:
    			System.out.print("That is not a valid option, try again: ");
    			break;
    		}
    	}
    	
    }	
}
