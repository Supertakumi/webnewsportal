package experiments.code.listing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class ReadFeedPortlet extends GenericPortlet{
	
	
	@RenderMode(name = "VIEW")
	public void renderNews(RenderRequest request, RenderResponse response)
	throws PortletException, IOException{
		
			String realPath = getPortletContext().getRealPath("/WEB-INF/classes/content");
			Properties loadPortletProp = new Properties();
			File propFile = new File(realPath,"Language-ext.properties");
			String feedUrl;
			String cssClassWrapperName;
		
			if(propFile.exists()){
			loadPortletProp.load(new FileInputStream(propFile));
			feedUrl = (String) loadPortletProp.getProperty("newsSource");
			feedUrl.replace("\\" , "");
			cssClassWrapperName = (String) loadPortletProp.getProperty("javax.portlet.title");
			cssClassWrapperName = cssClassWrapperName.toLowerCase();
			cssClassWrapperName = cssClassWrapperName.replace(" ","");
			String urlStatus = "";
			request.setAttribute("urlStatus", urlStatus);
			request.setAttribute("cssClassWrapperName",cssClassWrapperName);
			
			}
			
			else{ 
			feedUrl = "http://news.oneindia.in/rss/feature-fb.xml";
			
			String urlStatus = "Url is not working!" + propFile + realPath;
			request.setAttribute("urlStatus", urlStatus);
			}
		
		//RSSFeedParser parser = new RSSFeedParser(new File("F:/Eclipse/Workspace/Experiments/cricinfoIndia.xml").toURI().toURL());
		
		RSSFeedParser parser = new RSSFeedParser(feedUrl);
		Feed feed = parser.readFeed();
		String feedTitle = feed.getTitle();
		List<String[]> feedMessageList = new ArrayList<String[]>();
		
		for (FeedMessage message : feed.getMessages()) 
	    {
			if(!(message.getDescription()).equals("<")){
			String[] feedMessage = {message.getTitle(),message.getDescription(),message.getLink()};
			feedMessageList.add(feedMessage);
			}
	    }
		
		request.setAttribute("feedMessages", feedMessageList);
		request.setAttribute("feedTitle",feedTitle);
		response.setContentType("text/html");
		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/News.jsp").include(request, response);

		
	}
	
}