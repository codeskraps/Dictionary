public class TernarySearchTree {

	private TernaryTreeNode root = null;

	public TernarySearchTree(TernaryTreeNode node) {
		this.root = node;
	}

	private void insert(String key, int pos, TernaryTreeNode node) {
		char s[] = key.toCharArray();
		System.out.println("key: " + key + ", Char: " + s[pos]);
		
		if (s[pos] < node.getC()) {
			System.out.println("getting left node");
			if (node.getLeftNode() != null){
				insert(key, pos + 1, node.getLeftNode());
			} else {
				node.setLeftNode(new TernaryTreeNode(s[pos], false));
			}
		} else if (s[pos] > node.getC()) {
			System.out.println("getting right node");
			if (node.getRighNode() != null) {
				insert(key, pos + 1, node.getRighNode());
			} else {
				node.setRighNode(new TernaryTreeNode(s[pos], false));
			}
		} else {
			System.out.println("getting equal node");
			if (node.getEquaNode() != null) {
				insert(key, pos + 1, node.getEquaNode());
			} else {
				node.setEquaNode(new TernaryTreeNode(s[pos], false));
			}
		}
		
	}

	public void insert(String s) {
		if (s == null || s == "")
			throw new IllegalArgumentException();
		//if (root != null) System.out.println("root:" + root.getC());
		insert(s, 0, this.root);
	}

	public boolean containsKey(String key) {
		if (key == null || key == "")
			throw new IllegalArgumentException();

		int pos = 0;
		TernaryTreeNode node = this.root;
		System.out.println("root: " + root.getC());
		char s[] = key.toCharArray();
		while (node != null) {
			System.out.println("Searching: " + s[pos]);
			if (s[pos] < node.getC()) {
				node = node.getLeftNode();
			} else if (s[pos] > node.getC()) {
				node = node.getRighNode();
			} else {
				if (++pos == key.length())
					return node.isWord();
				node = node.getEquaNode();
			}
		}

		return false;
	}

	public static void main(String[] args) {
		TernarySearchTree tree = new TernarySearchTree(new TernaryTreeNode('A', false));
		tree.insert("AB");
		tree.insert("ABBA");
		tree.insert("ABCD");
		tree.insert("BCD");

		// boolean found = tree.containsKey("AB");
		//
		// if(found)
		// System.out.println("AB is found in the tree");
		// else
		// System.out.println("AB is not found");
		//
		// found = tree.containsKey("ABCD");
		//
		// if(found)
		// System.out.println("ABCD is found in the tree");
		// else
		// System.out.println("ABCD is not found");

	}
}