package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entity.EHotel;
import entityDao.HotelDao;

@ManagedBean(name = "mbHotel")
@ViewScoped
public class MBHotel extends ButtonActivation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private EHotel hotel;
	private HotelDao dao = new HotelDao();

	//------------------------------------------------------------------------------

	public MBHotel() {
		super();
	}
	
	
	
	//------------------------------------------------------------------------------
	public EHotel getHotel() {
		if (hotel == null) {
			hotel = new EHotel();
		}
		return hotel;
	}

	public void setHotel(EHotel hotel) {
		this.hotel = hotel;
	}

	// ---------------------------------------------------------------------------

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

	// ------------------------------------------------------getCountHotels---------------------

	public int getCountHotels() throws Exception {
		return getListHotel().size();
	}

	// -------------------------------------------------------getHotelName--------------------

	public String getHotelName(int id) throws Exception {
		String hotelName = null;
		for (int i = 0; i < getListHotel().size(); i++) {
			if (id == getListHotel().get(i).getId()) {
				hotelName = getListHotel().get(i).getName();
			}
		}
		return hotelName;
	}

	// -------------------------------------------------------getHotelDescription--------------------

		public String getHotelDescription(int id) throws Exception {
			String hotelDescription = null;
			for (int i = 0; i < getListHotel().size(); i++) {
				if (id == getListHotel().get(i).getId()) {
					hotelDescription = getListHotel().get(i).getDescription();
				}
			}
			return hotelDescription;
		}

		// -------------------------------------------------------getHotelRate--------------------

				public int getHotelRate(int id) throws Exception {
					int hotelRate = 0;
					for (int i = 0; i < getListHotel().size(); i++) {
						if (id == getListHotel().get(i).getId()) {
							hotelRate = getListHotel().get(i).getRate();
						}
					}
					return hotelRate;
				}
	// ---------------------------------------rest-----------------------------------

	public void rest() {
		setAddMode();
		hotel = new EHotel();
	}

}
