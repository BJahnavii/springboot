package com.infinite.MunicipalVizag.repository;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infnite.MunicipalVizag.model.Municipal;

/**
 * @author jahnavibo
 *
 */
@Repository
public class MunicipalDaoimpl implements IMunicipalDao {
	@Autowired
	private SessionFactory SessionFactory;//creating a session factory

	public void setSessionFactory(Session sessionFactory) {
		this.SessionFactory = SessionFactory;
	}

	@Override
	public List<Municipal> getAllComplains() {// to display as list
		Session session = this.SessionFactory.getCurrentSession();
		List<Municipal> ls = session.createQuery("from Municipal").list();
		return ls;
	}

	@Override
	public Municipal getMunicipal(int id) {// display through id
		// TODO Auto-generated method stub
		Session session = this.SessionFactory.getCurrentSession();
		Municipal municipal = (Municipal) session.get(Municipal.class, id);
		return municipal;
	}

	@Override
	public Municipal addMunicipal(Municipal municipal) {// inserting
		// TODO Auto-generated method stub
		Session session = this.SessionFactory.getCurrentSession();
		session.save(municipal);
		return null;
	}

	@Override
	public void updateMunicipal(Municipal municipal) { // updating
		// TODO Auto-generated method stub
		Session session = this.SessionFactory.getCurrentSession();
		Hibernate.initialize(municipal);
		session.update(municipal);
	}

	@Override
	public void deleteMunicipal(int id) { // deleting
		// TODO Auto-generated method stub
		Session session = this.SessionFactory.getCurrentSession();
		Municipal m = (Municipal) session.load(Municipal.class, new Integer(id));
		if (null != m) {
			session.delete(m);
		}
	}
}
