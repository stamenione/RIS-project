package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the paymentorder database table.
 * 
 */
@Entity
@NamedQuery(name="Paymentorder.findAll", query="SELECT p FROM Paymentorder p")
public class Paymentorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Buyer
	@ManyToOne
	private Buyer buyer;

	//bi-directional many-to-one association to Paymentstatus
	@ManyToOne
	private Paymentstatus paymentstatus;

	//bi-directional many-to-one association to Subcategoryitem
	@ManyToOne
	private Subcategoryitem subcategoryitem;

	public Paymentorder() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Paymentstatus getPaymentstatus() {
		return this.paymentstatus;
	}

	public void setPaymentstatus(Paymentstatus paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public Subcategoryitem getSubcategoryitem() {
		return this.subcategoryitem;
	}

	public void setSubcategoryitem(Subcategoryitem subcategoryitem) {
		this.subcategoryitem = subcategoryitem;
	}

}