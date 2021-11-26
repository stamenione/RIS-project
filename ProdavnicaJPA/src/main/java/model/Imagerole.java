package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the imagerole database table.
 * 
 */
@Entity
@NamedQuery(name="Imagerole.findAll", query="SELECT i FROM Imagerole i")
public class Imagerole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String imageRoleName;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="imagerole")
	private List<Image> images;

	public Imagerole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageRoleName() {
		return this.imageRoleName;
	}

	public void setImageRoleName(String imageRoleName) {
		this.imageRoleName = imageRoleName;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setImagerole(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setImagerole(null);

		return image;
	}

}