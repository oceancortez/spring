package org.oxi.springmvc.controller.category;

import java.io.Serializable;
import java.util.Arrays;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;
import org.oxi.stok.utils.BaseEntities;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryForm extends BaseEntities<Long> implements Serializable {

    private static final long serialVersionUID = -16240817663243274L;

    @FormParam("categoryId")
    private Long categoryId;

    @NotNull(message = "Campo Obrigatório")
    @NotEmpty(message = "Campo Obrigatório")
    @FormParam("categoryName")
    private String categoryName;

    @FormParam("description")
    private String description;

    @FormParam("picture")
    private byte[] picture;

    @FormParam("message")
    private String message;

    @FormParam("pictureName")
    private String pictureName;
    
    @FormParam("pictureNew")
    private byte[] pictureNew;
    
    @FormParam("actionSave")
    private Boolean actionSave;

    public CategoryForm() {
    }

    public CategoryForm(Long categoryId, String categoryName, String description, byte[] picture, String message, String pictureName, byte[] pictureNew, Boolean actionSave) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.picture = picture;
        this.message = message;
        this.pictureName = pictureName;
        this.pictureNew = pictureNew;
        this.actionSave = actionSave;
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

    @Override
    public String toString() {
        return "CategoryForm [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description + ", picture="
                + Arrays.toString(picture) + ", message=" + message + ", pictureName=" + pictureName + ", pictureNew=" + pictureNew + ", actionSave=" + actionSave+ "]";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

	public byte[] getPictureNew() {
		return pictureNew;
	}

	public void setPictureNew(byte[] pictureNew) {
		this.pictureNew = pictureNew;
	}

	public Boolean getActionSave() {
		return actionSave;
	}

	public void setActionSave(Boolean actionSave) {
		this.actionSave = actionSave;
	}
	
	
    
    

}
