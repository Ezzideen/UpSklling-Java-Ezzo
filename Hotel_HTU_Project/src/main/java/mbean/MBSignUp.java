package mbean;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.jk.web.faces.mb.JKManagedBean;
import com.jk.web.util.JKJsfUtil;

import entity.EUser;
import entityDao.HotelDao;

@ManagedBean(name = "mbSignUp")
@SessionScoped
public class MBSignUp extends JKManagedBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EUser user;

	public EUser getUser() {
		if (user == null) {
			user = new EUser();
		}
		return user;
	}

	public void setUser(EUser user) {
		this.user = user;
	}

	// --------------------------------------------------------------------------------------------------------

	public String Login() {
		JKJsfUtil.invalidateSession();
		redirect("login.xhtml");
		return null;
	}
	
	public String goToHomePage() {
		JKJsfUtil.invalidateSession();
		redirect("royal-master/index.xhtml");
		return null;
	}
	

	// --------------------------------------------------------------------------------------------------------

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	// --------------------------------------------------------------------------------------------------------

	public void userSignUp() throws Exception {

		HotelDao dao = new HotelDao();
		userData();
		dao.insertUser(getUser());
		addMessage(FacesMessage.SEVERITY_INFO, "Your account has been created!", "note");
		redirect("login.xhtml");
	}

	public void userData() throws Exception {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		    Date date1=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dtf.format(now));  
		getUser().setCreatedDate(date1);
		getUser().setUpdatedDate(date1);
		getUser().setIs_admin(false);
		getUser().setIs_active(true);
		
	}
	
	
	public String getValidatorMessageEmail() {
		return getUser().getEmail();
	}
	public String getValidatorMessagePassword() {
		return getUser().getPassword();
	}

}
