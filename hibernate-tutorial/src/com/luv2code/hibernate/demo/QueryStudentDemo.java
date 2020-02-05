package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session =factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			List<Student> students= session
										.createQuery("from Student")
										.getResultList();
			for(Student tempStudent:students ) {
				System.out.println(tempStudent);
			}
			
			
			List<Student> student1 = session.createQuery("from Student s where s.firstName='paul'").getResultList();
	
			for(Student tempStudent:student1 ) {
				System.out.println(tempStudent);
			}
			
			List<Student> student2 = session
										.createQuery("from Student s where s.firstName='paul' OR s.lastName='wall'").getResultList();
			
			for(Student tempStudent:student2) {
				System.out.println(tempStudent);
			}
					
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
		

	}

}
