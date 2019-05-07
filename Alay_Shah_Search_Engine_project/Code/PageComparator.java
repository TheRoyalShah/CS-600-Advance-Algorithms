import java.util.Comparator;

public class PageComparator implements Comparator<PageRanking> {

	@Override
	public int compare(PageRanking o1, PageRanking o2) {
		return o2.getRank().compareTo(o1.getRank());
	}
}