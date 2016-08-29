package org.sss.backend.dao;

import java.util.List;

import org.sss.backend.model.Catagory;




public interface CatagoryDAO {
	

	public List<Catagory> list();

	public Catagory get(String id);

	public void saveOrUpdate(Catagory category);

	public void delete(String id);

}
