package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
	
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> theQuery= session.createQuery("from Customer", Customer.class);
		List<Customer> customers =theQuery.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session session= sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, theId);
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session session =sessionFactory.getCurrentSession();
		Query query= session.createQuery("delete from Customer where id=:cusotmerId");
		query.setParameter("cusotmerId", theId);
		query.executeUpdate();
		
	}

}
