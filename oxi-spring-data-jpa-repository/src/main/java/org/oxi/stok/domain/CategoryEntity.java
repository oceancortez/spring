package org.oxi.stok.domain;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.oxi.stok.utils.BaseEntities;

@Entity
@XmlRootElement
@Table(name = "Categories")
@AttributeOverride(name = "id", column = @Column(name = "CategoryId"))
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryEntity extends BaseEntities<Long> implements Serializable {

    private static final long serialVersionUID = -16240817663243274L;

    @Column(name = "CategoryID", insertable = false, updatable = false)
    @FormParam("categoryId")
    private Long categoryId;

    @FormParam("categoryName")
    private String categoryName;

    @FormParam("description")
    private String description;

    @FormParam("picture")
    private byte[] picture = new byte[0];

    @FormParam("pictureName")
    private String pictureName;

    public CategoryEntity() {
    }

    public CategoryEntity(Long categoryId, String categoryName, String description, byte[] picture, String pictureName) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.picture = picture;
        this.pictureName = pictureName;
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

    public byte[] getPicture() {
        return this.picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    @Override
    public String toString() {
        return "CategoryEntity [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description + ", picture="
                + Arrays.toString(picture) + ", pictureName=" + pictureName + "]";
    }

}
