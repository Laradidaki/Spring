package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			//create the objects
	
			Instructor tempInstructor2= new Instructor("Diego", "Lucchetta", "lucchetta@icloud.com");
			InstructorDetail tempInstructorDetail2= new InstructorDetail("http://www.corons.com/youtube", "running");
			
			//associate the objects
		
			tempInstructor2.setInstructorDetail(tempInstructorDetail2);
			
			// start a transaction
			session.beginTransaction();
			
			//save the instructor
			//this will also save the details object because of CascadeType.ALL
		
			System.out.println("Saving instructor... "+tempInstructor2);
		
			session.save(tempInstructor2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
