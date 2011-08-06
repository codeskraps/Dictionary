import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WordSorting {

	public static void main(String... aArgs) throws IOException {
		
		try {
		    BufferedReader in = new BufferedReader(new FileReader("./dic/Catalan.txt"));
		    BufferedWriter out = new BufferedWriter(new FileWriter("./dic/Catalan_clean.txt"));
		    String str, repeats="ZZZZZZZZ";
		    int removed = 0;
		    
		    while ((str = in.readLine()) != null) {
		    	
		    	String[] words = str.split (" ");
		    	
		    	if (words[0].length() > 1) {
		    		if (!repeats.equals(words[0])) 
		    			out.write(words[0]  + "\n");
		    		else {
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
		    out.close();
		} catch (IOException e) {
			System.out.println("Something went wrong !!!");
		}
	}
}