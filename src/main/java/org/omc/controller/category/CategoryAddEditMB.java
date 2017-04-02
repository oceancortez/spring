package org.omc.controller.category;

import org.omc.model.CategoryEntity;
import org.omc.model.repositories.ICategoryRepository;
import org.omc.utils.controller.BaseController;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ResourceBundle;

/**
 * Created by ocean on 9/27/2015.
 */
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "categoryAddEditMB")
public class CategoryAddEditMB extends BaseController {
    public static final long serialVersionUID = 1L;

    @Inject
    private FacesContext context;

    @Inject
    private ICategoryRepository categoryRepository;

    @Inject
    private CategoryMB mbCategoryBean;

    private CategoryEntity category;
    private String title;
    private String messages;
    private FacesMessage message;

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
        if(this.category != null && validaForm()){
            if(this.category.getId() == null){
                //SAVE
            this.categoryRepository.save(this.category);
                messages = "Category '" + category.getCategoryName() + "' Add with Succsess!";
                mbCategoryBean.setMessages(messages);
                redirect("/pages/category/list.xhtml");
            }else{
                //UPDATE
                this.categoryRepository.save(this.category);
                messages = "Category '" + category.getCategoryName() + "' Update with Succsess!";
                mbCategoryBean.setMessages(messages);
                redirect("/pages/category/list.xhtml");
            }
        }
         addMessage(messages);
    }

    public boolean validaForm(){

        if(this.category.getCategoryName().equals("") && this.category.getDescription().equals("")){
            this.messages = "Favor preencher o formulário";
            return false;
        }
        if(this.category.getCategoryName().equals("")){
            this.messages = "O campo Nome não pode ser nulo";
            return false;

        }if(this.category.getDescription().equals("")){
            this.messages = "O campo Description não pode ser nulo";
            return false;
        }
        this.messages = "Add Category Sussefull";
        return true;
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

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
