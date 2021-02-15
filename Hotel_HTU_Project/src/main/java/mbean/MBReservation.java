package mbean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



import entity.EGuest;
import entity.EHotel;
import entity.EReservation;
import entity.ERoom;
import entity.ERoomType;
import entity.EUser;
import entityDao.HotelDao;

@ManagedBean(name = "mbReservation")
@SessionScoped
public class MBReservation extends ButtonActivation {

  
	private static final long serialVersionUID = 13L;
	
	private EReservation reservation;
	private ERoom room;
	private EUser user;
	private ERoomType roomType;
	private EGuest guest;
	private EHotel hotel;

	private HotelDao dao = new HotelDao();

	
	// -------------------------------------------------------getter & setter
	// Entities---------------------------------------------------

	
	
	
	public EReservation getReservation() {
		if (reservation == null)
			reservation = new EReservation();
		return reservation;
	}

	public void setReservation(EReservation reservation) {
		this.reservation = reservation;
	}
	
	public EUser getUser() {
		if(user == null) {
			user = new EUser();}
		return user;
	}

	public void setUser(EUser user) {
		this.user = user;
	}

	public EHotel getHotel() {
		if (hotel == null)
			hotel = new EHotel();
		return hotel;
	}

	public void setHotel(EHotel hotel) {
		this.hotel = hotel;
	}

	public ERoom getRoom() {
		if (room == null)
			room = new ERoom();
		return room;
	}

	public void setRoom(ERoom room) {
		this.room = room;
	}

	public ERoomType getRoomType() {
		if (roomType == null)
			roomType = new ERoomType();
		return roomType;
	}

	public void setRoomType(ERoomType roomType) {
		this.roomType = roomType;
	}

	public EGuest getGuest() {
		if (guest == null)
			guest = new EGuest();
		return guest;
	}

	public void setGuest(EGuest guest) {
		this.guest = guest;
	}

	// ---------------------------------------------------------------------------
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}
	// ---------------------------------------------------------------------------

	public String goToReservationCheck() {
		redirect("elements.xhtml");
		return null;
	}
	
	public String goToReservationBlog() {
		redirect("blog.xhtml");
		return null;
	}
	
	public String goToReservation(ERoom room) {
		getReservation().setRoom(room);
		setRoom(room);
		redirect("user_room_reservation_check.xhtml");
		return null;
	}
	
	public List<ERoom> getListSelectedRoom(){
		return dao.findRoomByName(getRoom().getId());
	}
	
	public void checkUserLogin() {
		HotelDao dao = new HotelDao();
	     EUser user = dao.checkUserLogin(getUser());
	    	setUser(user);
	}
	
	public void addReservationTow() {
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
			
			getGuest().setEmail(getUser().getEmail());
			getGuest().setFirstName(getUser().getFirstName());
			getGuest().setLastName(getUser().getLastName());
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
			goToReservationBlog();
		} else {
			addMessage(FacesMessage.SEVERITY_INFO, "Failure", "Failed to Reserve Something Went Wrong");
		}

	}

	public void addReservation() {
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
			goToReservationBlog();
		} else {
			addMessage(FacesMessage.SEVERITY_INFO, "Failure", "Failed to Reserve Something Went Wrong");
		}

	}
	
	public List<ERoom> getListSelectedRoomTow(){
		return dao.findRoomByName(getReservation().getRoom().getId());
	}

	public Boolean roomChecked() {

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

	public double getRoomPrice() {
		if (getReservation().getRoom().getId() == null) {
			getReservation().getRoom().setId(1);
		}
		ERoom room = dao.findRoom(getReservation().getRoom().getId());
		getReservation().getRoom().setPrice(room.getPrice());
		return room.getPrice();
	}

//	public int getReservationKeyNumber() {
//		if (getReservation().getReservationKey() == 0) {
//			getReservation().setReservationKey(1);
//		}
//		EReservation rservation = dao.findReservation(getReservation().getId());
//			return rservation.getReservationKey();
//	}

	public String getRoomDescription() {
		if (getReservation().getRoom().getId() == null) {
			getReservation().getRoom().setId(1);
		}
		ERoom room = dao.findRoom(getReservation().getRoom().getId());
		return room.getDescription();
	}

	public String getRoomImage() {
		if (getReservation().getRoom().getId() == null) {
			getReservation().getRoom().setId(1);
		}

		ERoom room = dao.findRoom(getReservation().getRoom().getId());
		return room.getImages();

	}

	public List<EReservation> getListReservation() {
		return dao.getAllReservations();
	}

	public List<EReservation> getReservationDetailsByKey() {
		return dao.findReservationByKey(getReservation().getReservationKey());
	}

	public void updateReservation() {
		dao.updateReservation(getReservation());
		rest();
	}

	public void deleteReservation() {
		dao.deleteReservation(getReservation());
		rest();
	}

	// ---------------------------------------------------------------------------
	public List<EHotel> getListHotel() {
		return dao.getAllHotels();

	}

	public List<ERoom> getListRoom() {
		return dao.getAllRooms();

	}

	public List<ERoomType> getListRoomType() {
		return dao.getAllRoomsType();

	}

	// ---------------------------------------------------------------------------

	public String nextPage() {
		return "about.xhtml?faces-redirect=true";

	}

	// ---------------------------------------------------------------------------

	public void rest() {
		setAddMode();
		setHotel(null);
		setReservation(null);
		setRoom(null);
		setRoomType(null);
		setGuest(null);

	}

	public List<ERoom> getListRoomById() {
		if (getReservation().getHotel().getId() == null) {
			getReservation().getHotel().setId(1);
		}
		return dao.listRoomByType(getReservation().getHotel(), getReservation().getHotel().getId());
	}
	// ---------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------

	
	private boolean isLogin;

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
	
	
	
		// update record in the databse

	
}
