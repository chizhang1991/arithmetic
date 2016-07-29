// binary tree
// 
/////////////////////////
class Node {
	public int data;
	public Node leftChild;
	public Node rightChild;

	public Node(int value) {
		data = value;
		leftChild = null;
		rightChild = null;
	}

	public void displayNode() {
		System.out.print(data + " ");
	}
}

class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	public void insert(int datavalue) {
		Node temp = new Node(datavalue);
		Node current = root;
		Node parent = root;
		// empty tree, insert in root
		if (root == null) {
			System.out.println ("Insert the root");
			root = temp;
		}
		// tree not empty, find the proper place
		else {
			//find where to insert
			while (true) {
				parent = current;
				// smaller goes left
				if (datavalue < current.data) {
					System.out.println("Insert, Go left");
					// parent = current;
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = temp;
						return;
					}
				}

				else {
					System.out.println("Insert, Go right");
					// parent = current;
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = temp;
						return;
					}
				}
			}
		}
	}

	public Node find (int datavalue) {
		Node current = root;

		// tree is empty
		if (root == null)
			return null;
		// tree is not empty
		else {
			// find 
			while (current != null) {
				// found
				if (datavalue == current.data)
					return current;
				else {
					if(datavalue < current.data)
						current = current.leftChild;
					else
						current = current.rightChild;
				}
			}
			//cannot find
			return null;
		}
	}

	public boolean delete (int value) {
		Node current = root;
		Node parent = root;
		boolean isLeft = true;
		// tree is empty
		if (root == null) {
			//System.out.println("Delete, empty");
			return false;
		}
		// tree is not empty
		// delete root
		/*
		else if (root.data = value) {
			// if no child, delete
			if (root.leftChild == null && root.rightChild == null)
				root = null;
			else if 
		}
		*/
		// not root
		else {
			// find the node to delete
			while (current.data != value) {
				parent = current;
				if (current.data > value) {
					isLeft = true;
					current = current.leftChild;
				}
				else {
					isLeft = false;
					current = current.rightChild;	
				}
				//current cannot be empty  -- null pointer
				// the tree is empty, cannot find
				if (current == null) {
					//System.out.println("Delete, Cannot find");
					return false;
				}
			}
			// found the node -- current
			// if no child just delete
			if (current.leftChild == null && current.rightChild == null) {
				// delete root
				if (current == root)
					root = null;
				//current is left child
				else if(isLeft)
					parent.leftChild = null;
				//current is right child
				else
					parent.rightChild = null;
			}
			// current has left child, no right child
			// current.leftChild link to parent
			else if (current.leftChild != null && current.rightChild == null) {
				// delete root
				if (current == root) {
					root = root.leftChild;
				}
				// current is left child
				else if (isLeft)
					parent.leftChild = current.leftChild;
				// current is right child
				else
					parent.rightChild = current.leftChild;
			}
			// current has right child, no left child
			// current.rightChild link to parent
			else if (current.leftChild == null && current.rightChild != null) {
				// delete root
				if (current == root)
					root = root.rightChild;
				// current is left child
				else if(isLeft)
					parent.leftChild = current.rightChild;
				else
					parent.rightChild = current.rightChild;
			}
			// current has both left and right child
			// delete node << the smallest node that larger than the deleted one
			else{
				//delete root
				if (current == root) 
					root = getSuccessor(root);
				else if (isLeft) 
					parent.leftChild = getSuccessor(current);
				else 
					parent.rightChild = getSuccessor(current);
			}
			// found delete return true
			return true;
		}
	}

	public Node getSuccessor(Node delNode) {
		Node current = delNode.rightChild;
		Node successor = delNode;
		Node successorParent = delNode;
		// current is not empty, go to left
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		// found successor
		// successor do not have left child
		// successor is the right child
		if (successor == delNode.rightChild) {
			successor.leftChild = delNode.leftChild;
			//successorParent.rightChild = successor
		}
		// successor is the left child
		else {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	// traversing the tree
	// visiting each node in a specified order
	// Inorder traversal
	// >> call itself to traverse the node's left subtree
	// >> visit the node
	// >> call itself to traverse the node's right subtree
	public void traverse() {
		System.out.println("Traverse in order: ");
		InorderT(root);
		System.out.println();
	}

	public void InorderT(Node current) {
		if (root == null) {
			System.out.print("Traverse: tree is empyt");
		}
		else if (current != null) {
			InorderT(current.leftChild);
			System.out.print(current.data + " ");
			// current.displayNode();
			InorderT(current.rightChild);
		}
	}
}

//=========================
class BinaryTreeApp {
	public static void main(String args[]) {
		Tree theTree = new Tree();
		Node temp;

		theTree.insert(50);
		theTree.insert(25);
		theTree.insert(75);
		theTree.insert(12);
		theTree.insert(37);
		theTree.insert(43);
		theTree.insert(30);
		theTree.insert(33);
		theTree.insert(87);
		theTree.insert(93);
		theTree.insert(97);

		temp = theTree.find(25);
		temp.displayNode();

		theTree.traverse();

		System.out.println("Deleting 25:");
		if(theTree.delete(25)) {
			System.out.println("After deleted");
			theTree.traverse();
		}
		else{
			System.out.println("Empty or Cannot find the Node");
			theTree.traverse();
		}

	}
}