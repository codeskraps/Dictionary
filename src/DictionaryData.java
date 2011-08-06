import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class DictionaryData {

	private static WordItem wordItem = null;
	private static HashMap<Integer, ArrayList<WordItem>> wordMap = null;
	
	public static void main(String[] args) {

		try {
		    BufferedReader in = new BufferedReader(new FileReader("./dic/dictionary.txt"));
		    wordMap = new HashMap<Integer, ArrayList<WordItem>>();
		    
		    String str = null;
		    ArrayList<WordItem> wordItemList = null;
		    
		    while ((str = in.readLine()) != null) {
		    	wordItem = new WordItem(str);
		    	//System.out.println("ContainsKey: " + wordMap.containsKey(wordItem.getSearchWord().length()));
		    	//System.out.println("ContainsValue: " + wordMap.containsValue(wordItem.getSearchWord().length()));
		    	
		    	
		    	if (wordMap.containsKey(wordItem.getSearchWord().length())) {
		    		wordItemList = wordMap.get(wordItem.getSearchWord().length());
		    	} else {
		    		wordItemList = new ArrayList<WordItem>();
		    	}
		    	wordItemList.add(wordItem);
		    	wordMap.put(wordItem.getSearchWord().length(), wordItemList);
		    	//har ch = (char) System.in.read();
		    }
		    
		    in.close();
		    
		} catch (IOException e) {
			System.out.println("Something went wrong !!!");
		}
		
		for (int x = 0; x < 300; x++) {
			if (wordMap.containsKey(x)) {
				System.out.println("Word of " + x + " letters:");
				ArrayList<WordItem> wordItemList = wordMap.get(x);
				for (WordItem word : wordItemList) {
					System.out.println("\t" + word.getDisplayWord());
				}
			}
		}
	}

}
