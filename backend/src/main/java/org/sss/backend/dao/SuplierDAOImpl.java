package org.sss.backend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sss.backend.model.Suplier;

@SuppressWarnings("deprecation")
@Repository("SuplierDAO")

public class SuplierDAOImpl implements SuplierDAO{

    @Autowired

         private SessionFactory sessionFactory;
         public SuplierDAOImpl(SessionFactory sessionFactory)
{
	this.sessionFactory = sessionFactory;
}

 
         @Transactional
     	public List<Suplier> list() {
     		@SuppressWarnings("unchecked")
     		List<Suplier> listSuplier = (List<Suplier>) sessionFactory.getCurrentSession()
     				.createCriteria(Suplier.class)
     				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

     		return listSuplier;
}
         @Transactional
     	public void saveOrUpdate(Suplier Suplier) {
     		sessionFactory.getCurrentSession().saveOrUpdate(Suplier);
     	}

     	@Transactional
     	public void delete(String id) {
     		Suplier SuplierToDelete = new Suplier();
     		SuplierToDelete.getSID();
     		sessionFactory.getCurrentSession().delete(SuplierToDelete);
     	}

     	@Transactional
     	public Suplier get(String id) {
     		String hql = "from Suplier where id=" + id;
     		@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
     		
     		@SuppressWarnings("unchecked")
     		List<Suplier> listSuplier = (List<Suplier>) query.list();
     		
     		if (listSuplier != null && !listSuplier.isEmpty()) {
     			return listSuplier.get(0);
     		}
     		
     		return null;
     	}


     }
