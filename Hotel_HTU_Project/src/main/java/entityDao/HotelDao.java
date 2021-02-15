package entityDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.db.dataaccess.orm.JKObjectDataAccessImpl;

import entity.EAdminEvent;
import entity.ECategory;
import entity.ECity;
import entity.ECompany;
import entity.ECountry;
import entity.EGuest;
import entity.EGuestInvoice;
import entity.EHotel;
import entity.EReservation;
import entity.ERoom;
import entity.ERoomReserved;
import entity.ERoomType;
import entity.EUser;

public class HotelDao extends JKObjectDataAccessImpl {
	// ============================================================================================================================
	// Category
	// ================================================================Category============================================================

	public void insertCategory(ECategory category) {
		insert(category);
	}

	public List<ECategory> getAllCategorys() {
		List<ECategory> list = getList(ECategory.class);
		return list;
	}

	public void updateCategory(ECategory category) {
		update(category);
	}

	public void deleteCategory(ECategory category) {
		delete(category);
	}

	public ECategory findCategory(int id) {
		return find(ECategory.class, id);
	}

	// ============================================================================================================================
	// City
	// =================================================================City===========================================================

	public void insertCity(ECity city) {
		insert(city);
	}

	public List<ECity> getAllCities() {
		List<ECity> list = getList(ECity.class);
		return list;
	}

	public void updateCity(ECity city) {
		update(city);
	}

	public void deleteCity(ECity city) {
		delete(city);
	}

	public ECity findCityById(int id) {
		return find(ECity.class, id);
	}

	// ============================================================================================================================
	// Company
	// =========================================================================Company===================================================
	public void insertCompany(ECompany company) {
		insert(company);
	}

	public List<ECompany> getAllCompanys() {
		List<ECompany> list = getList(ECompany.class);
		return list;
	}

	public void updateCompany(ECompany company) {
		update(company);
	}

	public void deleteCompany(ECompany company) {
		delete(company);
	}

	public ECompany findCompany(int id) {
		return find(ECompany.class, id);
	}

	// ============================================================================================================================
	// Country
	// ========================================================================Country====================================================
	public void insertCountry(ECountry country) {
		insert(country);
	}

	public List<ECountry> getAllCountrys() {
		List<ECountry> list = getList(ECountry.class);
		return list;
	}

	public void updateCountry(ECountry country) {
		update(country);
	}

	public void deleteCountry(ECountry country) {
		delete(country);
	}

	public ECountry findCountry(int id) {
		return find(ECountry.class, id);
	}

	// ============================================================================================================================
	// Guest
	// =========================================================================Guest===================================================
	public void insertGuest(EGuest guest) {
		insert(guest);
	}

	public List<EGuest> getAllGuests() {
		List<EGuest> list = getList(EGuest.class);
		return list;
	}

	public void updateGuest(EGuest guest) {
		update(guest);
	}

	public void deleteGuest(EGuest guest) {
		delete(guest);
	}

	public EGuest findGuest(int id) {
		return find(EGuest.class, id);
	}
	// ============================================================================================================================
	// Hotel
	// ============================================================================Hotel================================================

	public void insertHotel(EHotel hotel) {
		insert(hotel);
	}

	public List<EHotel> getAllHotels() {
		List<EHotel> list = getList(EHotel.class);
		return list;
	}

	public void updateHotel(EHotel hotel) {
		update(hotel);
	}

	public void deleteHotel(EHotel hotel) {
		delete(hotel);
	}

	public EHotel findHotel(int id) {
		return find(EHotel.class, id);
	}

	// ============================================================================================================================
	// Reservation
	// ==============================================================================Reservation==============================================
	public void insertReservation(EReservation reservation) {
		insert(reservation);
	}

	public List<EReservation> getAllReservations() {
		List<EReservation> list = getList(EReservation.class);
		return list;
	}

	public void updateReservation(EReservation reservation) {
		update(reservation);
	}

	public void deleteReservation(EReservation reservation) {
		delete(reservation);
	}

	public EReservation findReservation(int id) {
		return find(EReservation.class, id);
	}

	public List<EReservation> findReservationByKey(int id) {
		return findByFieldName(EReservation.class, "reservationKey", id);
	}

	// ============================================================================================================================
	// Room
	// ==================================================================Room==&==RoomType=========================================

	public void insertRoom(ERoom room) {
		insert(room);
	}

	public void insertRoomType(ERoomType roomType) {
		insert(roomType);
	}

	public List<ERoom> getAllRooms() {
		List<ERoom> list = getList(ERoom.class);
		return list;
	}

	public List<ERoomType> getAllRoomsType() {
		List<ERoomType> list = getList(ERoomType.class);
		return list;
	}

	public void updateRoom(ERoom room) {
		update(room);
	}

	public void updateRoomType(ERoomType roomType) {
		update(roomType);
	}

	public void deleteRoom(ERoom room) {
		delete(room);
	}

	public void deleteRoomType(ERoomType roomType) {
		delete(roomType);
	}

	public ERoom findRoom(int id) {
		return find(ERoom.class, id);
	}

	public ERoomType findRoomType(int id) {
		return find(ERoomType.class, id);
	}
	public List<ERoom> findRoomByName(int id) {
		return findByFieldName(ERoom.class,"id", id);
	}
	
	public List<ERoom> listRoomByType(EHotel hotel, int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hotel.id", id);
		return getList(ERoom.class, map);
	}
	// ============================================================================================================================
	// User
	// ==================================================================User==========================================================

	public void insertUser(EUser user) {
		insert(user);
	}

	public List<EUser> getAllUsers() {
		List<EUser> list = getList(EUser.class);
		return list;
	}

	public void updateUser(EUser user) {
		update(user);
	}

	public void deleteUser(EUser user) {
		delete(user);
	}

	public EUser findUser(int id) {
		return find(EUser.class, id);
	}

	public EUser checkUserLogin(EUser user) {
		return findOneByFieldName(EUser.class, "username", user.getUsername());
	}

//	public List<EUser> checkUserLoginAdmin(EUser user) {
//		return findByFieldName(EUser.class, "username", user.getUsername());
//	}

	// ============================================================================================================================
	// Admin Event
	// ==================================================================User==========================================================

	public void insertAdmin(EAdminEvent admin) {
		insert(admin);
	}

	public List<EAdminEvent> getAllAdmins() {
		List<EAdminEvent> list = getList(EAdminEvent.class);
		return list;
	}

	public void updateAdmin(EAdminEvent admin) {
		update(admin);
	}

	public void deleteAdmin(EAdminEvent admin) {
		delete(admin);
	}

	public EAdminEvent findAdmin(int id) {
		return find(EAdminEvent.class, id);
	}

	// ============================================================================================================================
	// Guest Invoice
	// ==================================================================User==========================================================

	public void insertGuestInvoice(EGuestInvoice guest) {
		insert(guest);
	}

	public List<EGuestInvoice> getAllGuestsInvoice() {
		List<EGuestInvoice> list = getList(EGuestInvoice.class);
		return list;
	}

	public void updateGuestInvoice(EGuestInvoice guest) {
		update(guest);
	}

	public void deleteGuestInvoice(EGuestInvoice guest) {
		delete(guest);
	}

	public EGuestInvoice findGuestInvoice(int id) {
		return find(EGuestInvoice.class, id);
	}

	// ============================================================================================================================
	// Room Reserved
	// ==================================================================User==========================================================

	public void insertRoomReserved(ERoomReserved roomReserved) {
		insert(roomReserved);
	}

	public List<ERoomReserved> getAllRoomReserved() {
		List<ERoomReserved> list = getList(ERoomReserved.class);
		return list;
	}

	public void updateRoomReserved(ERoomReserved roomReserved) {
		update(roomReserved);
	}

	public void deleteRoomReserved(ERoomReserved roomReserved) {
		delete(roomReserved);
	}

	public ERoomReserved findRoomReserved(int id) {
		return find(ERoomReserved.class, id);
	}
	

	// ------------------------------------------------------------------------------------------

	// ------------------------------------------------------------------------------------------

//	public boolean checkUserLoginTow(String name, String pass) {
//		List<EUser> list = getList(EUser.class);
//		boolean exist = false;
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getUsername().equals(name)) {
//				if (list.get(i).getPassword().equals(pass))
//					exist = true;
//			}
//		}
//		return exist;
//	}

}
