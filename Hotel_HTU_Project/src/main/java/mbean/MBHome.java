package mbean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jk.web.faces.mb.JKManagedBean;
import com.jk.web.util.JKJsfUtil;

import entity.ERoom;
import entityDao.HotelDao;

@ManagedBean(name = "mbHome")
@ViewScoped
public class MBHome extends JKManagedBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private ERoom room;
	private HotelDao dao = new HotelDao();
	
	
	
	public ERoom getRoom() {
		return room;
	}

	public void setRoom(ERoom room) {
		this.room = room;
	}

	public String goToLogin() {
		JKJsfUtil.invalidateSession();
		redirect("/htu/pages/login.xhtml");
		return null;
	}
	
	public String goToSignUp() {
		JKJsfUtil.invalidateSession();
		redirect("/htu/pages/sign_up.xhtml");
		return null;
	}
	
	public String goToReservation() {
		JKJsfUtil.invalidateSession();
		redirect("/htu/pages/user/user-reservation.xhtml");
		return null;
	}
	
	public List<ERoom> getListRoom() {
		return dao.getAllRooms();
	}
}
