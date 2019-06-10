package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteOnlyDetail {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			//get the InstructorDetail object
			int theId=4;
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("tempInstructorDetail: "+tempInstructorDetail);
			
			//print the associated instructor
			System.out.println("The associated instructor: "+ tempInstructorDetail.getInstructor());
			
			//remove the associated object reference break bidirectional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			//delete the instructor detail
			System.out.println("deleting instructor detail: "+tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			//handle connectionleak issue
			session.close();
			factory.close();
		}
	}

}
