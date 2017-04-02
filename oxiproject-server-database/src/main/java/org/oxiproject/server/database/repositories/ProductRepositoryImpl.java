package org.oxiproject.server.database.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.oxiproject.server.utils.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;



//@Repository
public class ProductRepositoryImpl {//implements IProductRepository{

	 @PersistenceContext
	 private EntityManager em;
	 
	@Autowired 
    private IProductRepository iProductRepository;  

//	@Override
//	public List<ProductEntity> findAllProductsWithoutCategory() {
//		// TODO Auto-generated method stub
//		TypedQuery<ProductEntity> query  = em.createQuery("SELECT p  FROM ProductEntity p WHERE p.CategoryID IS not null", ProductEntity.class);
//		
//		return query.getResultList();
//	}

//	@Override
//	public List<ProductEntity> findAll() {
//		// TODO Auto-generated method stub
//		return iProductRepository.findAll();
//	}
//
//	@Override
//	public List<ProductEntity> findAll(Sort sort) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<ProductEntity> findAll(Iterable<Long> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends ProductEntity> List<S> save(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void flush() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public ProductEntity saveAndFlush(ProductEntity entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteInBatch(Iterable<ProductEntity> entities) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAllInBatch() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public ProductEntity getOne(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Page<ProductEntity> findAll(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends ProductEntity> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ProductEntity findOne(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean exists(Long id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void delete(Long id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(ProductEntity entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(Iterable<? extends ProductEntity> entities) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		
//	}

}
