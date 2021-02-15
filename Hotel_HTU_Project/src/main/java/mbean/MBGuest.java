package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import entity.EGuest;
import entityDao.HotelDao;

@ManagedBean(name = "mbGuest")
public class MBGuest {

	private EGuest guest;
	HotelDao dao = new HotelDao();

	public EGuest getGuest() {
		return guest;
	}

	public void setGuest(EGuest guest) {
		this.guest = guest;
	}

	// ---------------------------------------------------------------------------

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
	// ---------------------------------------------------------------------------

	public void rest() {
		guest = new EGuest();
	}

}
