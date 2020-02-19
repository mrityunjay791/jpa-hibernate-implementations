package com.mrityunjay.jpahibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mrityunjay.jpahibernate.entity.InstructorDetail;
import com.mrityunjay.jpahibernate.util.HibernateUtil;

public class InstructorDetailDao {

	/**
	 * Saving instructor details.
	 * 
	 * @param instructorDetail
	 */
    public void saveInstructorDetail(InstructorDetail instructorDetail) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.save(instructorDetail);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Updating instructor details.
     * 
     * @param instructorDetail
     */
    public void updateInstructorDetail(InstructorDetail instructorDetail) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.update(instructorDetail);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Getting instructor details.
     * 
     * @param id
     * @return
     */
    public InstructorDetail getInstructorDetail(int id) {

        Transaction transaction = null;
        InstructorDetail instructor = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            instructor = session.get(InstructorDetail.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return instructor;
    }
}