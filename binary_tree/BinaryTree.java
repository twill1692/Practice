public class BinaryTree {
	Node root;

	public BinaryTree(int data) {
		root = new Node(data);
	}

	class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	private void treeBuilder() {
	}

	private void delete() {
		
	}
	
	private void insert(int data) {
		recursiveInsert(root, data);
	}

	private Node recursiveInsert(Node root, int data) {
		if (root == null) {
			return root = new Node(data);
		} else if (root.data < data) {
			root.right = recursiveInsert(root.right, data);
		} else {
			root.left = recursiveInsert(root.left, data);
		}
		return root;
	}

	private void printInOrder() {
		recursivePrintInOrder(root);
	}

	private void recursivePrintInOrder(Node root) {
		if (root == null)
			return;
		recursivePrintInOrder(root.left);
		System.out.println(root.data);
		recursivePrintInOrder(root.right);

	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(42);
		tree.insert(6);
		tree.insert(88);
		tree.insert(62);
		tree.insert(7);
		tree.insert(19);
		tree.printInOrder();
	}
}