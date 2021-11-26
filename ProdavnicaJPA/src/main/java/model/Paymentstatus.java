package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the paymentstatus database table.
 * 
 */
@Entity
@NamedQuery(name="Paymentstatus.findAll", query="SELECT p FROM Paymentstatus p")
public class Paymentstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String paymentStatusName;

	//bi-directional many-to-one association to Paymentorder
	@OneToMany(mappedBy="paymentstatus")
	private List<Paymentorder> paymentorders;

	public Paymentstatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaymentStatusName() {
		return this.paymentStatusName;
	}

	public void setPaymentStatusName(String paymentStatusName) {
		this.paymentStatusName = paymentStatusName;
	}

	public List<Paymentorder> getPaymentorders() {
		return this.paymentorders;
	}

	public void setPaymentorders(List<Paymentorder> paymentorders) {
		this.paymentorders = paymentorders;
	}

	public Paymentorder addPaymentorder(Paymentorder paymentorder) {
		getPaymentorders().add(paymentorder);
		paymentorder.setPaymentstatus(this);

		return paymentorder;
	}

	public Paymentorder removePaymentorder(Paymentorder paymentorder) {
		getPaymentorders().remove(paymentorder);
		paymentorder.setPaymentstatus(null);

		return paymentorder;
	}

}