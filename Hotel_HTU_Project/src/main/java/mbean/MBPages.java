package mbean;

import javax.faces.bean.ManagedBean;

import com.jk.web.faces.mb.JKManagedBean;
import com.jk.web.util.JKJsfUtil;

@ManagedBean(name = "mbPages")
public class MBPages extends JKManagedBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String adminHomePage()
	{
		JKJsfUtil.invalidateSession();
		redirect("adminSettings.xhtml");
		return null;
	}
	public String adminSettingsPage()
	{
		return "adminSettings.xhtml?faces-redirect=true";
	}
		
}
