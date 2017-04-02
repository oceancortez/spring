//package org.wpattern.daos;
//
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import org.wpattern.entities.CategoryEntity;
//import org.wpattern.utils.GenericDao;
//
//import java.util.List;
//
///**
// * Created by ocean on 22/08/2015.
// */
//@Repository
//public class CategoryDao extends GenericDao<CategoryEntity, Long> {
//
//    @SuppressWarnings("unchecked")
//    public List<CategoryEntity> findByCategoryName(String categoryName){
//
//        List<CategoryEntity> categories = (List<CategoryEntity>)
//                this.executeQuery("SELECT c FROM CategoryEntity c WHERE c.categoryName = ?0", categoryName);
//
//        return categories;
//
//    }
//
//
//}
