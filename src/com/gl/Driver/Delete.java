package com.gl.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.gl.entity.*;


public class Delete {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)				
				.addAnnotatedClass(TeacherDetails.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			int theTeacherId = 4;
			
			session.beginTransaction();
			
			Teacher tempTeacher = session.get(Teacher.class, theTeacherId);
			if(tempTeacher != null)
			{
				System.out.println("Deleting the record");
				session.delete(tempTeacher);
			}
			
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}
}

