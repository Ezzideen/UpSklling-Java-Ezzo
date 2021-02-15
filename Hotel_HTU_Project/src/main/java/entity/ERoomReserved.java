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
@Table(name = "hot_room_reserved")
public class ERoomReserved {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	private ERoom room_id;
	
	@ManyToOne
	@JoinColumn(name = "reservation_id")
	private EReservation reservation_id;
	
	@Column(name = "price")
	private double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERoom getRoom_id() {
		return room_id;
	}

	public void setRoom_id(ERoom room_id) {
		this.room_id = room_id;
	}

	public EReservation getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(EReservation reservation_id) {
		this.reservation_id = reservation_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ERoomReserved [id=" + id + ", room_id=" + room_id + ", reservation_id=" + reservation_id + ", price="
				+ price + "]";
	}
	
	
}
