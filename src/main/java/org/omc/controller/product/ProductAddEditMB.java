package org.omc.controller.product;

import org.apache.log4j.Logger;
import org.omc.model.ProductyEntity;
import org.omc.model.model.utils.BaseBeans;
import org.omc.model.repositories.IProductyRepository;
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
public class ProductAddEditMB extends BaseBeans {
    public static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ProductAddEditMB.class);


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

    public void save() throws JpaSystemException{
        if(this.product != null){
            try {
                if(this.product.getId() == null){
                    //SAVE
                    this.productRepository.save(this.product);
                    LOGGER.info("Init Save: " + product);

                }else{
                    //UPDATE
                    this.productRepository.save(this.product);
                }
            }catch (Exception e){
                LOGGER.error("Erro ao salvar: " + e.getMessage());
            }

        }
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
}
