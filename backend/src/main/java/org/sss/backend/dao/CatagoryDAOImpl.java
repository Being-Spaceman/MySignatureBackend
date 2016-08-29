package org.sss.backend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.sss.backend.model.Catagory;
import org.sss.backend.dao.CatagoryDAO;





@SuppressWarnings("deprecation")
@Repository("CatagoryDAO")

public class CatagoryDAOImpl implements CatagoryDAO{

    @Autowired

         private SessionFactory sessionFactory;
         public CatagoryDAOImpl(SessionFactory sessionFactory)
{
	this.sessionFactory = sessionFactory;
}

 
         @Transactional
     	public List<Catagory> list() {
     		@SuppressWarnings("unchecked")
     		List<Catagory> listCatagory = (List<Catagory>) sessionFactory.getCurrentSession()
     				.createCriteria(Catagory.class)
     				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

     		return listCatagory;
}
         @Transactional
     	public void saveOrUpdate(Catagory Catagory) {
     		sessionFactory.getCurrentSession().saveOrUpdate(Catagory);
     	}

     	@Transactional
     	public void delete(String id) {
     		Catagory CatagoryToDelete = new Catagory();
     		CatagoryToDelete.setCID(id);
     		sessionFactory.getCurrentSession().delete(CatagoryToDelete);
     	}

     	@Transactional
     	public Catagory get(String id) {
     		String hql = "from Catagory where cid=" + id;
     		@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
     		
     		@SuppressWarnings("unchecked")
     		List<Catagory> listCatagory = (List<Catagory>) query.list();
     		
     		if (listCatagory != null && !listCatagory.isEmpty()) {
     			return listCatagory.get(0);
     		}
     		
     		return null;
     	}


     }
