package org.omc.controller.product;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotBlank;
import org.omc.constant.Outcome;
import org.omc.controller.category.SelectCategoryMB;
import org.omc.model.CategoryEntity;
import org.omc.model.ProductyEntity;
import org.omc.model.repositories.IProductyRepository;
import org.omc.model.utils.BaseBeans;
import org.omc.utils.FacesMensage;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by ocean on 9/27/2015.
 */
@Scope(WebApplicationContext.SCOPE_REQUEST)
@Named(value = "productAddEditMB")
public class ProductAddEditMB extends BaseBeans {
    public static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ProductAddEditMB.class);
    private String messages;


    @Inject
    private FacesContext context;

    @Inject
    private IProductyRepository productRepository;

    @Inject
    private ProductMB mbProductBean;

    @Inject
    private SelectCategoryMB selectCategoryMB;

    private Long categoryID;
    private Long categoryEntityId;
    private ProductyEntity product;
    private String title;
    private CategoryEntity categoryEntity;
    private boolean update;


    public ProductAddEditMB() {
        this.product = new ProductyEntity();
        this.categoryEntity = new CategoryEntity();
    }

    public void add() {
        FacesMensage.redirect(Outcome.PAGES_PRODUCT.getOutcome());
        this.title = this.getResourcesProperty("labels", "product_add");
    }

    public void update() {
        this.title = this.getResourcesProperty("labels", "product_update");
        this.product = mbProductBean.getSelectProduct();
        categoryID = product.getCategoryId();
    }

    private String getResourcesProperty(String resource, String label) {
        Application application = this.context.getApplication();
        ResourceBundle bundle = application.getResourceBundle(this.context, resource);
        return bundle.getString(label);
    }

    public void save(){
        if(this.product != null && validaForm()){
            try {
                if(this.product.getId() == null){
                    product.setCategoryId(this.selectCategoryMB.getCategoryId());
                    //SAVE
                    LOGGER.info("Init Save: " + product);
                    this.productRepository.save(this.product);
                    LOGGER.info("End save: " + product);
                    messages = "product '" + product.getProductName() + "' Add with Succsess!";
                    this.product = new ProductyEntity();
                    FacesMensage.redirect(Outcome.PAGES_PRODUCT.getOutcome());
                    mbProductBean.setMessages(messages);

                }else{

                    product.setCategoryId(this.selectCategoryMB.getCategoryId());
                    //UPDATE
                    this.productRepository.save(this.product);
                    messages = "product '" + product.getProductName() + "' Update with Succsess!";
                    mbProductBean.setMessages(messages);
                    FacesMensage.redirect(Outcome.PAGES_PRODUCT_LIST.getOutcome());
                    LOGGER.info("Init Update: " + product);
                }
            }catch (Exception e){
                LOGGER.error("Erro ao salvar: " + e.getMessage());
                FacesMensage.addMessageInfo(messages = "Erro ao salvar" + e.getMessage());
            }

        }

    }
    public void selectedCategory(SelectEvent event){
        categoryEntity = (CategoryEntity) event.getObject();
        categoryID = categoryEntity.getId();
        product.setCategoryId(categoryID);

    }

    public boolean validaForm(){

        if(this.product.getProductName().equals("") && this.product.getQuantityPerUnit().equals("")){
            this.messages = "Favor preencher o formulário";
            return false;
        }
        if(this.product.getProductName().equals("")){
            this.messages = "O campo Nome não pode ser nulo";
            return false;

        }if(this.product.getQuantityPerUnit().equals("")){
            this.messages = "O campo Per Unit não pode ser nulo";
            return false;
        }
        this.messages = "Add Category Sussefull";
        return true;
    }

    @NotBlank
    public String getCategoryId() {
        return product.getCategoryId() == null
                ? null : product.getCategoryId().toString();
    }

    public void setCategoryId(String categoryId) {
        categoryEntity.setId(this.product.getCategoryId());
    }



    public void cancel(){
        this.mbProductBean.unselectProduct();
    }


    public ProductyEntity getProduct() {
        return product;
    }

    public void setProduct(ProductyEntity product) {
        this.product = product;
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

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
        this.product.setCategoryId(categoryID);
    }

    public Long getCategoryEntityId() {
        return categoryEntityId;
    }

    public void setCategoryEntityId(Long categoryEntityId) {
        this.categoryEntityId = categoryEntityId;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }
}
