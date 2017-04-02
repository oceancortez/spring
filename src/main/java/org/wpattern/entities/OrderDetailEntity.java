package org.wpattern.entities;

import org.wpattern.keys.OrderDetailKey;
import org.wpattern.utils.BaseBean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by ocean on 23/08/2015.
 */
@Entity
@Table(name = "\"Order Details\"")
public class OrderDetailEntity extends BaseBean {

    private static final long serialVersionUID = 4145513888438234634L;

    @Id
    private OrderDetailKey id;

    private BigDecimal unitPrice;
    private Integer quantity;
    private Float discount;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(OrderDetailKey id, BigDecimal unitPrice, Integer quantity, Float discount) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
    }

    public OrderDetailKey getId() {
        return id;
    }

    public void setId(OrderDetailKey id) {
        this.id = id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
