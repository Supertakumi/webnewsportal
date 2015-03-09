package addnewportlet.code.listing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import ant.api.projects.CreatePortlet;
import java.util.Properties;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class AddNewPortlet extends GenericPortlet{
	
	private static Properties properties = new Properties();
	private static String newsCategory = "category.newsportlet.newsportlet";
	private static String newsTitle = "javax.portlet.title";
	private static String newsSource = "newsSource";
	
	
	@RenderMode(name = "VIEW")
	public void renderForm(RenderRequest request, RenderResponse response) throws PortletException, IOException{
		
		if ("success".equalsIgnoreCase((String) request.getAttribute("actionStatus"))) {
			PortletURL homeUrl = response.createRenderURL();
			
			request.setAttribute("homeUrl", homeUrl);
			getPortletContext().getRequestDispatcher("/WEB-INF/jsp/success.jsp").include(request, response);
			return;
		}
		
		
		PortletURL addNewPortletActionUrl = response.createActionURL();
		addNewPortletActionUrl.setParameter(ActionRequest.ACTION_NAME,"addNewPortletAction");
		//PortletURL resetRenderUrl = response.createRenderURL();
		request.setAttribute("addNewPortletActionUrl", addNewPortletActionUrl);
		//request.setAttribute("resetRenderUrl", resetRenderUrl);
		
		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/form.jsp").include(request, response);
	}
	
	@ProcessAction(name = "addNewPortletAction")
	public void addPortlet(ActionRequest request, ActionResponse response) throws PortletException, IOException{
		String portletTitle = (String) request.getParameter("portletTitle");
		String newsUrl = (String) request.getParameter("newsSource");
		newsUrl = (String) newsUrl.replace("\\\\", "");
		String category = (String) request.getParameter("category");
		String baseDir = "E:/Project/Eclipse/Workspace/Experiments";
		
		properties.put(newsCategory, category);
		properties.put(newsTitle,portletTitle);
		properties.put(newsSource, newsUrl);
		FileOutputStream fileout = new FileOutputStream(new File(baseDir, "WEB-INF/Language-ext.properties"));
		properties.store(fileout, "Language-extension");
		String [] args = new String[] {""};
		CreatePortlet.main(args);
		
		
		request.setAttribute("actionStatus", "success");
		
	}
	

}
