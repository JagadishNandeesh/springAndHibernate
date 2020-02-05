package com.luv2code.hibernate.demo;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session =factory.getCurrentSession();
		
		try {
			
			int id =1;
			session.beginTransaction();
			
			Student studentData = session.get(Student.class, id);
			
			if(Objects.nonNull(studentData)) {
				session.delete(studentData);
			}
		
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
		

	}

}
