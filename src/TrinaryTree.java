public class TrinaryTree {

	public static void main(String[] args) {
		new TrinaryTree().run();
	}

	// *************************************************************************
	// TestCase1 Test insert.
	public void TestCase1(Node root) {
		// Test Insert.
		System.out.println("Test Case 1.");
		insert(root, 4);
		insert(root, 9);
		insert(root, 5);
		insert(root, 7);
		insert(root, 2);
		insert(root, 10);
		insert(root, 12);
		insert(root, 1);
		insert(root, 20);
		insert(root, 15);
		insert(root, 3);
		System.out.println("Test Insert, Inserted 4,9,5,7,2,10,12,1,20,15,3.");
		printInOrder(root);
		System.out.println("End of TestCase 1.");
	}

	// ***********************************************************************
	// TestCase1a Test random deletes.
	//
	public void TestCase1a(Node root) {
		System.out.println("Test Case 1a. ");
		printInOrder(root);
		System.out.println("Current tree.");
		delete(root, 9);
		System.out.println("After 9 deleted.");
		printInOrder(root);
		delete(root, 2);
		System.out.println("After 2 deleted.");
		printInOrder(root);
		delete(root, 20);
		System.out.println("After 20 deleted.");
		printInOrder(root);
		delete(root, 5);
		System.out.println("After 5 deleted.");
		printInOrder(root);
		delete(root, 5);
		System.out.println("After 5 deleted.");
		printInOrder(root);
		delete(root, 4);
		System.out.println("After 4 deleted.");
		printInOrder(root);
		delete(root, 10);
		System.out.println("After 10 deleted.");
		printInOrder(root);
		delete(root, 7);
		System.out.println("After 7 deleted.");
		printInOrder(root);
		delete(root, 12);
		System.out.println("After 12 deleted.");
		printInOrder(root);
		System.out.println("End of TestCase 2.");
		delete(root, 3);
		System.out.println("After 3 deleted.");
		printInOrder(root);
		delete(root, 1);
		System.out.println("After 1 deleted.");
		printInOrder(root);
		delete(root, 15);
		System.out.println("After 15 deleted.");
		printInOrder(root);
		// Tree should have -1 in it as that's the flag for an empty tree.
		insert(root, 21);
		delete(root, -1);
		printInOrder(root);
		System.out.println("End of Test case 1a.");
	}

	// ***********************************************************************
	// TestCase2 Test random deletes.
	//
	public void TestCase2(Node root) {
		System.out.println("Test Case 2. ");
		printInOrder(root);
		System.out.println("Current tree.");
		delete(root, 15);
		System.out.println("After 15 deleted.");
		printInOrder(root);
		delete(root, 7);
		delete(root, 5);
		delete(root, 5);
		System.out.println("Just before deleting 2.");
		printInOrder(root);
		delete(root, 2);
		delete(root, 9);
		delete(root, 4);
		System.out.println("After Deleting 4.");
		printInOrder(root);
		delete(root, 12);
		delete(root, 3);
		delete(root, 20);
		delete(root, 1);
		System.out.println("Final Printing.");
		printInOrder(root);
		System.out
				.println("Test Random Deletes. Delete 4,7,5,5,2,9,15.12.3.20.1");
		System.out.println("End of TestCase 2.");
	}

	// ***********************************************************************
	// TestCase3 Test Deletion of multiple like numbers.
	public void TestCase3(Node root) {
		System.out.println("Test Case #3");
		insert(root, 55);
		insert(root, 65);
		insert(root, 101);
		insert(root, 34);
		insert(root, 55);
		insert(root, 65);
		insert(root, 101);
		insert(root, 34);
		insert(root, 55);
		insert(root, 65);
		insert(root, 101);
		insert(root, 34);
		System.out.println("Test deletion of multiple like numbers.");
		printInOrder(root);
		delete(root, 55);
		delete(root, 65);
		delete(root, 101);
		delete(root, 34);
		System.out.println("Should be missing one set of 55,65,101,34.");
		printInOrder(root);
		delete(root, 55);
		delete(root, 65);
		delete(root, 101);
		delete(root, 34);
		delete(root, 55);
		delete(root, 65);
		delete(root, 101);
		delete(root, 34);
		delete(root, 55);
		delete(root, 65);
		delete(root, 101);
		delete(root, 34);
		System.out.println("Shouldn't be any numbers of 55,65,101,34.");
		printInOrder(root);
		System.out.println("End of TestCase 3.");
	}

	// ***********************************************************************
	// Test program.
	// Make sure everything works. Needs more testing than just this for user.
	public void run() {
		Node root = new Node(5);
		System.out.println("Building tree with root value " + root.value);
		printInOrder(root);
		TestCase1(root);
		TestCase1a(root);
		TestCase1(root);
		TestCase2(root);
		TestCase1(root);
		TestCase3(root);
	}

	// ***********************************************************************
	// Node structure used for trinary tree.
	static class Node { // Class node.
		Node left;
		Node middle; // Third branch to make it a trinary tree.
		Node right;
		Node parent; // Added parent to help make the delete easier.

		int value;

		public Node(int value) {
			this.parent = null; // Initialize variables.
			this.left = null;
			this.right = null;
			this.middle = null;
			this.value = value;
		}
	}// end of class Node.

	// ***********************************************************
	// insert(Node,int);
	// Insert a node into a trinary tree.
	public void insert(Node node, int value) {
		if (value < node.value) {
			if (node.left != null) {
				insert(node.left, value);
			} else {
				System.out.println(" Inserted " + value + " to left of "
						+ node.value);
				node.left = new Node(value);
				node.left.parent = node;
			}
		} else if (value > node.value) {
			if (node.right != null) {
				insert(node.right, value);
			} else {
				System.out.println(" Inserted " + value + " to right of "
						+ node.value);
				node.right = new Node(value);
				node.right.parent = node;
			}
		} else if (value == node.value) {
			if (node.middle != null) {
				insert(node.middle, value);
			} else {
				System.out.println(" Inserted " + value + " to middle of "
						+ node.value);
				node.middle = new Node(value);
				node.middle.parent = node;
			}
		}
	}

	// ************************************************************
	// printInOrder(Node);
	// Print function to print trinary tree in order of value.
	public void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.print(" Traversed " + node.value);
			if (node.parent != null)
				System.out.println(" - Parent is " + node.parent.value);
			else
				System.out.println("");
			printInOrder(node.middle);
			printInOrder(node.right);
		}
	}

	// **************************************************************
	// printFrontToBack(Node, value);
	// uses in-order traversal when the origin is less than the node's value
	// uses reverse-order traversal when the origin is greater than the node's
	// order
	public void printFrontToBack(Node node, int value) {
		if (node == null)
			return;
		if (node.value > value) {
			// print in order.
			printFrontToBack(node.left, value);
			System.out.println(" Traversed " + node.value);
			printFrontToBack(node.right, value);
		} else if (node.value < value) {
			// print reverse order.
			printFrontToBack(node.right, value);
			System.out.println(" Traversed " + node.value);
			printFrontToBack(node.left, value);
		} else {
			// order doesn't matter.
			printFrontToBack(node.left, value);
			printFrontToBack(node.right, value);
		}
	}

	// *********************************************************************
	// boolean findNode(Node, int);
	// tells if a particular value is within trinary tree.
	// return true if value found, false if not found.
	public boolean findNode(Node node, int value) {
		System.out.println("Searching for " + value);
		if (node != null) {
			if (node.value == value) {
				if (node.middle != null) {
					return (findNode(node.middle, value));
				} else {
					System.out.println("Found node, " + node.value);
					return true;
				}
			}
			if (value < node.value) {
				System.out.println("Searching left of " + node.value);
				return findNode(node.left, value);
			}
			if (value > node.value) {
				System.out.println("Searching right of " + node.value);
				return findNode(node.right, value);
			}
		}
		return false;
	}

	// **************************************************************************
	// Finds the next node, successor, give a target node.
	public Node findSuccessor(Node node) {
		Node successNode = null;
		if (node.right != null)
			successNode = findMin(node.right);
		else {
			if (node.parent.left == node) {
				successNode = node.parent;
			} else {
				node.parent.right = null;
				successNode = findSuccessor(node.parent);
				node.parent.right = node;
			}
		}
		return successNode;
	}

	// ********************************************************
	// findMin(Node)
	// finds the next minimum value from a target node.
	public Node findMin(Node node) {
		Node min = node;
		while (min.left != null)
			min = min.left;
		return min;
	}

	public Node findMax(Node node) {
		Node max = node;
		while (max.right != null)
			max = max.right;
		return max;
	}

	// *******************************************************************
	// boolean delete(Node,int);
	// for the delete we can pretty much implement a binary tree because a
	// middle branch will always be the same value as its parent.
	// returns true if the value was deleted, otherwise false.
	// When the deleted node is the root this routine copies instead of deleting
	// because the root node was allocated elsewhere and we
	// want to keep it intact.
	public boolean delete(Node node, int value) // delete node with given key
	{
		if (node == null)
			return false;
		Node current = node;
		boolean isLeftChild = true;
		while (current.value != value) { // search for node
			if (value < current.value) { // go left?
				isLeftChild = true;
				current = current.left;
			} else if (value > current.value) { // or go right?
				isLeftChild = false;
				current = current.right;
			}
			if (current == null) // end of the line,
				return false; // didn't find it
		} // end while
			// found node to delete
			// if the node has a middle branch then we just find the last leaf
			// and delete it. There will be no left and rights on a middle
			// branch.
			// After that we can treat it like a normal binary tree.
		if (current.middle != null) {
			while (current.middle != null) {
				current = current.middle;
			}
			current.parent.middle = null; // Delete the lowest middle node.
			return true;
		}

		// if no children, simply delete it
		if (current.left == null && current.right == null) {
			if (current.parent != null) {
				if (current.parent.left == current) {
					current.parent.left = null;
				}
				if (current.parent.right == current) {
					current.parent.right = null;
				}
				return true;
			} else {
				node.value = -1; // tree is empty. Since the main node was
									// created in the main program I flag it
									// with a -1.
			}
		}
		// if no right child, replace with left subtree
		else if (current.right == null) {
			if (current == node) {
				node.value = current.left.value;
				if (current.left.middle != null) {
					node.middle = current.left.middle;
					current.left.middle.parent = node;
				}
				delete(current.left, current.left.value);
			} else if (isLeftChild) {
				current.parent.left = current.left;
				current.left.parent = current.parent;
				if (current.left.middle != null) {
					current.parent.middle = current.left.middle;
					current.left.middle.parent = current.parent;
				}
			} else {
				current.parent.right = current.left;
				current.left.parent = current.parent;
				if (current.left.middle != null) {
					current.parent.middle = current.left.middle;
					current.left.middle.parent = current.parent;
				}
			}
			// if no left child, replace with right subtree
		} else if (current.left == null) {
			if (current == node) {
				current.value = current.right.value;
				if (current.right.middle != null) {
					current.middle = current.right.middle;
					current.right.middle.parent = current;
				}
				delete(current.right, current.right.value);
			} else if (isLeftChild) {
				current.parent.left = current.right;
				current.right.parent = current.parent;
			} else {
				current.parent.right = current.right;
				current.right.parent = current.parent;
			}
		} else { // two children, so replace with inorder successor
			// get successor of node to delete current.
			Node successor = findSuccessor(current);
			// connect parent of current to successor instead
			if (current == node) // equal to root.
			{
				current.value = successor.value;
				current.middle = successor.middle;
				if (successor.middle != null)
					successor.middle.parent = current;
				delete(successor, successor.value);
				// Since dedicated root just copy the node.
			} else if (isLeftChild) {
				successor = findMax(current.left);
				current.value = successor.value;
				if (successor.middle != null) {
					current.middle = successor.middle;
					successor.middle.parent = current;
				}
				delete(successor, successor.value);
			} else {
				successor = findMin(current.right);
				current.value = successor.value;
				if (successor.middle != null) {
					current.middle = successor.middle;
					successor.middle.parent = current;
				}
				delete(successor, successor.value);
			}
			// connect successor to current's left child
		} // end else two children
		return true; // success
	} // end delete()
}

// END.
