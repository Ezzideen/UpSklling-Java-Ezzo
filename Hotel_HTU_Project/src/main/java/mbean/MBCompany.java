package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entity.ECompany;
import entityDao.HotelDao;

@ManagedBean(name = "mbCompany")
@ViewScoped
public class MBCompany extends ButtonActivation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;
	private ECompany company;
	private HotelDao dao = new HotelDao();

	
	public MBCompany() {
		super();
	}
	
	
	public ECompany getCompany() {
		if(company == null) {
			company = new ECompany();
		}
		return company;
	}

	public void setCompany(ECompany company) {
		this.company = company;
	}
	// ---------------------------------------------------------------------------

	public void addCompany() throws Exception {
		dao.insertCompany(getCompany());
		rest();
	}

	public int getCountCompany() throws Exception {
		return getListCompany().size();
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
	
	// -------------------------------------------------------getCompanyName--------------------

	public String getCompanyName(int id) throws Exception {
		String companyName = null;
		for (int i = 0; i < getListCompany().size(); i++) {
			if (id == getListCompany().get(i).getId()) {
				companyName = getListCompany().get(i).getName();
			}
		}
		return companyName;
	}

	// ----------------------------------------rest----------------------------------

	public void rest() {
		setAddMode();
		company = new ECompany();
	}

}
