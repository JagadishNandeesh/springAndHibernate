package com.luv2code.hibernate.demo;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		Session session =factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			
			int theId = 1;
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("TtheInstructorDetailhe" + theInstructorDetail);
			System.out.println("theInstructor" + theInstructorDetail.getInstructor().getFirstName());
			
			theInstructorDetail.getInstructor().setInstructorDetail(null);
			if(Objects.nonNull(theInstructorDetail)) {
				session.delete(theInstructorDetail);
			}
			
			
			session.getTransaction().commit();
			System.out.println("done");
			
			
		}
		finally {
			factory.close();
		}
		
		

	}

}
