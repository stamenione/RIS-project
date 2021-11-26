package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the buyer database table.
 * 
 */
@Entity
@NamedQuery(name="Buyer.findAll", query="SELECT b FROM Buyer b")
public class Buyer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	private String firstname;

	private String lastname;

	//bi-directional many-to-one association to Account
	@ManyToOne
	private Account account;

	//bi-directional many-to-one association to Commentitem
	@OneToMany(mappedBy="buyer")
	private List<Commentitem> commentitems;

	//bi-directional many-to-one association to Favoriteseller
	@OneToMany(mappedBy="buyer")
	private List<Favoriteseller> favoritesellers;

	//bi-directional many-to-one association to Paymentorder
	@OneToMany(mappedBy="buyer")
	private List<Paymentorder> paymentorders;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="buyer")
	private List<Rate> rates;

	public Buyer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Commentitem> getCommentitems() {
		return this.commentitems;
	}

	public void setCommentitems(List<Commentitem> commentitems) {
		this.commentitems = commentitems;
	}

	public Commentitem addCommentitem(Commentitem commentitem) {
		getCommentitems().add(commentitem);
		commentitem.setBuyer(this);

		return commentitem;
	}

	public Commentitem removeCommentitem(Commentitem commentitem) {
		getCommentitems().remove(commentitem);
		commentitem.setBuyer(null);

		return commentitem;
	}

	public List<Favoriteseller> getFavoritesellers() {
		return this.favoritesellers;
	}

	public void setFavoritesellers(List<Favoriteseller> favoritesellers) {
		this.favoritesellers = favoritesellers;
	}

	public Favoriteseller addFavoriteseller(Favoriteseller favoriteseller) {
		getFavoritesellers().add(favoriteseller);
		favoriteseller.setBuyer(this);

		return favoriteseller;
	}

	public Favoriteseller removeFavoriteseller(Favoriteseller favoriteseller) {
		getFavoritesellers().remove(favoriteseller);
		favoriteseller.setBuyer(null);

		return favoriteseller;
	}

	public List<Paymentorder> getPaymentorders() {
		return this.paymentorders;
	}

	public void setPaymentorders(List<Paymentorder> paymentorders) {
		this.paymentorders = paymentorders;
	}

	public Paymentorder addPaymentorder(Paymentorder paymentorder) {
		getPaymentorders().add(paymentorder);
		paymentorder.setBuyer(this);

		return paymentorder;
	}

	public Paymentorder removePaymentorder(Paymentorder paymentorder) {
		getPaymentorders().remove(paymentorder);
		paymentorder.setBuyer(null);

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
		rate.setBuyer(this);

		return rate;
	}

	public Rate removeRate(Rate rate) {
		getRates().remove(rate);
		rate.setBuyer(null);

		return rate;
	}

}