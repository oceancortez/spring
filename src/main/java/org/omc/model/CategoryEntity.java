package org.omc.model;

import org.omc.model.utils.BaseEntities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
@AttributeOverride(name = "id", column = @Column(name = "CategoryId"))
public class CategoryEntity  extends BaseEntities<Long>{
    private static final long serialVersionUID = 201404120102L;


    private String categoryName;
    private String description;
    private Byte[] picture;

    public CategoryEntity() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public CategoryEntity(Long id,String categoryName, String description, Byte[] picture) {
        super();
        this.setId(id);
        this.categoryName = categoryName;
        this.description = description;
        this.picture = picture;
    }

    public CategoryEntity(String categoryName, String description, Byte[] picture) {
        super();

        this.categoryName = categoryName;
        this.description = description;
        this.picture = picture;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
    }




}
