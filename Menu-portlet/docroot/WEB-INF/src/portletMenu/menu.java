package portletMenu;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


/**
 * A menu portlet which render new portlet in site page.
 * 
 * @author Maushami
 */

public class menu extends GenericPortlet {

	/**
	 * Render methods for the view mode. This methods is invoked when render
	 * request is sent to the portlet and the current portlet mode is 'VIEW'.
	 * 
	 * @param request
	 * @param response
	 * @throws PortletExceptions
	 * @throws IOException
	 */
	@RenderMode(name = "VIEW")
	public void portletmenu(RenderRequest request, RenderResponse response)
			throws PortletException, IOException
	{
		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/menu.jsp").include(request, response);
		
	}
		
	
}
