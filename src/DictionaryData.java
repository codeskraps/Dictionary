import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DictionaryData {

	public static void main(String[] args) throws IOException {
		TernarySearchTree tree = new TernarySearchTree(new TernaryTreeNode('A', false));

		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"./dic/dictionary.txt"));

			String str = null;

			while ((str = in.readLine()) != null) {
				tree.insert(str.toLowerCase());
			}
			in.close();

		} catch (IOException e) {
			System.out.println("Something went wrong !!!");
		}

		String string = "";
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);

		do{
			System.out.print("Please enter a word: ");
	
			string = reader.readLine();
	
			if (tree.containsKey(string))
				System.out.print("\n\t** " + string + " ** is found in the dictionary\n\n");
			else
				System.out.print("\n\t** " + string + " ** is NOT found in the dictionary\n\n");
		
		}while (string != "123");
	}
}
