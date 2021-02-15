package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hot_reservation")
public class EReservation {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "guest_id")
	private EGuest guest;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "ts_created")
	private String createdDate;

	@Column(name = "ts_updated")
	private String updatedDate;

	@Column(name = "discount_percent")
	private double discount;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "reservation_key")
	private int reservationKey;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private EHotel hotel;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private ERoom room;

	public int getReservationKey() {
		return reservationKey;
	}

	public void setReservationKey(int reservationKey) {
		this.reservationKey = reservationKey;
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

	public ERoom getRoom() {
		if (room == null) {
			room = new ERoom();
		}
		return room;
	}

	public void setRoom(ERoom room) {
		this.room = room;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EGuest getGuest() {
		if (guest == null) {
			guest = new EGuest();
		}
		return guest;
	}

	public void setGuest(EGuest guest) {
		this.guest = guest;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
