package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subcategory database table.
 * 
 */
@Entity
@NamedQuery(name="Subcategory.findAll", query="SELECT s FROM Subcategory s")
public class Subcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private Category category;

	//bi-directional many-to-one association to Image
	@ManyToOne
	private Image image;

	//bi-directional many-to-one association to Subcategoryitem
	@OneToMany(mappedBy="subcategory")
	private List<Subcategoryitem> subcategoryitems;

	public Subcategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public List<Subcategoryitem> getSubcategoryitems() {
		return this.subcategoryitems;
	}

	public void setSubcategoryitems(List<Subcategoryitem> subcategoryitems) {
		this.subcategoryitems = subcategoryitems;
	}

	public Subcategoryitem addSubcategoryitem(Subcategoryitem subcategoryitem) {
		getSubcategoryitems().add(subcategoryitem);
		subcategoryitem.setSubcategory(this);

		return subcategoryitem;
	}

	public Subcategoryitem removeSubcategoryitem(Subcategoryitem subcategoryitem) {
		getSubcategoryitems().remove(subcategoryitem);
		subcategoryitem.setSubcategory(null);

		return subcategoryitem;
	}

}