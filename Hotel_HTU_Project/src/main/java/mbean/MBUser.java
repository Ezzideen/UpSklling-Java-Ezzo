package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import entity.EUser;
import entityDao.HotelDao;

@ManagedBean(name = "mbUser")
public class MBUser {
	
	
	private EUser user;
	HotelDao dao = new HotelDao();
	
		public EUser getUser() {
		return user;
	}

	public void setUser(EUser user) {
		this.user = user;
	}
	// ---------------------------------------------------------------------------

		public void addUser() throws Exception {
			dao.insertUser(getUser());
			rest();
		}

		public List<EUser> getListUser() throws Exception {
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
		
		public int getCountUsers() throws Exception {
			return getListUser().size();
		}

		// ---------------------------------------------------------------------------

		public void rest() {
			user = new EUser();
		}

}
