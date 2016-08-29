package org.sss.backend.dao;

import java.util.List;

import org.sss.backend.model.Product;

public interface ProductDAO {
	

	public List<Product> list();

	public Product get(String id);

	public void saveOrUpdate(Product Product);

	public void delete(String id);

}
