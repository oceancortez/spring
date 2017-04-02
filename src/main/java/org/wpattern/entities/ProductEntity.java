package org.wpattern.entities;


import org.wpattern.utils.BaseBean;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="Products")
public class ProductEntity extends BaseBean {

	private static final long serialVersionUID = -7596122831728650013L;

	@Id
	@GeneratedValue
	@Column(name = "productID")
	private Long id;

	private String productName;

	private Long supplierId;

	private String quantityPerUnit;

	private BigDecimal unitPrice;

	private Short unitsInStock;

	private Short unitsOnOrder;

	private Short reorderLevel;

	private boolean discontinued;

	private Long categoryId;

	public ProductEntity() {
	}

	public ProductEntity(String productName, Long supplierId, String quantityPerUnit,
						 BigDecimal unitPrice, Short unitsInStock, Short unitsOnOrder,
						 Short reorderLevel, boolean discontinued, Long categoryId) {
		this.productName = productName;
		this.supplierId = supplierId;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
		this.categoryId = categoryId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
