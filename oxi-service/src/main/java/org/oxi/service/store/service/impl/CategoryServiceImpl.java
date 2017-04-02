package org.oxi.service.store.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.oxi.persistence.database.store.repositories.ICategoryRepository;
import org.oxi.service.api.store.interfaces.ICategoryService;
import org.oxi.utils.entities.sale.CategoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//Faltava essa anotação para o spring enxergar o serviço
@Named
public class CategoryServiceImpl implements ICategoryService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Inject
	private ICategoryRepository categoryRepository;
	
//	@Autowired
//	private ISaleCategoryResources iSaleResources;
	

	@Override
	public CategoryEntity findOne(Long pk) {
			try {
				LOGGER.info("Entrou no método [findOne]");
				if(pk != null){
					LOGGER.info("Entrou no método [findOne]" + pk);
				return this.categoryRepository.findOne(pk);
				}
			} catch (Exception e) {
				LOGGER.error("Método [findOne] - Erro ao retornar registros de category do banco. Erro=[{}]", e);		
			}	
			LOGGER.info("Retornou NULL no método [findOne]");
		return null;
	}

	@Override
	public List<CategoryEntity> listCategorieResource() {
		// TODO Auto-generated method stub
		LOGGER.info("Entrou no método [listCategorieResource]");
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
	
	

}
