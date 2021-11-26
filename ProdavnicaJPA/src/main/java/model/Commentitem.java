package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the commentitem database table.
 * 
 */
@Entity
@NamedQuery(name="Commentitem.findAll", query="SELECT c FROM Commentitem c")
public class Commentitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date commentdate;

	private String value;

	//bi-directional many-to-one association to Buyer
	@ManyToOne
	private Buyer buyer;

	//bi-directional many-to-one association to Subcategoryitem
	@ManyToOne
	private Subcategoryitem subcategoryitem;

	public Commentitem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCommentdate() {
		return this.commentdate;
	}

	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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