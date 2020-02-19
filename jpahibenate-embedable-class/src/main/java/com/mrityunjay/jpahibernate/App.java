package com.mrityunjay.jpahibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mrityunjay.jpahibernate.model.Address;
import com.mrityunjay.jpahibernate.model.Name;
import com.mrityunjay.jpahibernate.model.User;
import com.mrityunjay.jpahibernate.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Name name = new Name("Mrityunjay", "Kumar", "Sharma");
        Address address = new Address("111", "Puadroad", "Gaya", "Bihar", "India", "824207");
        User user = new User(name, "mk@gmail.com", address);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
    }
    
}
