package org.omc.controller.category;

import org.apache.log4j.Logger;
import org.omc.model.CategoryEntity;
import org.omc.model.model.utils.BaseBeans;
import org.omc.model.repositories.ICategoryRepository;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "categoryMB")
public class CategoryMB extends BaseBeans {

    public static final long serialVersionUID = 201404221641L;
    private static final Logger LOGGER = Logger.getLogger(CategoryMB.class);

    @Inject
    private ICategoryRepository categoryRepository;

    private List<CategoryEntity> categories;
    private CategoryEntity selectCategory;
    private Long id;


    public CategoryMB() {

    }

    public void onLoad() {
        this.categories = this.categoryRepository.findAll();
        LOGGER.error(categories);
    }

    public void delete(){
        if(this.selectCategory != null){
            this.categoryRepository.delete(this.selectCategory.getId());
        }
    }


    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    public void unselectCategory() {
        this.selectCategory = null;

    }

    public void selectCategory(SelectEvent evt){
    try {
        if(evt.getObject() != null){
            this.selectCategory = (CategoryEntity) evt.getObject();
        }else{
            this.selectCategory = null;
        }
    }catch (Exception e){
        this.selectCategory = null;
        LOGGER.error("Erro ao selecionar categoria: " + e.getMessage(), e);
    }
    }

    public CategoryEntity getSelectCategory() {
        return selectCategory;
    }

    public void setSelectCategory(CategoryEntity selectCategory) {
        this.selectCategory = selectCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
