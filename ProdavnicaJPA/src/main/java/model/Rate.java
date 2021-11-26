package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rate database table.
 * 
 */
@Entity
@NamedQuery(name="Rate.findAll", query="SELECT r FROM Rate r")
public class Rate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double rateValue;

	//bi-directional many-to-one association to Buyer
	@ManyToOne
	private Buyer buyer;

	//bi-directional many-to-one association to Subcategoryitem
	@ManyToOne
	private Subcategoryitem subcategoryitem;

	public Rate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRateValue() {
		return this.rateValue;
	}

	public void setRateValue(double rateValue) {
		this.rateValue = rateValue;
	}

	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Subcategoryitem getSubcategoryitem() {
		return this.subcategoryitem;
	}

	public void setSubcategoryitem(Subcategoryitem subcategoryitem) {
		this.subcategoryitem = subcategoryitem;
	}

}