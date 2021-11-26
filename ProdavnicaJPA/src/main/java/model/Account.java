package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String city;

	private String email;

	private String isactive;

	private String passwordhash;

	private String phone;

	private String postalcode;

	//bi-directional many-to-one association to Accounttype
	@ManyToOne
	private Accounttype accounttype;

	//bi-directional many-to-one association to Image
	@ManyToOne
	private Image image;

	//bi-directional many-to-one association to Buyer
	@OneToMany(mappedBy="account")
	private List<Buyer> buyers;

	//bi-directional many-to-one association to Seller
	@OneToMany(mappedBy="account")
	private List<Seller> sellers;

	public Account() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getPasswordhash() {
		return this.passwordhash;
	}

	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public Accounttype getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(Accounttype accounttype) {
		this.accounttype = accounttype;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public List<Buyer> getBuyers() {
		return this.buyers;
	}

	public void setBuyers(List<Buyer> buyers) {
		this.buyers = buyers;
	}

	public Buyer addBuyer(Buyer buyer) {
		getBuyers().add(buyer);
		buyer.setAccount(this);

		return buyer;
	}

	public Buyer removeBuyer(Buyer buyer) {
		getBuyers().remove(buyer);
		buyer.setAccount(null);

		return buyer;
	}

	public List<Seller> getSellers() {
		return this.sellers;
	}

	public void setSellers(List<Seller> sellers) {
		this.sellers = sellers;
	}

	public Seller addSeller(Seller seller) {
		getSellers().add(seller);
		seller.setAccount(this);

		return seller;
	}

	public Seller removeSeller(Seller seller) {
		getSellers().remove(seller);
		seller.setAccount(null);

		return seller;
	}

}