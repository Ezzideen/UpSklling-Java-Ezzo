package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entity.ECountry;
import entityDao.HotelDao;

@ManagedBean(name = "mbCountry")
@ViewScoped
public class MBCountry extends ButtonActivation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;
	private ECountry country;
	HotelDao dao = new HotelDao();

	// ---------------------------------------------------------------------------

	public MBCountry() {
		super();
	}
	
	public ECountry getCountry() {
		if(country == null) {
			country = new ECountry();
		}
		return country;
	}

	public void setCountry(ECountry country) {
		this.country = country;
	}

	// -----------------------------------dao----------------------------------------

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
	
	public int getCountCountry() throws Exception {
		return getListCountry().size();
	}

	// ---------------------------------------------------------------------------

	public void rest() {
		setAddMode();
		country = new ECountry();
	}

}
