package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subcategoryitem database table.
 * 
 */
@Entity
@NamedQuery(name="Subcategoryitem.findAll", query="SELECT s FROM Subcategoryitem s")
public class Subcategoryitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String name;

	private double price;

	//bi-directional many-to-one association to Commentitem
	@OneToMany(mappedBy="subcategoryitem")
	private List<Commentitem> commentitems;

	//bi-directional many-to-one association to Paymentorder
	@OneToMany(mappedBy="subcategoryitem")
	private List<Paymentorder> paymentorders;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="subcategoryitem")
	private List<Rate> rates;

	//bi-directional many-to-one association to Image
	@ManyToOne
	private Image image;

	//bi-directional many-to-one association to Subcategory
	@ManyToOne
	private Subcategory subcategory;

	public Subcategoryitem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Commentitem> getCommentitems() {
		return this.commentitems;
	}

	public void setCommentitems(List<Commentitem> commentitems) {
		this.commentitems = commentitems;
	}

	public Commentitem addCommentitem(Commentitem commentitem) {
		getCommentitems().add(commentitem);
		commentitem.setSubcategoryitem(this);

		return commentitem;
	}

	public Commentitem removeCommentitem(Commentitem commentitem) {
		getCommentitems().remove(commentitem);
		commentitem.setSubcategoryitem(null);

		return commentitem;
	}

	public List<Paymentorder> getPaymentorders() {
		return this.paymentorders;
	}

	public void setPaymentorders(List<Paymentorder> paymentorders) {
		this.paymentorders = paymentorders;
	}

	public Paymentorder addPaymentorder(Paymentorder paymentorder) {
		getPaymentorders().add(paymentorder);
		paymentorder.setSubcategoryitem(this);

		return paymentorder;
	}

	public Paymentorder removePaymentorder(Paymentorder paymentorder) {
		getPaymentorders().remove(paymentorder);
		paymentorder.setSubcategoryitem(null);

		return paymentorder;
	}

	public List<Rate> getRates() {
		return this.rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public Rate addRate(Rate rate) {
		getRates().add(rate);
		rate.setSubcategoryitem(this);

		return rate;
	}

	public Rate removeRate(Rate rate) {
		getRates().remove(rate);
		rate.setSubcategoryitem(null);

		return rate;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Subcategory getSubcategory() {
		return this.subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

}