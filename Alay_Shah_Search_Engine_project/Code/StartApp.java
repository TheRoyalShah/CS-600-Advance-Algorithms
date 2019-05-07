import java.util.*;
public class StartApp {

	//Starting point of the application
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>();
		
		//links to read data from
		String[] links = {"http://www.geeksforgeeks.org/binomial-heap-2/",
				"http://www.geeksforgeeks.org/reverse-a-linked-list/",
				"http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/",
				"http://www.geeksforgeeks.org/knapsack-problem/",
				"http://www.geeksforgeeks.org/sparse-table/",
				"http://www.geeksforgeeks.org/warnsdorffs-algorithm-knights-tour-problem/"};
		DataReceived d = new DataReceived();
		
		//looping through the above 6 links and calling the function to scrape only paragraphs through them.
		//Below is the call to store the words and find the word occurences.
		for(String link : links)
		{
			d.getData(link,frequencyData);
		}
	
		//Printing the counts for all words.
		PageRanking.printAllCounts(frequencyData);
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the word you want to search : ");
			String word = scan.next();
			
			// To stop asking for words
			if (word.equals("exit")) break;
			
			List<PageRanking> pages = new ArrayList<>();
			
			//Below looping is done to find through each page whether the requested word  is present or not with their respective count. 
			for(int i = 0; i < links.length; i++)
			{
				Integer count = d.getData(links[i],word);
				if (count > 0) {
					pages.add(new PageRanking(links[i], count));
				}
			}
			
			pages.sort(new PageComparator());
			for (PageRanking page : pages) {
				System.out.println(page.getName() + " has " + word + " " + page.getRank() + " times");
			}
		}
		scan.close();
		System.exit(0);
	}
}
