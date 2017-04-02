package org.oxiproject.server.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;
import org.oxiproject.server.database.repositories.ICategoryRepository;
import org.oxiproject.server.service.utils.AbstractGenericService;
import org.oxiproject.server.utils.entities.CategoryEntity;
import org.oxiproject.server.utils.service.interfaces.ICategoryService;
import org.springframework.data.jpa.repository.JpaRepository;

@Named
public class CategoryService extends AbstractGenericService<CategoryEntity, Long> implements ICategoryService {
	private Logger logger = Logger.getLogger(this.getClass());
		
	@Inject
	private ICategoryRepository categoryRepository;

	@Override
	protected JpaRepository<CategoryEntity, Long> getGenericRepository() {
		return this.categoryRepository;
	}

	@Override
	public CategoryEntity findOne(Long pk) {
		logger.info("@param = " + pk);
		CategoryEntity categoryEntity = this.categoryRepository.findOne(pk);
		if(categoryEntity != null){
		categoryEntity.setCategoryId(categoryEntity.getId());
		}
		logger.info("Retorno do método [CategoryService.findOne] = " + categoryEntity);
		return categoryEntity;
		
	}

	@Override
	public List<CategoryEntity> findByCategoryName(String categoryName) {
		return this.categoryRepository.findByCategoryName(categoryName);
	}

	@Override
	public int countByCategoryName(@PathParam("category_name") String categoryName) {
		return this.categoryRepository.findByCategoryName(categoryName).size();
	}

	@Override
	public CategoryEntity findByNameAndDescription(String name, String description) {
		logger.info("@param name = " + name + "@param description = " + description);
		CategoryEntity categoryEntity = 
				this.categoryRepository.findByCategoryNameAndDescription(name, description);
		logger.info("Retorno do método [CategoryService.findOne] = " + categoryEntity);
		return categoryEntity;
	}
	
	

}
