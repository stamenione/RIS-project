package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String imagefrontlocation;

	private String name;

	private String title;

	private String url;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="image")
	private List<Account> accounts;

	//bi-directional many-to-one association to Imagerole
	@ManyToOne
	private Imagerole imagerole;

	//bi-directional many-to-one association to Subcategory
	@OneToMany(mappedBy="image")
	private List<Subcategory> subcategories;

	//bi-directional many-to-one association to Subcategoryitem
	@OneToMany(mappedBy="image")
	private List<Subcategoryitem> subcategoryitems;

	public Image() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagefrontlocation() {
		return this.imagefrontlocation;
	}

	public void setImagefrontlocation(String imagefrontlocation) {
		this.imagefrontlocation = imagefrontlocation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setImage(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setImage(null);

		return account;
	}

	public Imagerole getImagerole() {
		return this.imagerole;
	}

	public void setImagerole(Imagerole imagerole) {
		this.imagerole = imagerole;
	}

	public List<Subcategory> getSubcategories() {
		return this.subcategories;
	}

	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	public Subcategory addSubcategory(Subcategory subcategory) {
		getSubcategories().add(subcategory);
		subcategory.setImage(this);

		return subcategory;
	}

	public Subcategory removeSubcategory(Subcategory subcategory) {
		getSubcategories().remove(subcategory);
		subcategory.setImage(null);

		return subcategory;
	}

	public List<Subcategoryitem> getSubcategoryitems() {
		return this.subcategoryitems;
	}

	public void setSubcategoryitems(List<Subcategoryitem> subcategoryitems) {
		this.subcategoryitems = subcategoryitems;
	}

	public Subcategoryitem addSubcategoryitem(Subcategoryitem subcategoryitem) {
		getSubcategoryitems().add(subcategoryitem);
		subcategoryitem.setImage(this);

		return subcategoryitem;
	}

	public Subcategoryitem removeSubcategoryitem(Subcategoryitem subcategoryitem) {
		getSubcategoryitems().remove(subcategoryitem);
		subcategoryitem.setImage(null);

		return subcategoryitem;
	}

}