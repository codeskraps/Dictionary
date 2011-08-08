public class TernarySearchTree {

	private TernaryTreeNode root = null;

	public TernarySearchTree(TernaryTreeNode node) {
		this.root = node;
	}

	private void insert(String key, int pos, TernaryTreeNode node) {
		char s[] = key.toCharArray();
		
		if (s[pos] < node.getC()) {
			if (node.getLeftNode() == null) {
				node.setLeftNode(new TernaryTreeNode(s[pos], false));
			}
			insert(key, pos, node.getLeftNode());
		} else if (s[pos] > node.getC()){
			if (node.getRighNode() == null) {
				node.setRighNode(new TernaryTreeNode(s[pos], false));
			}
			insert(key, pos, node.getRighNode());
		}else if (s[pos] == node.getC()){
			if (pos + 1 == key.length()) { 
				node.setEquaNode(new TernaryTreeNode(s[pos], false));
				node.setWord(true); 
			}
			else { 
				if (node.getEquaNode() == null) {
					node.setEquaNode(new TernaryTreeNode(s[pos + 1], false));
				}
				insert(key, pos + 1, node.getEquaNode()); 
			}
		}
	}

	public void insert(String s) {
		if (s == null || s == "")
			throw new IllegalArgumentException();
		
		insert(s, 0, this.root);
	}

	public boolean containsKey(String key) {
		if (key == null || key == "")
			throw new IllegalArgumentException();

		int pos = 0;
		TernaryTreeNode node = this.root;
		
		char s[] = key.toCharArray();
		while (node != null) {
		
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
		//TernarySearchTree tree = new TernarySearchTree(new TernaryTreeNode('A', false));
		TernarySearchTree tree = new TernarySearchTree(new TernaryTreeNode('A', false));
		tree.insert("AB");
		tree.insert("ABBA");
		tree.insert("AA");
		tree.insert("ABCD");
		tree.insert("BCD");

		 boolean found = tree.containsKey("AB");
		
		 if (found) System.out.println("AB is found in the tree");
		 else System.out.println("AB is not found");
		
		 found = tree.containsKey("ABCD");
		
		 if (found) System.out.println("ABCD is found in the tree");
		 else System.out.println("ABCD is not found");
		 
		 found = tree.containsKey("BCD");
			
		 if (found) System.out.println("BCD is found in the tree");
		 else System.out.println("BCD is not found");

		 found = tree.containsKey("ABB");
			
		 if (found) System.out.println("ABB is found in the tree");
		 else System.out.println("ABB is not found");
	}
}