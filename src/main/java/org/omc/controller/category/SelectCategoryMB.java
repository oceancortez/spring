package org.omc.controller.category;

import org.apache.log4j.Logger;
import org.omc.constant.Outcome;
import org.omc.controller.product.ProductAddEditMB;
import org.omc.model.CategoryEntity;
import org.omc.model.repositories.ICategoryRepository;
import org.omc.model.utils.BaseBeans;
import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Scope(WebApplicationContext.SCOPE_SESSION)
@Named(value = "selectCategoryMB")
public class SelectCategoryMB extends BaseBeans {

    public static final long serialVersionUID = 201404221641L;
    private static final Logger LOGGER = Logger.getLogger(SelectCategoryMB.class);

    @Inject
    private ICategoryRepository categoryRepository;

    private List<CategoryEntity> categoriesFilters;

    private Long id;
    private Long categoryId;
    private String categoryName;
    private CategoryEntity categoryEntity;

     public void pesquisar(){
            this.categoriesFilters =  this.categoryRepository.findByCategoryNameContaining(categoryName);
    }

    public void openDialog(){

        this.categoriesFilters = new ArrayList<>();
        Map<String, Object> opcoes = new HashMap<>();
        opcoes.put("closable", false);
        opcoes.put("modal", true);
        opcoes.put("resizable", true);
        opcoes.put("contentHeight", 600);
        opcoes.put("width", 700);
        RequestContext.getCurrentInstance().openDialog(Outcome.PAGES_CATEGORY_SELECT_CATEGORY.getOutcome(), opcoes, null);
    }

    public void selecionar(CategoryEntity category){
        LOGGER.error("init selecionar >> " + category);
        categoryId = category.getId();
        RequestContext.getCurrentInstance().closeDialog(category);
        LOGGER.error("end selecionar >> " + category);
    }


    public List<CategoryEntity> getCategoriesFilters() {
        return categoriesFilters;
    }

    public void setCategoriesFilters(List<CategoryEntity> categoriesFilters) {
        this.categoriesFilters = categoriesFilters;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}
