package com.registeruser.listing;


import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ProcessAction;

import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
/**
 * Portlet implementation class RegisterUser
 */
public class RegisterUser extends GenericPortlet {


    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
        	getPortletContext().getRequestDispatcher("/WEB-INF/jsp/regPage.jsp").include(renderRequest, renderResponse);
       
    }
    
    @Override
    public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException{
    	User user = null;
    	 ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY); 
    	 long companyId = td.getCompanyId();
    	 user.setCompanyId(companyId);
    	 //boolean autoPassword = false;
    	 user.setPassword((String)actionRequest.getAttribute("password"));
    	 user.setFirstName((String)actionRequest.getAttribute("fName"));
    	 user.setLastName((String)actionRequest.getAttribute("lName"));
    	 user.setScreenName((String)actionRequest.getAttribute("fName")+(String)actionRequest.getAttribute("lName"));
    	 String emailAddress = (String)actionRequest.getAttribute("email");
    	 user.setEmailAddress(emailAddress);
    	 user.setPasswordEncrypted(true);
    	 
    	 boolean male = false;
    	 if(actionRequest.getAttribute("gender").equals("Male")){
    		 male = true;
    	 }
    	 
    	 try {
			UserLocalServiceUtil.addUser(user);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	/* int year = (Integer) actionRequest.getAttribute("year");
    	 int month = (Integer) actionRequest.getAttribute("month");
    	 int day = (Integer) actionRequest.getAttribute("dob");
    	 
    	 User user1= null;
		try {
			user1 = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 long contactId = user1.getContactId();
    	 Contact contact = null;
		try {
			contact = new ContactLocalServiceUtil().getContact(contactId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 contact.setBirthday(new Date(year,month,day));
    	 contact.setMale(male);
    	 try {
			ContactLocalServiceUtil.updateContact(contact);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	 
    	 //actionResponse.sendRedirect(td.getPathMain());
    	 
    }


}
