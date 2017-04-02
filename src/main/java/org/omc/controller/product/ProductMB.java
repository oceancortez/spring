package org.omc.controller.product;

import org.apache.log4j.Logger;
import org.omc.model.ProductyEntity;
import org.omc.model.repositories.IProductyRepository;
import org.omc.model.utils.BaseBeans;
import org.omc.utils.FacesMensage;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "productMB")
public class ProductMB extends BaseBeans {

    public static final long serialVersionUID = 201404221641L;
    private static final Logger LOGGER = Logger.getLogger(ProductMB.class);

    @Inject
    private IProductyRepository productyRepository;

    private List<ProductyEntity> products;
    private ProductyEntity selectProduct;
    private Long id;
    protected String messages;


    public ProductMB() {

    }

    public void onLoad() {
        this.products = this.productyRepository.findAll();
       // LOGGER.error(products);
        if (messages != null){
            FacesMensage.addMessageInfo(messages);
            messages = null;
        }
    }

    public void delete(){
        //TODO Implementar a pergunta antes de excluir o registro
        if(this.selectProduct != null){
            this.productyRepository.delete(this.selectProduct.getId());
            messages = "Product '" + selectProduct.getProductName() + "' excluded with Succsess!";
        }
    }


    public List<ProductyEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductyEntity> products) {
        this.products = products;
    }

    public void unselectProduct() {
        this.selectProduct = null;

    }

    public void selectProduct(SelectEvent evt){
    try {
        if(evt.getObject() != null){
            this.selectProduct = (ProductyEntity) evt.getObject();
        }else{
            this.selectProduct = null;
        }
    }catch (Exception e){
        this.selectProduct = null;
        LOGGER.error("Erro ao selecionar Product: " + e.getMessage(), e);
    }
    }

    public ProductyEntity getSelectProduct() {
        return selectProduct;
    }

    public void setSelectProduct(ProductyEntity selectProduct) {
        this.selectProduct = selectProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
