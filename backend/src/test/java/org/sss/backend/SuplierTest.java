package org.sss.backend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.sss.backend.dao.ProductDAO;
import org.sss.backend.dao.SuplierDAO;
import org.sss.backend.model.Product;
import org.sss.backend.model.Suplier;

import junit.framework.TestCase;

@Repository("SuplierDAO")

public class SuplierTest extends TestCase {
public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopingcart");
		context.refresh();
		
		Suplier s=(Suplier) context.getBean(Suplier);
		SuplierDAO SuplierDAO = (SuplierDAO)  context.getBean("SuplierDAO");
				
 s.setSID(89);
 s.setSNAME("Poptlal");
 s.setSADRESS("Shyam nagar,latur");

 SuplierDAO.saveOrUpdate(s);
	
	
	
	
	List<Suplier>  list =    SuplierDAO.list();
	
	
	for(Suplier Suplier : list)
	{
		System.out.println(Suplier.getSID() + ":" + Suplier.getSNAME() + ":" + Suplier.getSADRESS());
	}
		
		
	

} 
}
