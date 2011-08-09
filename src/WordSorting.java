import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WordSorting {

	public static void main(String... aArgs) throws IOException {
		HashMap<Integer, ArrayList<WordItem>> wordMap = new HashMap<Integer, ArrayList<WordItem>>();
		
		try {
		    BufferedReader in = new BufferedReader(new FileReader("./dic/Catalan.txt"));
		    String str, repeats="ZZZZZZZZ";
		    int removed = 0;
		    
		    while ((str = in.readLine()) != null) {
		    	
		    	String[] words = str.split (" ");
		    	
		    	if (words[0].length() > 1) {
		    		
		    		if (!repeats.equals(words[0])) {
		    			
		    			ArrayList<WordItem> wordItemList;
		    			
		    			if (wordMap.containsKey(words[0].length())) 	wordItemList = wordMap.get(words[0].length());
		    			else 											wordItemList = new ArrayList<WordItem>();
		    			
		    			wordItemList.add(new WordItem(words[0]));
	    				wordMap.put(words[0].length(), wordItemList);
		    			//out.write(start + words[0]  + end);
		    		} else {
		    			System.out.println("Removing --> Repeat: " + words[0]);
		    			removed++;
		    		}
		    		repeats = words[0];	
		    	} else {
		    		System.out.println("Removing --> 2Short: " + words[0]);
		    		removed++;
		    	}
		    }
		    System.out.println("-------------\nTotal removed: " + removed);
		    in.close();
		} catch (IOException e) {
			System.out.println("Something went wrong !!!");
		}
		
		
		BufferedWriter out = new BufferedWriter(new FileWriter("./dic/dic_catalan.xml"));
		int n = 0;
		int x;
		do {
			if (wordMap.containsKey(n)) {
				
				ArrayList<WordItem> wordItemList = wordMap.get(n);
				out.write("\n\nWriting: " + n + "n\n");
				x = 0;
				
				for (WordItem w : wordItemList) {
					if (x == 10) {
						out.write("\n");
						x = 0;
					}
					x++;
					out.write("\"" + w.getDisplayWord() + "|" + w.getSearchWord() + "\", ");
				}
				out.write("\n\n\n");
			}
			n++;
		}while(n<30);
		
		out.close();
	}
}