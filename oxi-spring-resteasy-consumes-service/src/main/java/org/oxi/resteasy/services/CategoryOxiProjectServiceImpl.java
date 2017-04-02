package org.oxi.resteasy.services;

import org.apache.log4j.Logger;
import org.oxi.resteasy.domain.CategoryResponse;
import org.oxi.resteasy.resources.ICategoryOxiProjectResources;
import org.oxi.stok.domain.CategoryEntity;
import org.oxi.stok.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryOxiProjectServiceImpl implements ICategoryOxiProjectService {
	
	private static Logger logger = Logger.getLogger(CategoryOxiProjectServiceImpl.class);

	@Autowired
	private ICategoryOxiProjectResources categoryOxiProjectResources;
		
    @Autowired
	private ICategoryRepository iCategoryRepository;

	public CategoryEntity saveCategoryByResource(Long categoryId) {

		CategoryEntity categoryEntity = new CategoryEntity();
		logger.info("Entrou no método CategoryOxiProjectServiceImpl.saveService @PathParam = " + categoryId);
		try {
			if (categoryId != null) {
				CategoryResponse categoryResponse = categoryOxiProjectResources.searchCategoryById(categoryId);
				logger.info("Entrou no método CategoryOxiProjectServiceImpl.saveService @PathParam = " + categoryId);
				if(categoryResponse != null){
				CategoryEntity category = new CategoryEntity();	
				category = iCategoryRepository.findOne(categoryResponse.getCategoryEntity().getCategoryId());
				logger.info("Entrou no método CategoryOxiProjectServiceImpl.saveService @PathParam = " + categoryId);
				
				if (category == null) {
					categoryEntity = parseCategoryResponse(categoryResponse);
					 iCategoryRepository.saveAndFlush(categoryEntity);
					 logger.info("INSERT - Entrou no método CategoryOxiProjectServiceImpl.iCategoryRepository.saveAndFlush @categoryEntity = " + categoryEntity);
				}else{
					//TODO Arrumar este trecho
					if(category.getCategoryId() == categoryResponse.getCategoryEntity().getCategoryId()){
						iCategoryRepository.saveAndFlush(categoryEntity);	
						logger.info("UPDATE - Entrou no método CategoryOxiProjectServiceImpl.iCategoryRepository.saveAndFlush @PathParam = " + categoryEntity);
					}		
				}

				}
			}

		} catch (Exception e) {
			// TODO: e.pri
			e.printStackTrace();
		}

		return categoryEntity;
	}

	public CategoryEntity parseCategoryResponse(CategoryResponse categoryResponse) {
		CategoryEntity categoryEntity = new CategoryEntity();

		try {
			if (categoryResponse != null) {
				categoryEntity.setCategoryId(categoryResponse.getCategoryEntity().getCategoryId());
				categoryEntity.setCategoryName(categoryResponse.getCategoryEntity().getCategoryName());
				categoryEntity.setDescription(categoryResponse.getCategoryEntity().getDescription());
				categoryEntity.setPicture(categoryResponse.getCategoryEntity().getPicture());
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return categoryEntity;
	}


}
