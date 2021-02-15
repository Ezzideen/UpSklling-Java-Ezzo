package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hot_company")
public class ECompany {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "VAT_ID")
    private String VAT_ID;
    
    @Column(name = "email")
    private String email;

    @Column(name = "company_address")
    private String address;
    
    @Column(name = "details")
    private String details;
    
    @Column(name = "is_active")
    private boolean is_active;
    
    @ManyToOne
    @JoinColumn(name = "city_id")
    private ECity city;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVAT_ID() {
		return VAT_ID;
	}

	public void setVAT_ID(String vAT_ID) {
		VAT_ID = vAT_ID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
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
    
    

}
