package org.oxiproject.server.utils.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.oxiproject.server.utils.BaseEntity;


//@NamedQuery(name = "ProductEntity.findAllProductsWithoutCategory", query = "SELECT p  FROM ProductEntity p WHERE p.CategoryID IS not null")
@Entity
@XmlRootElement
@Table(name="Products")
@AttributeOverride(name = "id", column = @Column(name = "ProductID"))
public class ProductEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = -7596122831728650013L;

	private String productName;

	private Long supplierId;

	private Long categoryId;

	private String quantityPerUnit;

	private BigDecimal unitPrice;

	private Short unitsInStock;

	private Short unitsOnOrder;

	private Short reorderLevel;

	private boolean discontinued;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "category_product", 
	joinColumns={@JoinColumn(name="ProductID", referencedColumnName="ProductID")},
	inverseJoinColumns={@JoinColumn(name="CategoryID", referencedColumnName="CategoryID")})
	private CategoryEntity categoryEntity;

	public ProductEntity() {
	}

	public ProductEntity(String productName, Long supplierId, Long categoryId,
			String quantityPerUnit, BigDecimal unitPrice, Short unitsInStock,
			Short unitsOnOrder, Short reorderLevel, boolean discontinued) {
		super();
		this.productName = productName;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getSupplierId() {
		return this.supplierId;
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getQuantityPerUnit() {
		return this.quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Short getUnitsInStock() {
		return this.unitsInStock;
	}

	public void setUnitsInStock(Short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Short getUnitsOnOrder() {
		return this.unitsOnOrder;
	}

	public void setUnitsOnOrder(Short unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public Short getReorderLevel() {
		return this.reorderLevel;
	}

	public void setReorderLevel(Short reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public boolean isDiscontinued() {
		return this.discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}
	
	

}
