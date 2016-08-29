package org.sss.backend;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.sss.backend.dao.ProductDAO;
import org.sss.backend.model.Product;

import junit.framework.TestCase;

public class ProductTest extends TestCase {
	
public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopingcart");
		context.refresh();
		
	Product c =(Product)	  context.getBean("Product");
	
	ProductDAO ProductDAO = (ProductDAO)  context.getBean("ProductDao");
	
	
	c.setPID("LTRNAVNEET001");
	c.setPNAME("MyFunbook");
	c.setPQUANTITY(20);
	c.setPPRICE(30000);
	
	
	
	ProductDAO.saveOrUpdate(c);
	
	
	
	
	List<Product>  list =    ProductDAO.list();
	
	for(Product Product : list)
	{
		System.out.println(Product.getPID()  + ":" +  Product.getPNAME()  + ":"+  Product.getPPRICE()+  Product.getPPRICE());
	}
		
		
	}


}

