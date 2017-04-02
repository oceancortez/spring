package org.oxi.resteasy.domain;

import org.oxi.stok.domain.CategoryEntity;

public class CategoryResponse {
	
	private CategoryEntity categoryEntity;
	
	public CategoryResponse(){
		
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	@Override
	public String toString() {
		return "CategoryResponse [categoryEntity=" + categoryEntity + "]";
	}

	public CategoryResponse(CategoryEntity categoryEntity) {
		super();
		this.categoryEntity = categoryEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryEntity == null) ? 0 : categoryEntity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryResponse other = (CategoryResponse) obj;
		if (categoryEntity == null) {
			if (other.categoryEntity != null)
				return false;
		} else if (!categoryEntity.equals(other.categoryEntity))
			return false;
		return true;
	}
	
	
	
	
	
	

}
