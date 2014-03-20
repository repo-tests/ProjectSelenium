package Model.dao;



import org.hibernate.*;

import org.hibernate.cfg.*;
public class HibernateUtil {    
public static final SessionFactory sessionFactory;    
static {        
try {            
     
sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();        
} catch (HibernateException ex) {
System.err.println("Initial SessionFactory creation failed." + ex);  throw new ExceptionInInitializerError(ex);        
}    
}    
//public static final ThreadLocal session = new ThreadLocal();    
public static SessionFactory getSessionFactory() {        
return sessionFactory;    
}
}
