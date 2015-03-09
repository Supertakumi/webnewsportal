package experiments.code.listing;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import java.io.File;
import java.io.FileInputStream;

public class ReadTest 
{
		private static Properties loadPortletProp = new Properties();
		private static File propFile = new File("F:/Eclipse/Workspace/Experiments","WEB-INF/Language-ext.properties");
		public static void main(String[] args) throws Exception
	{
			boolean isWorking = false;
			
			String feedUrl;
			
			if(propFile.exists()){
			loadPortletProp.load(new FileInputStream(propFile));
			feedUrl = (String) loadPortletProp.getProperty("newsSource");
			feedUrl.replace("\\" , "");
			isWorking = true;
			}
			
			else{ 
			feedUrl = "http://news.oneindia.in/rss/feature-fb.xml";
			isWorking = false;
			}	
			
			
		//RSSFeedParser parser = new RSSFeedParser(new File("F:/Eclipse/Workspace/Experiments/cricinfoIndia.xml").toURI().toURL());
		
		RSSFeedParser parser = new RSSFeedParser(feedUrl);
	    Feed feed = parser.readFeed();
	    List<String[]> feedMessageList = new ArrayList<String[]>();
	    
	    //System.out.println(feed);
		
	   /*for (FeedMessage message : feed.getMessages()) 
	    {
		   if(!(message.getDescription()).equals("<")){
		   	System.out.println("<div>");
			System.out.println("<a href='"+message.getLink()+"'>"+message.getTitle()+"</a>");
			System.out.println("<i>"+feed.getPubDate()+"</i>");
			System.out.println("<br/>");
			System.out.println(message.getDescription());
			System.out.println("</div>");
		   }
	    }*/
	   
	   for (FeedMessage message : feed.getMessages()) 
	    {
		   if(!(message.getDescription()).equals("<")){
				String[] feedMessage = {message.getTitle(),message.getDescription(),message.getLink()};
				feedMessageList.add(feedMessage);
				
			}
	    }
	   
	  for(String[] feedMessage : feedMessageList){
		  System.out.println(feedMessage[0]);
		  System.out.println(feedMessage[1]);
		  System.out.println(isWorking);
		  System.out.println(feedUrl);
	  }
	   
	   
	}
}