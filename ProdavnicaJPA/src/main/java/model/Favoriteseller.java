package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the favoriteseller database table.
 * 
 */
@Entity
@NamedQuery(name="Favoriteseller.findAll", query="SELECT f FROM Favoriteseller f")
public class Favoriteseller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Buyer
	@ManyToOne
	private Buyer buyer;

	//bi-directional many-to-one association to Seller
	@ManyToOne
	private Seller seller;

	public Favoriteseller() {
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

	public Seller getSeller() {
		return this.seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

}