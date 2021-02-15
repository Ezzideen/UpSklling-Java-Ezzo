package mbean;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.jk.web.util.JKJsfUtil;

import entity.EAdminEvent;
import entity.ECategory;
import entity.ECity;
import entity.ECompany;
import entity.ECountry;
import entity.EGuest;
import entity.EHotel;
import entity.EReservation;
import entity.ERoom;
import entity.ERoomType;
import entity.EUser;
import entityDao.HotelDao;

@ManagedBean(name = "mbAdminAdministration")
@SessionScoped
public class MBAdminAdministration extends ButtonActivation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 18L;

	private EHotel hotel;
	private EReservation reservation;
	private ERoom room;
	private ECategory category;
	private ECity city;
	private ECompany company;
	private ERoomType roomType;
	private EGuest guest;
	private EUser user;
	private EAdminEvent adminEvent;
	private ECountry country;
	private HotelDao dao = new HotelDao();

	// ---------------MessageOut-------------------------------------------
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}
	// ---------------Setter & Getter-------------------------------------------

	public ERoom getRoom() {
		if (room == null) {
			room = new ERoom();
		}
		return room;
	}

	public void setRoom(ERoom room) {
		this.room = room;
	}

	public EAdminEvent getAdminEvent() {
		if(adminEvent == null)
			adminEvent = new EAdminEvent();
		return adminEvent;
	}

	public void setAdminEvent(EAdminEvent adminEvent) {
		this.adminEvent = adminEvent;
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

	public ECountry getCountry() {
		if (country == null) {
			country = new ECountry();
		}
		return country;
	}

	public void setCountry(ECountry country) {
		this.country = country;
	}

	public EHotel getHotel() {
		if (hotel == null) {
			hotel = new EHotel();
		}
		return hotel;
	}

	public void setHotel(EHotel hotel) {
		this.hotel = hotel;
	}

	public EReservation getReservation() {
		if (reservation == null) {
			reservation = new EReservation();
		}
		return reservation;
	}

	public void setReservation(EReservation reservation) {
		this.reservation = reservation;
	}

	public ECategory getCategory() {
		if (category == null) {
			category = new ECategory();
		}
		return category;
	}

	public void setCategory(ECategory category) {
		this.category = category;
	}

	public ECity getCity() {
		if (city == null) {
			city = new ECity();
		}
		return city;
	}

	public void setCity(ECity city) {
		this.city = city;
	}

	public ECompany getCompany() {
		if (company == null) {
			company = new ECompany();
		}
		return company;
	}

	public void setCompany(ECompany company) {
		this.company = company;
	}

	public ERoomType getRoomType() {
		if (roomType == null) {
			roomType = new ERoomType();
		}
		return roomType;
	}

	public void setRoomType(ERoomType roomType) {
		this.roomType = roomType;
	}

	public EGuest getGuest() {
		if (guest == null) {
			guest = new EGuest();
		}
		return guest;
	}

	public void setGuest(EGuest guest) {
		this.guest = guest;
	}

	// -----------------------------------------------------------------EntityDao---------------------------------------------------
	// -----------------------------------------------------------------EHotel---------------------------------------------------

	public void addHotel() throws Exception {
		dao.insertHotel(getHotel());
		rest();
	}

	public List<EHotel> getListHotel() throws Exception {
		return dao.getAllHotels();
	}

	public void updateHotel() throws Exception {
		dao.updateHotel(getHotel());
		rest();
	}

	public void deleteHotel() throws Exception {
		dao.deleteHotel(getHotel());
		rest();
	}
	// -----------------------------------------------------------------ECountry---------------------------------------------------

	public void addCountry() throws Exception {
		dao.insertCountry(getCountry());
		rest();
	}

	public List<ECountry> getListCountry() throws Exception {
		return dao.getAllCountrys();

	}

	public void updateCountry() throws Exception {
		dao.updateCountry(getCountry());
		rest();
	}

	public void deleteCountry() throws Exception {
		dao.deleteCountry(getCountry());
		rest();
	}
	
	// -----------------------------------------------------------------EUser---------------------------------------------------

		public void addUser() throws Exception {
			dao.insertUser(getUser());
			rest();
		}

		public List<EUser> getListUsers() throws Exception {
			return dao.getAllUsers();

		}

		public void updateUser() throws Exception {
			dao.updateUser(getUser());
			rest();
		}

		public void deleteUser() throws Exception {
			dao.deleteUser(getUser());
			rest();
		}
		
	// -----------------------------------------------------------------EGuest---------------------------------------------------

	public void addGuest() throws Exception {
		dao.insert(getGuest());
		rest();
	}

	public List<EGuest> getListGuest() throws Exception {
		return dao.getAllGuests();
	}

	public void updateGuest() throws Exception {
		dao.updateGuest(getGuest());
		rest();
	}

	public void deleteGuest() throws Exception {
		dao.deleteGuest(getGuest());
		rest();
	}

	// -----------------------------------------------------------------ECompany---------------------------------------------------

	public void addCompany() throws Exception {
		dao.insertCompany(getCompany());
		rest();
	}

	public List<ECompany> getListCompany() throws Exception {
		return dao.getAllCompanys();
	}

	public void updateCompany() throws Exception {
		dao.updateCompany(getCompany());
		rest();
	}

	public void deleteCompany() throws Exception {
		dao.deleteCompany(getCompany());
		rest();
	}
	// -----------------------------------------------------------------EReservation---------------------------------------------------

	public void addReservation() {
		// Room-Checked
		if (roomChecked()) {
			// date-Checked
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			getReservation().setCreatedDate(dtf.format(now));
			getReservation().setUpdatedDate(dtf.format(now));
			getReservation().setTotalPrice(getRoom().getPrice());
			getReservation().setDiscount(0);
			// Guest-Checked
			dao.insertGuest(getGuest());
			// Reservation-Checked
			getReservation().getGuest().setId(getGuest().getId());
			dao.insertReservation(getReservation());
		}

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

	public List<EReservation> getListReservation() {
		return dao.getAllReservations();
	}

	public void updateReservation() {
		dao.updateReservation(getReservation());
		rest();
	}

	public void deleteReservation() {
		dao.deleteReservation(getReservation());
		rest();
	}
	// -----------------------------------------------------------------ERoom--&--ERoomType---------------------------------------------------

	public void addRoom() throws Exception {
		dao.insertRoom(getRoom());
		rest();
	}
	
	public void addRoomType() throws Exception {
		dao.insertRoomType(getRoomType());
		rest();
	}

	public List<ERoom> getListRoom() throws Exception {
		return dao.getAllRooms();
	}

	public List<ERoomType> getListRoomType() throws Exception {
		return dao.getAllRoomsType();

	}

	public void updateRoom() throws Exception {
		dao.updateRoom(getRoom());
		rest();
	}
	
	public void updateRoomType() throws Exception {
		dao.updateRoomType(getRoomType());
		rest();
	}

	public void deleteRoom() throws Exception {
		dao.deleteRoom(getRoom());
		rest();
	}
	
	public void deleteRoomType() throws Exception {
		dao.deleteRoomType(getRoomType());
		rest();
	}

	// -----------------------------------------------------------------ECity---------------------------------------------------

	public void addCity() throws Exception {
		dao.insertCity(getCity());
		rest();
	}

	public List<ECity> getListCity() throws Exception {
		return dao.getAllCities();
	}

	public void updateCity() throws Exception {
		dao.updateCity(getCity());
		rest();
	}

	public void deleteCity() throws Exception {
		dao.deleteCity(getCity());
		rest();
	}

	// -----------------------------------------------------------------ECategory---------------------------------------------------

	public void addCategory() throws Exception {
		dao.insertCategory(getCategory());
		rest();
	}

	public List<ECategory> getListCategory() throws Exception {
		return dao.getAllCategorys();
	}

	public void updateCategory() throws Exception {
		dao.updateCategory(getCategory());
		rest();
	}

	public void deleteCategory() throws Exception {
		dao.deleteCategory(getCategory());
		rest();
	}
	
	// -----------------------------------------------------------------EAdminEvent---------------------------------------------------

		public void addAdminEvent() throws Exception {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			getAdminEvent().setDateCreated(dtf.format(now));
			dao.insertAdmin(getAdminEvent());
			rest();
		}
		
		public List<EAdminEvent> getListAdminEvent() throws Exception {
			return dao.getAllAdmins();
		}

		public void updateAdmin() throws Exception {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			getAdminEvent().setDateCreated(dtf.format(now));
			dao.updateAdmin(getAdminEvent());
			rest();
		}

		public void deleteAdmin() throws Exception {
			dao.deleteAdmin(getAdminEvent());
			rest();
		}

	// ---------------------------------------------------------------------PagesSwither--------------------

	public String hotelManagementButton() throws IOException {
		JKJsfUtil.invalidateSession();
		redirect("admin_hotel_managment.xhtml");
		return null;
	}

	public String adminsrationButton() {
		JKJsfUtil.invalidateSession();
		redirect("admin_administration.xhtml");
		return null;
	}

	public String statusButton() {
		JKJsfUtil.invalidateSession();
		redirect("#");
		return null;
	}

	public String categoryManagementButton() {
		JKJsfUtil.invalidateSession();
		redirect("admin_category_management.xhtml");
		return null;
	}
	
	public String cityManagementButton() {
		JKJsfUtil.invalidateSession();
		redirect("admin_city_management.xhtml");
		return null;
	}
	
	public String companyManagementButton() {
		JKJsfUtil.invalidateSession();
		redirect("admin_company_management.xhtml");
		return null;
	}
	
	public String countryManagementButton() {
		JKJsfUtil.invalidateSession();
		redirect("admin_country_management.xhtml");
		return null;
	}
	
	public String homeButton() {
		JKJsfUtil.invalidateSession();
		redirect("admin_home.xhtml");
		return null;
	}
	
	public String websiteManagementButton() {
		JKJsfUtil.invalidateSession();
		redirect("admin_website_management.xhtml");
		return null;
	}
	
	public String userManagementButton() {
		JKJsfUtil.invalidateSession();
		redirect("admin_user_managment.xhtml");
		return null;
	}
	
	public String roomTypeManagementButton() {
		JKJsfUtil.invalidateSession();
		redirect("admin_roomtype_management.xhtml");
		return null;
	}
	// ---------------------------------------RestActions-----------------------------------

	public void rest() {
		setAddMode();
		setReservation(null);
		setRoom(null);
		setCategory(null);
		setCity(null);
		setCompany(null);
		setRoomType(null);
		setGuest(null);
		setUser(null);
		setCountry(null);
		adminEvent = new EAdminEvent();
		hotel = new EHotel();
	}
}
