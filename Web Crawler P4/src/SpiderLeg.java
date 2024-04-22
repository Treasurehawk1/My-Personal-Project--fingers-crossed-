import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderLeg {

	private static final String AUTH_USER = "Chrome";
	private List<String> links = new LinkedList<String>();
	private Document htmlDocument;

	public void crawl(String url) {
		
		try {
			Connection connection = Jsoup.connect(url).userAgent(AUTH_USER);
			Document htmlDocument = connection.get();
			this.htmlDocument = htmlDocument;
			if (connection.response().statusCode() == 200) {
				System.out.println("Visiting... Receiving web page at " + url);
			}
			if (!connection.response().contentType().contains("text/html")) {
				System.out.println("Could not find html text to parse at " + url);
				return;
			}
			Elements linksOnPage = htmlDocument.select("a[href]");
			System.out.println("Found (" + linksOnPage.size() + ") links");
			for (Element link : linksOnPage) {
				this.links.add(link.absUrl("href"));
			}
			return;
		} catch (IOException ioe) {
			System.out.println("Error in the HTTP request " + ioe);
			return;
		}
	}
	
	public boolean searchForWord(String searchWord) {
		if (this.htmlDocument == null) {
			System.out.println("Error... either crawl has not been called or the link used has no html to parse");
			return false;
		}
		System.out.println("Searching for the word Linux...");
		String current = this.htmlDocument.body().text();
		return current.toLowerCase().contains(searchWord.toLowerCase());
	}
	
	
	public List<String> getLinks(){
		return this.links;
	}
	
}
