package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Supplier")
public class Supplier
{
	@Id
	@GeneratedValue
	private int supplierId;
	private String supplierName;
	private String supplierMob;
	
	public int getSupplierId() 
	{
		return supplierId;
	}
	public void setSupplierId(int supplierId) 
	{
		this.supplierId = supplierId;
	}
	public String getSupplierName()
	{
		return supplierName;
	}
	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}
	public String getSupplierMob()
	{
		return supplierMob;
	}
	public void setSupplierMob(String supplierMob)
	{
		this.supplierMob = supplierMob;
	}
	
	
}
