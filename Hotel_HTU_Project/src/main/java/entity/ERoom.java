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
@Table(name = "hot_room")
public class ERoom {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "description")
	private String description;
	
	@Column(name = "images")
	private String images;
	
	@Column(name = "room_No")
	private Integer room_No;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private EHotel hotel;

	@ManyToOne
	@JoinColumn(name = "room_type_id")
	private ERoomType roomType;

	@Column(name = "current_price")
	private Double price;

	@Column(name = "is_available")
	private boolean is_available;
	
	@Column(name = "rate")
	private Integer rate;

	
	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Integer getRoom_No() {
		return room_No;
	}

	public void setRoom_No(Integer room_No) {
		this.room_No = room_No;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EHotel getHotel() {
		if (hotel == null) {
			hotel = new EHotel();
		}
		return hotel;
	}

	public void setHotel(EHotel hotel) {
		this.hotel = hotel;
	}

	public ERoomType getRoomType() {
		if (roomType == null) {
			roomType = new ERoomType();
		}
		return roomType;
	}

	public void setRoomType(ERoomType roomType) {
		this.roomType = roomType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isIs_available() {
		return is_available;
	}

	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}

}
