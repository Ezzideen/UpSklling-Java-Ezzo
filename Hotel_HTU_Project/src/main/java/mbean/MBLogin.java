package mbean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;




import entity.EGuest;
import entity.EReservation;
import entity.ERoom;
import entity.EUser;
import entityDao.HotelDao;

@ManagedBean(name = "mbLogin")
@SessionScoped
public class MBLogin extends ButtonActivation {

	/**
	 * 
	 */
	private boolean isLogin;
	private static final long serialVersionUID = 2L;
	public EUser user;
	private EReservation reservation;
	private EGuest guest;

	public EGuest getGuest() {
		return guest;
	}

	public void setGuest(EGuest guest) {
		this.guest = guest;
	}

	public EReservation getReservation() {
		return reservation;
	}

	public void setReservation(EReservation reservation) {
		this.reservation = reservation;
	}

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

	public boolean isLoginState() {
		return isLogin;
	}

	public void setLoginState(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public String signUp() {
		
		redirect("/htu/pages/sign_up.xhtml");
		return null;
	}

	// --------------------------------------------------------------------------------------------------------

	public String loginHomePage() {
		redirect("royal-master/index.xhtml");
		return null;
	}

	public String loginAdminHomePage() {
		
		redirect("admin/admin_home.xhtml");
		return null;
	}

	// --------------------------------------------------------------------------------------------------------

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	// --------------------------------------------------------------------------------------------------------
	public String checkLogin() {
		HotelDao dao = new HotelDao();
	     EUser user = dao.checkUserLogin(getUser());
		if (user != null) {
			if (user.getPassword().equals(getUser().getPassword())) {
				if (user.isIs_admin()) {
					setUser(user);
					setLoginState(true);
					loginAdminHomePage();
					return null;
				}
				setUser(user);
				setLoginState(true);
				addMessage(FacesMessage.SEVERITY_INFO, "Note", "Welcome back sir!");
				loginHomePage();
				return null;
			}
			addMessage(FacesMessage.SEVERITY_INFO, "Password is Uncorrect!!", "note");
			return null;
		} else
			addMessage(FacesMessage.SEVERITY_INFO, "Username is Uncorrect!!", "note");
		return null;
	}

	public void restLogin()
	{
		setUser(null);
	}
	//==================================reservation=======================================================
	public void addReservation() {
		HotelDao dao = new HotelDao();
		// Room-Checked

		if (roomChecked()) {
			// date-Checked

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			getReservation().setCreatedDate(dtf.format(now));
			getReservation().setUpdatedDate(dtf.format(now));

			// Discount-Check-If-Exist
			getReservation().setDiscount(0);
			getReservation().setTotalPrice(getReservation().getRoom().getPrice());

			// Guest-Check
			dao.insertGuest(getGuest());

			// Reservation-Guest-Check
			getReservation().getGuest().setId(getGuest().getId());

			// ReservationKey-Check
			int min = 1000;
			int max = 2000;
			int random_int = (int) (Math.random() * (max - min + 1) + min);
			getReservation().setReservationKey(random_int);
			// Reservation-Process
			dao.insertReservation(getReservation());
			// message-out
			addMessage(FacesMessage.SEVERITY_INFO, "note", "Your Reservation has been Done Successfully");
			
		} else {
			addMessage(FacesMessage.SEVERITY_INFO, "Failure", "Failed to Reserve Something Went Wrong");
		}

	}
	
	public Boolean roomChecked() {
		HotelDao dao = new HotelDao();
		ERoom room = dao.findRoom(getReservation().getRoom().getId());
		if (room.isIs_available()) {
			room.setIs_available(false);
			dao.update(room);
			return true;
		} else {
			addMessage(FacesMessage.SEVERITY_INFO, "this room is alredy reserved!!", "note");
			return false;
		}

		// update record in the databse

	}
	// --------------------------------------------------------------------------------------------------------

//		public String checkLogin2() {
//			UserDao dao = new UserDao();
//			if (dao.checkUserLoginTow(getUser().getUsername(), getUser().getPassword())) {
//				addMessage(FacesMessage.SEVERITY_INFO, "Note", "Welcome back sir!");
//				return null;
//			}
//			addMessage(FacesMessage.SEVERITY_INFO, "Password is Uncorrect!!", "Password is Uncorrect!!");
//			return null;
//		}
	// --------------------------------------------------------------------------------------------------------

}
