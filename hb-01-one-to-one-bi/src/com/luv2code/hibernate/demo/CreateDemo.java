package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		Session session =factory.getCurrentSession();
		
		try {
			
			Instructor tempInstructor = new Instructor("chad", "sda", "fgh@gm.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com","Luv2 code");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			
			session.save(tempInstructor);
			session.getTransaction().commit();
			System.out.println("done");
			
			
		}
		finally {
			factory.close();
		}
		
		

	}

}
