package org.sss.backend.dao;

import java.util.List;

import org.sss.backend.model.Suplier;

public interface SuplierDAO {
	

	public List<Suplier> list();

	public Suplier get(String id);

	public void saveOrUpdate(Suplier Suplier);

	public void delete(String id);

}