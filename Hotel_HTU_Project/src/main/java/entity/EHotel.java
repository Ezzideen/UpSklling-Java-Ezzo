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
@Table(name = "hot_hotel")
public class EHotel {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private ECompany company;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private ECity city;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private ECategory category;

	@Column(name = "is_active")
	private boolean is_active;

	@Column(name = "rate")
	private int rate;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ECompany getCompany() {
		if (company == null) {
			company = new ECompany();
		}
		return company;
	}

	public void setCompany(ECompany company) {
		this.company = company;
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

	public ECategory getCategory() {
		if (category == null) {
			category = new ECategory();
		}
		return category;
	}

	public void setCategory(ECategory category) {
		this.category = category;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
