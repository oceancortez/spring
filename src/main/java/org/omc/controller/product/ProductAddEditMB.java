package org.omc.controller.product;

import org.apache.log4j.Logger;
import org.omc.model.ProductyEntity;
import org.omc.model.repositories.IProductyRepository;
import org.omc.utils.controller.BaseController;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.jpa.JpaSystemException;
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
@Named(value = "productAddEditMB")
public class ProductAddEditMB extends BaseController {
    public static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ProductAddEditMB.class);
    private String messages;


    @Inject
    private FacesContext context;

    @Inject
    private IProductyRepository productRepository;

    @Inject
    private ProductMB mbProductBean;

    private ProductyEntity product;
    private String title;

    public ProductAddEditMB() {
        this.product = new ProductyEntity();
    }

    public void add() {
        this.title = this.getResourcesProperty("labels", "product_add");
    }

    public void update() {
        this.title = this.getResourcesProperty("labels", "product_update");
        this.product = mbProductBean.getSelectProduct();
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
                    //SAVE
                    this.productRepository.save(this.product);
                    messages = "product '" + product.getProductName() + "' Add with Succsess!";
                    mbProductBean.setMessages(messages);
                    redirect("/pages/product/list.xhtml");
                    LOGGER.info("Init Save: " + product);

                }else{
                    //UPDATE
                    this.productRepository.save(this.product);
                    messages = "product '" + product.getProductName() + "' Update with Succsess!";
                    mbProductBean.setMessages(messages);
                    redirect("/pages/product/list.xhtml");
                    LOGGER.info("Init Update: " + product);
                }
            }catch (Exception e){
                LOGGER.error("Erro ao salvar: " + e.getMessage());
            }

        }
        addMessage(messages);
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
}
