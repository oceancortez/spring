package org.oxi.service.store.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.oxi.integrations.sale.resources.ISaleCategoryResources;
import org.oxi.persistence.database.store.repositories.ICategoryRepository;
import org.oxi.service.api.store.interfaces.ICategoryServiceRest;
import org.oxi.service.store.service.utils.AbstractGenericServiceRest;
import org.oxi.utils.entities.sale.CategoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//Faltava essa anotação para o spring enxergar o serviço
@Named
public class CategoryServiceRestImpl extends AbstractGenericServiceRest<CategoryEntity, Long> implements ICategoryServiceRest {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CategoryServiceRestImpl.class);
	
	@Inject
	private ICategoryRepository categoryRepository;
	
//	@Inject
//	private ISaleCategoryResources iSaleResources;
	

	@Override
	protected JpaRepository<CategoryEntity, Long> getGenericRepository() {		
		return this.categoryRepository;
	}
	
	@Override
	public CategoryEntity findOne(Long pk) {
		CategoryEntity categoryEntity = new CategoryEntity();
			try {
				LOGGER.info("Entrou no método [findOne]");
				if(pk != null){
					LOGGER.info("Entrou no método [findOne] @param = " + pk);
					categoryEntity = this.categoryRepository.findOne(pk);
					LOGGER.info("Entrou no método [findOne] @param after =" + categoryEntity);
				}
				
			} catch (Exception e) {
				LOGGER.error("Método [findOne] - Erro ao retornar registros de category do banco. Erro=[{}]", e);		
			}			
		return categoryEntity;
	}

	@Override
	public List<CategoryEntity> listCategorieResource() {
		LOGGER.info("Entrou no método [listCategorieResource]");
		// TODO Auto-generated method stub
		try {
//			List<CategoryEntity> listCategories = iSaleResources.listCategories();
//			
//			if(listCategories != null){
//				LOGGER.info("Return no método [listCategorieResource]" + listCategories.size());
//				return listCategories;					
//			}
			
		} catch (Exception e) {
			LOGGER.error("Erro ao retornar registros de category do resources. Erro=[{}]", e);		
			
		}		
		LOGGER.info("Return NULL do método [listCategorieResource]");
		return null;
	}

//	@Override
//	public CategoryEntity saveOneCategoryInRepositoryFromResources(Long pk) {
//		// TODO Auto-generated method stub
//		LOGGER.info("Entrou no método [saveOneInRepository] =[id] " + pk);
//		try {
//		CategoryEntity categoryEntity = null;//iSaleResources.findCategoryResourceForId(pk);
//		if(categoryEntity != null){
//			categoryRepository.saveAndFlush(categoryEntity);
//		}
//		}catch(Exception e){
//			LOGGER.error("Erro no método [saveOneInRepository ] ao salvar category in repository. Erro=[{}]", e, "id = ", pk);
//		}
//		LOGGER.info("Return NULL do método [saveOneInRepository]");
//		return null;
//	}
	
	
	
	

	
	
	
	

}
