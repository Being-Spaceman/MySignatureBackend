package org.sss.backend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.sss.backend.dao.CatagoryDAO;
import org.sss.backend.model.Catagory;

import junit.framework.TestCase;

public class JavaTestCatagory extends TestCase {
	
public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopingcart");
		context.refresh();
		
	Catagory c =(Catagory)	  context.getBean("Catagory");
	
	CatagoryDAO CatagoryDAO = (CatagoryDAO)  context.getBean("CatagoryDao");
	
	
	c.setCID("LTR001");
	c.setCNAME("NOTEBOOK");
	c.setCTYPE("A4Funbook");
	
	
	CatagoryDAO.saveOrUpdate(c);
	
	
	
	
	List<Catagory>  list =    CatagoryDAO.list();
	
	for(Catagory catagory : list)
	{
		System.out.println(catagory.getCID()  + ":" +  catagory.getCNAME()  + ":"+  catagory.getCTYPE());
	}
		
		
	}


}
