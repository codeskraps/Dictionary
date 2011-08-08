import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryData {

	public static void main(String[] args) {
		TernarySearchTree tree = new TernarySearchTree(new TernaryTreeNode('A', false));
		
		try {
		    BufferedReader in = new BufferedReader(new FileReader("./dic/dictionary.txt"));
		    
		    String str = null;
		    
		    while ((str = in.readLine()) != null) {
		    	tree.insert(str.toLowerCase());
		    }
		    in.close();
		    
		} catch (IOException e) {
			System.out.println("Something went wrong !!!");
		}
			
		if (tree.containsKey("abella")) System.out.println("abella is found in the tree");
		else System.out.println("abella is not found");
		
		if (tree.containsKey("transport")) System.out.println("transport is found in the tree");
		else System.out.println("transport is not found");
		
		if (tree.containsKey("zuau")) System.out.println("zuau is found in the tree");
		else System.out.println("zuau is not found");
		
		if (tree.containsKey("creure")) System.out.println("creure is found in the tree");
		else System.out.println("creure is not found");
		
		if (tree.containsKey("governar")) System.out.println("governar is found in the tree");
		else System.out.println("governar is not found");
		
		if (tree.containsKey("carless")) System.out.println("carless is found in the tree");
		else System.out.println("carless is not found");
		
		if (tree.containsKey("lliure")) System.out.println("lliure is found in the tree");
		else System.out.println("lliure is not found");
	}
}
