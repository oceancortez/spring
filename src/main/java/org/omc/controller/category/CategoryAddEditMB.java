package org.omc.controller.category;

import org.omc.model.CategoryEntity;
import org.omc.model.model.utils.BaseBeans;
import org.omc.model.repositories.ICategoryRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ResourceBundle;

/**
 * Created by ocean on 9/27/2015.
 */
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "categoryAddEditMB")
public class CategoryAddEditMB extends BaseBeans {
    public static final long serialVersionUID = 1L;

    @Inject
    private FacesContext context;

    @Inject
    private ICategoryRepository categoryRepository;

    @Inject
    private CategoryMB mbCategoryBean;

    private CategoryEntity category;
    private String title;

    public CategoryAddEditMB() {
        this.category = new CategoryEntity();
    }

    public void add() {
        this.title = this.getResourcesProperty("labels", "category_add");
    }

    public void update() {
        this.title = this.getResourcesProperty("labels", "category_update");
        this.category = mbCategoryBean.getSelectCategory();
    }

    private String getResourcesProperty(String resource, String label) {
        Application application = this.context.getApplication();
        ResourceBundle bundle = application.getResourceBundle(this.context, resource);
        return bundle.getString(label);
    }

    public void save(){
        if(this.category != null){
            if(this.category.getId() == null){
                //SAVE
            this.categoryRepository.save(this.category);
            }else{
                //UPDATE
                this.categoryRepository.save(this.category);
            }
        }
    }

    public void cancel(){
        this.mbCategoryBean.unselectCategory();
    }


    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
