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
@Table(name = "hot_invoice_guest")
public class EGuestInvoice {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "guest_id")
	private EGuest guest_id;
	
	@ManyToOne
	@JoinColumn(name = "reservation_id")
	private EReservation reservation_id;
	
	@Column(name = "invoice_amount")
	private double invoice_amount;
	
	@Column(name = "ts_issued")
	private String ts_issued;
	
	@Column(name = "ts_paid")
	private String ts_paid;
	
	@Column(name = "ts_canceled")
	private String ts_canceled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EGuest getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(EGuest guest_id) {
		this.guest_id = guest_id;
	}

	public EReservation getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(EReservation reservation_id) {
		this.reservation_id = reservation_id;
	}

	public double getInvoice_amount() {
		return invoice_amount;
	}

	public void setInvoice_amount(double invoice_amount) {
		this.invoice_amount = invoice_amount;
	}

	public String getTs_issued() {
		return ts_issued;
	}

	public void setTs_issued(String ts_issued) {
		this.ts_issued = ts_issued;
	}

	public String getTs_paid() {
		return ts_paid;
	}

	public void setTs_paid(String ts_paid) {
		this.ts_paid = ts_paid;
	}

	public String getTs_canceled() {
		return ts_canceled;
	}

	public void setTs_canceled(String ts_canceled) {
		this.ts_canceled = ts_canceled;
	}

	@Override
	public String toString() {
		return "EGuestInvoice [id=" + id + ", guest_id=" + guest_id + ", reservation_id=" + reservation_id
				+ ", invoice_amount=" + invoice_amount + ", ts_issued=" + ts_issued + ", ts_paid=" + ts_paid
				+ ", ts_canceled=" + ts_canceled + "]";
	}
	
	
}
