package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seller database table.
 * 
 */
@Entity
@NamedQuery(name="Seller.findAll", query="SELECT s FROM Seller s")
public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String googlemapinfo;

	private String name;

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="seller")
	private List<Category> categories;

	//bi-directional many-to-one association to Favoriteseller
	@OneToMany(mappedBy="seller")
	private List<Favoriteseller> favoritesellers;

	//bi-directional many-to-one association to Account
	@ManyToOne
	private Account account;

	public Seller() {
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

	public String getGooglemapinfo() {
		return this.googlemapinfo;
	}

	public void setGooglemapinfo(String googlemapinfo) {
		this.googlemapinfo = googlemapinfo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setSeller(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setSeller(null);

		return category;
	}

	public List<Favoriteseller> getFavoritesellers() {
		return this.favoritesellers;
	}

	public void setFavoritesellers(List<Favoriteseller> favoritesellers) {
		this.favoritesellers = favoritesellers;
	}

	public Favoriteseller addFavoriteseller(Favoriteseller favoriteseller) {
		getFavoritesellers().add(favoriteseller);
		favoriteseller.setSeller(this);

		return favoriteseller;
	}

	public Favoriteseller removeFavoriteseller(Favoriteseller favoriteseller) {
		getFavoritesellers().remove(favoriteseller);
		favoriteseller.setSeller(null);

		return favoriteseller;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}