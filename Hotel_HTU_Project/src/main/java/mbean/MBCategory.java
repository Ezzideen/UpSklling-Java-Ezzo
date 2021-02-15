package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entity.ECategory;
import entityDao.HotelDao;

@ManagedBean(name = "mbCategory")
@ViewScoped
public class MBCategory extends ButtonActivation {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;
	
	private ECategory category;
	private HotelDao dao = new HotelDao();

	// ---------------------------------------------------------------------------

	public MBCategory() {
		super();
	}
	
	public ECategory getCategory() {
		if(category == null) {
			category = new ECategory();
		}
		return category;
	}

	public void setCategory(ECategory category) {
		this.category = category;
	}
	
	// ---------------------------------------------------------------------------

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

	// -------------------------------------------------------getCityName--------------------

	public String getCategoryName(int id) throws Exception {
		String categoryName= null;
		for (int i = 0; i < getListCategory().size(); i++) {
			if (id == getListCategory().get(i).getId()) {
				categoryName= getListCategory().get(i).getName();
			}
		}
		return categoryName;
	}

	// ---------------------------------------------------------------------------

	public void rest() {
		setAddMode();
		category = new ECategory();
	}


}
