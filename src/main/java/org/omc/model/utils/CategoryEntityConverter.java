package org.omc.model.utils;

import org.omc.model.CategoryEntity;
import org.omc.model.repositories.ICategoryRepository;
import org.springframework.stereotype.Service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 * Created by ocean on 10/18/2015.
 */

@FacesConverter(value = "categoryEntityConverter")
@Service
public class CategoryEntityConverter implements Converter {

    @Inject
    ICategoryRepository categoryRepository;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        CategoryEntity categoryEntity = new CategoryEntity();
        if (value != null) {
            Long id = new Long(value);
            categoryEntity = this.categoryRepository.findById(id);
            System.out.println("imprimindo > " + categoryEntity);
        }

        return categoryEntity;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value != null && value instanceof CategoryEntity) {
            CategoryEntity categoryEntity = (CategoryEntity) value;
            return categoryEntity.getId().toString();
        }
        return "";
    }
}
