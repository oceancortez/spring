package org.oxiproject.server.utils.entities;

import java.util.List;

import javax.naming.Referenceable;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.SQLInsert;
import org.oxiproject.server.utils.BaseEntity;

@Entity
@XmlRootElement
@Table(name = "Categories")
@AttributeOverride(name = "id", column = @Column(name = "CategoryID"))
public class CategoryEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = -16240817663243274L;
	
	@Column(insertable = false, updatable = false)
	private Long categoryId;
	
	@Column(name = "CategoryName")
	private String categoryName;

	@Column(name = "Description")
	private String description;

	@Column(name = "Picture")
	private Byte[] picture;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "category_product", 
	joinColumns={@JoinColumn(name="CategoryID", referencedColumnName="CategoryID")},
	inverseJoinColumns={@JoinColumn(name="ProductID", referencedColumnName="ProductID")})
	@JsonIgnore
	private List<ProductEntity> productEntities;

	public CategoryEntity() {
	}

	public CategoryEntity(Long categoryId, String categoryName, String description, Byte[] picture) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(Byte[] picture) {
		this.picture = picture;
	}

	public List<ProductEntity> getProductEntities() {
		return productEntities;
	}

	public void setProductEntities(List<ProductEntity> productEntities) {
		this.productEntities = productEntities;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	

}
