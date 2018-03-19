package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierUnitTest
{
static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
			AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
			context.scan("com.niit.*");
			context.refresh();
			
			supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		//category.setCategoryId(categoryId);
		supplier.setSupplierName("joy");
		supplier.setSupplierMob("8425025021");
		supplier.setSupplierId(1);
		assertTrue("Problem in Category Insertion",supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void getSupplierTest()
	{
		assertNotNull("Problem in get Supplier",supplierDAO.getSupplier(2));
	}
	
	@Ignore
	@Test
	public void deletCategoryTest()
	{
		Supplier supplier=supplierDAO.getSupplier(3);
		assertTrue("Problem in Deletion:",supplierDAO.deleteSupplier(supplier));
	}
	
	
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(4);
		supplier.setSupplierName("abcd");
		assertTrue("Problem in Updation",supplierDAO.updateSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Supplier> listSupplier=supplierDAO.listSupplier();
		assertNotNull("No Supplier",listSupplier);
		
		for(Supplier supplier:listSupplier)
		{
			System.out.print(supplier.getSupplierId()+":::");
			System.out.print(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierMob());
		}
	}
	
}



