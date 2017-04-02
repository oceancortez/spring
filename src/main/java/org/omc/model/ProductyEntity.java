package org.omc.model;

import org.omc.constant.ProductStatusType;
import org.omc.model.utils.BaseEntities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "Products")
@AttributeOverride(name = "id", column = @Column(name= "ProductId"))
public class ProductyEntity extends BaseEntities<Long> {

    private static final long serialVersionUID = 201404120102L;

    private String productName;

    private String quantityPerUnit;

    private BigDecimal unitPrice;

    private Short unitsInStock;

    private Short unitsOnOrder;

    private Short reorderLevel;

    private boolean discontinued;

    private Long categoryId;

    @Transient
    private String statusProduto;


    public ProductyEntity() {
    }

    public ProductyEntity(String productName, String quantityPerUnit, BigDecimal unitPrice, Short unitsInStock, Short unitsOnOrder, Short reorderLevel, boolean discontinued, Long categoryId) {
        this.productName = productName;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Short getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Short unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Short getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Short unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public Short getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Short reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        if(!discontinued){
        this.statusProduto = ProductStatusType.A.getValue();
        }else {
            this.statusProduto = ProductStatusType.I.getValue();
        }
    }

    public String getStatusProduto() {
        setDiscontinued(discontinued);
        return statusProduto;
    }

    public void setStatusProduto(String statusProduto) {
        this.statusProduto = statusProduto;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
