import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderLeg {
	
	private static final String USER_AGENT = "Chrome";
	private List<String> links = new LinkedList<String>();
	private Document htmlDocument;
	
	public boolean crawl(String url) {
		
		try {
			
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
			Document htmlDocument;
			htmlDocument = connection.get();
			this.htmlDocument = htmlDocument;
			if (connection.response().statusCode() == 200) {
				System.out.println("Visiting... Receiving web page at " + url);
			}
			if (!connection.response().contentType().contains("text/html")) {
				System.out.println("Failure... No HTML to parse on this page");
				return false;			
			}
			Elements linksOnPage = htmlDocument.select("a[href]");
			System.out.println("Found (" + linksOnPage.size() + ") links");
			for (Element Link : linksOnPage) {
				this.links.add(Link.absUrl("href"));
			}
			return true;
		} catch (IOException ioe) {
			System.out.println("Error in the HTTP request " + ioe);
			return false;
		}
	}
	
	public boolean searchForWord(String searchWord) {
		if (this.htmlDocument == null) {
			System.out.println("Error... call crawl before you search for the world on the url site!");
			return false;
		}
		System.out.println("Searching for the word " + searchWord + "...");
		String bodyText = this.htmlDocument.body().text();
		return bodyText.toLowerCase().contains(searchWord.toLowerCase());
	}
	public List<String> getLinks(){
		return this.links;
	}

}
