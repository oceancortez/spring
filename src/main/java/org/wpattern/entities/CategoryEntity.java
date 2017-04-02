package org.wpattern.entities;

import org.wpattern.utils.BaseBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * Created by ocean on 22/08/2015.
 */
@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseBean {

    private static final long serialVersionUID = 1245451231632L;

    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "CategoryId")
    private Long id;
    private String categoryName;
    private String descritptions;
    private Byte[] picture;



    public CategoryEntity(Long id, String categoryName, String descritptions, Byte[] picture) {
        this.id = id;
        this.categoryName = categoryName;
        this.descritptions = descritptions;
        this.picture = picture;
    }


    public CategoryEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescritptions() {
        return descritptions;
    }

    public void setDescritptions(String descritptions) {
        this.descritptions = descritptions;
    }

    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
    }
}
