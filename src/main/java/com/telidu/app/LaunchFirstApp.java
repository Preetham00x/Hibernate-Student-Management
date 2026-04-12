package com.telidu.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telidu.model.Student;

public class LaunchFirstApp {
	public static void main(String args[]) {
		//cREATE CONFIG OBJECT
	Configuration config=new Configuration();
	// configure hibernate.cfg.xml file to configuration object
	config.configure();
	//create session object
	SessionFactory sessionFactory=config.buildSessionFactory();
	//get the session from session factory
	Session session=sessionFactory.openSession();
	//begin the transaction within session
	Transaction transaction =session.beginTransaction();
	Student student=new Student();
	student.setsId(1);
	student.setsName("Preetham");
	student.setsCity("Hyderabad");
	//perform operation
	session.save(student);
	//perform transaction operations
	transaction.commit();
	//close the session
	session.close();
	
	}
}
