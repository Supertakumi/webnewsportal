package chapter01.code.listing;

import java.io.IOException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutType;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthException;
import com.liferay.portal.security.auth.Authenticator;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
//import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.portlet.RenderMode;

/**
 * A Simple Hello World portlet which writes the message directly to the
 * response stream.
 * 
 * @author Sohil
 */
public class HelloWorldPortlet extends GenericPortlet {
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
	public void sayHello(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		
		
		String pageToRender = ""; //name of page to display. default:null
		//if the requested parameter is registration page then set the page to display to regPage.jsp
		
		
		if(request.getParameter("signin")!=null){
			pageToRender = (String)request.getParameter("signin");
		}
		//else if the requested parameter is sign in page then set the page to display to abc.jsp
		else if(request.getParameter("regPage")!=null){
			pageToRender = (String)request.getParameter("regPage");
		}
		
		//check the value of pageToRender, if it is regPage.jsp then goto regPage.jsp else goto abc.jsp
		/*if(pageToRender.equals("/regPage.jsp")){
			PortletURL regUrl = response.createActionURL();
			regUrl.setParameter(ActionRequest.ACTION_NAME,"regAction");
			request.setAttribute("regUrl", regUrl);
			getPortletContext().getRequestDispatcher("/WEB-INF/jsp/regPage.jsp").include(request,response);
		}
		
		else{*/ 		
			ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			boolean isSignedIn = td.isSignedIn();
			if(isSignedIn){
				User user = td.getUser();				
				String userFirstName = user.getFirstName();
				String userLastName = user.getLastName(); 
				request.setAttribute("firstName",userFirstName);
				request.setAttribute("lastName",userLastName);
				getPortletContext().getRequestDispatcher("/WEB-INF/jsp/abc.jsp").include(request, response);
			} 
			else{
				//PortletURL signinUrl = response.createActionURL();
				//signinUrl.setParameter(ActionRequest.ACTION_NAME,"signinAction");
				//request.setAttribute("signinUrl", signinUrl);
				getPortletContext().getRequestDispatcher("/WEB-INF/jsp/abc.jsp").include(request,response);
			}
		//}
	}
	
	
	
	@ProcessAction (name="signinAction")
	 public void signinAction (ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException{
		  
		   String email = actionRequest.getParameter("email");
		   String password = actionRequest.getParameter("password");
		   ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		   long companyId = td.getCompanyId();
		   
		   try
		    {
		    //int authResult = 0;
		    //long userId = 0;
		    //Company company = PortalUtil.getCompany(actionRequest);
		    Map headerMap = new HashMap();


		    Map parameterMap = actionRequest.getParameterMap();

		   

		    //authResult = UserLocalServiceUtil.authenticateByEmailAddress(company.getCompanyId(), email, password,headerMap, parameterMap, null);
		    //userId = UserLocalServiceUtil.getUserIdByEmailAddress(companyId, email);
		    User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
		    String screenId = user.getScreenName();
		      
		    try {
		    MethodKey key = new MethodKey("com.liferay.portlet.login.util.LoginUtil", "login", HttpServletRequest.class, HttpServletResponse.class, String.class, String.class, boolean.class, String.class);
		    PortalClassInvoker.invoke(false, key, new Object[] { PortalUtil.getHttpServletRequest(actionRequest), PortalUtil.getHttpServletResponse(actionResponse),screenId, password, true, CompanyConstants.AUTH_TYPE_SN});
		    //actionResponse.sendRedirect("/user/" + screenId + "/home");
		    actionResponse.sendRedirect(td.getPathMain());
		    }
		    catch(AuthException aut){
		    	actionRequest.setAttribute("error", "error");
		    	getPortletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").include(actionRequest, actionResponse);
		    }
		    	
		    }
		    catch (Exception e)
		    {
		    e.printStackTrace();
		    }
		    }
	   
	
	 
	    private static Log _log = LogFactoryUtil.getLog(HelloWorldPortlet.class);

}
