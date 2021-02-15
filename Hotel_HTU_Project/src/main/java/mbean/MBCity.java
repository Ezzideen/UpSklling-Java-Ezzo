package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entity.ECity;
import entityDao.HotelDao;

@ManagedBean(name = "mbCity")
@ViewScoped
public class MBCity extends ButtonActivation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	private ECity city;
	private HotelDao dao = new HotelDao();

	// ---------------------------------------------------------------------------

	public MBCity() {
		super();
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

	// ---------------------------------------------------------------------------

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
	// ------------------------------------------------------getCountCity-----------------


	// -------------------------------------------------------getCityName--------------------

	public String getCityName(int id) throws Exception {
		String cityName= null;
		for (int i = 0; i < getListCity().size(); i++) {
			if (id == getListCity().get(i).getId()) {
				cityName= getListCity().get(i).getName();
			}
		}
		return cityName;
	}

	// ---------------------------------------------------------------------------

	public void rest() {
		setAddMode();
		city = new ECity();
	}

}
