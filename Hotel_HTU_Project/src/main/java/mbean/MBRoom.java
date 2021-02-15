package mbean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entity.ERoom;
import entity.ERoomType;
import entityDao.HotelDao;

@ManagedBean(name = "mbRoom")
@ViewScoped
public class MBRoom extends ButtonActivation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 15L;
	private ERoom room;
	private HotelDao dao = new HotelDao();
	private int listId;

	public MBRoom() {
		super();
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public ERoom getRoom() {
		if (room == null) {
			room = new ERoom();
		}
		return room;
	}

	public void setRoom(ERoom room) {
		this.room = room;
	}

	// ---------------------------------------------------------------------------

	public void addRoom() throws Exception {
		dao.insertRoom(getRoom());
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

	public void deleteRoom() throws Exception {
		dao.deleteRoom(getRoom());
		rest();
	}




	
	// ------------------------------------------rest---------------------------------

	public void rest() {
		room = new ERoom();
	}

}
