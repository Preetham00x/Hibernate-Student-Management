import org.hibernate.cfg.Configuration;
import jakarta.persistence.EntityExistsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.telidu.model.Student;
public class LaunchStandardApplication {
 public static void main(String[] args) {
 Configuration config = null;
 SessionFactory sessionFactory = null;
 Session session = null;
 Transaction transaction = null;
 boolean flag = false;
 config = new Configuration();
 config.configure();
 sessionFactory = config.buildSessionFactory();
 session = sessionFactory.openSession();
 Student student = new Student();
 student.setsId(134);
 student.setsName("Arjun");
 student.setsCity("Ballia");
 try {
	 transaction=session.beginTransaction();
	 session.persist(student);
	 flag=true;
 }
 catch(HibernateException e) {
	 e.printStackTrace();
	 
 }
 catch(Exception e) {
	 e.printStackTrace();
 }
 
 }
 }

 

