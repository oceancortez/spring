//package org.wpattern.controller;
//
//import java.util.List;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//
//import org.apache.log4j.Logger;
//import org.wpattern.daos.CategoryDao;
//import org.wpattern.entities.CategoryEntity;
//
//
//@ManagedBean
//@SessionScoped
//public class CategoriaController {
//
//	private List<CategoryEntity> lstCategoryEntities;
//	private CategoryDao categoryDao;
//	private static final Logger LOOGER = Logger.getLogger(CategoriaController.class);
//
//	public CategoriaController() {
//		init();
//	}
//
//	private void init() {
//		listarCategoria();
//
//	}
//
//
//
//	public List<CategoryEntity> listarCategoria() {
//
//		try {
//			categoryDao = new CategoryDao();
//			lstCategoryEntities = categoryDao.findAll();
//			LOOGER.error("listarCategoria >  " + lstCategoryEntities);
//			if (lstCategoryEntities != null) {
//				return lstCategoryEntities;
//			}
//		}catch (Exception e){
//			LOOGER.error("listarCategoria >  " + lstCategoryEntities);
//		}
//		 return null;
//	}
//
//	public List<CategoryEntity> getLstCategoryEntities() {
//		return lstCategoryEntities;
//	}
//
//	public void setLstCategoryEntities(List<CategoryEntity> lstCategoryEntities) {
//		this.lstCategoryEntities = lstCategoryEntities;
//	}
//
//
//}
