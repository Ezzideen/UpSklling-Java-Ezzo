package mbean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.jk.web.faces.mb.JKManagedBean;
import com.jk.web.util.JKJsfUtil;

import entity.ECategory;
import entity.ECity;
import entity.ECompany;
import entity.EGuest;
import entity.EHotel;
import entity.EReservation;
import entity.ERoom;
import entity.ERoomType;
import entityDao.HotelDao;

@ManagedBean(name = "mbAdminHome")
@RequestScoped
public class MBAdminHome extends JKManagedBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 16L;
	
	private EHotel hotel;
	private EReservation reservation;
	private ERoom room;
	private ECategory category;
	private ECity city;
	private ECompany company;
	private ERoomType roomType;
	private EGuest guest;
	private HotelDao dao = new HotelDao();
	
	// ----------------------------------------------------------Setter & Getter---------------------------------------------------

	public EHotel getHotel() {
		return hotel;
	}

	public void setHotel(EHotel hotel) {
		this.hotel = hotel;
	}

	public EReservation getReservation() {
		return reservation;
	}

	public void setReservation(EReservation reservation) {
		this.reservation = reservation;
	}

	public ERoom getRoom() {
		return room;
	}

	public void setRoom(ERoom room) {
		this.room = room;
	}

	public ECategory getCategory() {
		return category;
	}

	public void setCategory(ECategory category) {
		this.category = category;
	}

	public ECity getCity() {
		return city;
	}

	public void setCity(ECity city) {
		this.city = city;
	}

	public ECompany getCompany() {
		return company;
	}

	public void setCompany(ECompany company) {
		this.company = company;
	}

	public ERoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(ERoomType roomType) {
		this.roomType = roomType;
	}

	public EGuest getGuest() {
		return guest;
	}

	public void setGuest(EGuest guest) {
		this.guest = guest;
	}

	// ----------------------------------------------------------EntityDao---------------------------------------------------

	
	public List<EHotel> getListHotel() throws Exception {
		return dao.getAllHotels();
	}
	
	public List<EGuest> getListGuest() throws Exception {
		return dao.getAllGuests();
	}
	
	public List<ECompany> getListCompany() throws Exception {
		return dao.getAllCompanys();
	}
	
	public List<EReservation> getListReservation() {
		return dao.getAllReservations();
	}
	
	public List<ERoom> getListRoom() throws Exception {
		return dao.getAllRooms();
	}
	
	public List<ECity> getListCity() throws Exception {
		return dao.getAllCities();
	}
	public List<ECategory> getListCategory() throws Exception {
		return dao.getAllCategorys();
	}
	
    //----------------------------------------------------------System-State---------------------------------------------------
	// -------------------------------------------------------getCountHotels--------------------

	public int getCountHotels() throws Exception {
		return getListHotel().size();
	}
	
	// -------------------------------------------------------getAvailableHotels--------------------

	public int getAvailableHotels() throws Exception {
		int count = 0;
		for (int i = 0; i < getListHotel().size(); i++)
			if (getListHotel().get(i).isIs_active()) {
				count = count + 1;
			}
		return count;
	}
	
	// -------------------------------------------------------getCountReservations--------------------

	public int getCountReservations() {
		return getListReservation().size();
	}
	
	// -------------------------------------------------------getCountCompany--------------------

	public int getCountCompany() throws Exception {
		return getListCompany().size();
	}
	
	// -------------------------------------------------------getCountCity--------------------

	public int getCountCity() throws Exception {
		return getListCity().size();
	}

	// -------------------------------------------------------getCountRooms--------------------

	public int getCountRooms() throws Exception {
		return getListRoom().size();
	}
	
	// -------------------------------------------------------getCountGuests--------------------

	public int getCountGuests() throws Exception {
		return getListGuest().size();
	}
	
	// ------------------------------------------------------getCountCategory-----------------

	public int getCountCategory() throws Exception {
		return getListCategory().size();
	}
	
	// -------------------------------------------------------PagesSwither--------------------
	
	public String logoutButton() throws IOException {
		JKJsfUtil.invalidateSession();
		redirect("/htu/pages/login.xhtml");
		return null;
	}
	
	public String adminsrationButton() {
		JKJsfUtil.invalidateSession();
		redirect("template/homepage_templete.xhtml");
		return null;
	}
	
	public String statusButton() {
		JKJsfUtil.invalidateSession();
		redirect("template/homepage_templete.xhtml");
		return null;
	}
	
	public String UsersButton() {
		JKJsfUtil.invalidateSession();
		redirect("template/homepage_templete.xhtml");
		return null;
	}

}
