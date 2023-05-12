package com.denniskurilov.models;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    @Autowired
    private SessionFactory sessionFactory;
    
	@Override
	public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Employee e ORDER BY e.id ASC";
        Query query = session.createQuery(hql);
        @SuppressWarnings("unchecked")
        List<Employee> rs = query.getResultList();
        return rs;
	}

	@Override
	public List<Employee> search(String keyword) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Employee e WHERE UPPER(e.firstName) LIKE '%' || UPPER(:keyword) || '%'"
				+ " OR UPPER(e.lastName) LIKE '%' || UPPER(:keyword) || '%'"
				+ " OR UPPER(e.email) LIKE '%' || UPPER(:keyword) || '%'"
				+ " ORDER BY e.id";
		Query query = session.createQuery(hql);
		query.setParameter("keyword", keyword);
		@SuppressWarnings("unchecked")
		List<Employee> rs = query.getResultList();
		return rs;
	}
	
	@Override
	public void save(Employee employee) {
	       Session session = sessionFactory.getCurrentSession();
	       session.saveOrUpdate(employee);
	}

	@Override
	public Employee get(long id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = session.get(Employee.class, id);
        return employee;
	}

	@Override
	public void delete(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(employee);	
	}
	
}
