//package com.telidu.app;
//
//import org.hibernate.cfg.Configuration;
//import jakarta.persistence.EntityExistsException;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.exception.ConstraintViolationException;
//
//import com.telidu.model.Student;
//public class LaunchStandardApplication {
// public static void main(String[] args) {
// Configuration config = null;
// SessionFactory sessionFactory = null;
// Session session = null;
// Transaction transaction = null;
// boolean flag = false;
// config = new Configuration();
// config.configure();
// sessionFactory = config.buildSessionFactory();
// session = sessionFactory.openSession();
// Student student = new Student();
// student.setsId(1);
// student.setsName("Preetham");
// student.setsCity("Hyderabad");
// try {
//	 transaction=session.beginTransaction();
//	 session.persist(student);
//	 flag=true;
// }
// catch(HibernateException e) {
//	 e.printStackTrace();
//	 
// }
// catch(Exception e) {
//	 e.printStackTrace();
// }
// finally {
//	 if(flag==true) {
//		 transaction.commit();
//	 }
//	 else {
//		 transaction.rollback();
//	 }
//	 session.close();
//	 sessionFactory.close();
// }
// 
// }
// }
//
// 
//
package com.telidu.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telidu.model.Student;

public class LaunchStandardApplication {

    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure();

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // Fetch existing record
        Student student = new Student();
        if (student != null) {

            // Change values
        	student.setsId(1);
            student.setsName("Harshith");
            student.setsCity("Bandlaguda");
            //update
            session.update(student);
            System.out.println("Record updated successfully");
            System.out.println("id :"+student.getsId());
            System.out.println("name :"+student.getsName());
            System.out.println("city :" +student.getsCity());
            session.merge(null);
            //deleting record
//            session.remove(student);
//            System.out.println("record successfully deleted");

        } else {
            System.out.println("Record not found");
        }

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
