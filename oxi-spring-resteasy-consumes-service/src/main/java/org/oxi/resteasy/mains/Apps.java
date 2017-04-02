//package org.oxi.resteasy.mains;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class Apps {
//
//	@SuppressWarnings("resource")
//	public static void main(String[] args) {
//		 ApplicationContext ctx = new AnnotationConfigApplicationContext(CorreiosServicesConfiguration.class);
//		 SearchCorreirosServices scs = ctx.getBean(SearchCorreirosServices.class);
//		 
//		 EnderecoCEP search = scs.search("03227040");
//		 System.out.println(search.toString());
//	}
//
//}
