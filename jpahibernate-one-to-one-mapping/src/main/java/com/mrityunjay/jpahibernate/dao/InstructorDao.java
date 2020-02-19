package com.mrityunjay.jpahibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mrityunjay.jpahibernate.entity.Instructor;
import com.mrityunjay.jpahibernate.entity.InstructorDetail;
import com.mrityunjay.jpahibernate.util.HibernateUtil;

/**
 * 
 * @author mrityunjaykumar
 *
 */
public class InstructorDao {
	
	private static InstructorDetailDao insDetails = new InstructorDetailDao();

	/**
	 * Used for saving instructor details.
	 * 
	 * @param instructor
	 */
	public void saveInstructor(Instructor instructor) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {

			transaction = session.beginTransaction();
			session.save(instructor);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Used for updating instructor details.
	 * 
	 * @param instructor
	 */
	public void updateInstructor(Instructor instructor) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {

			// start a transaction
			transaction = session.beginTransaction();
			Instructor instructorTemp = session.get(Instructor.class, instructor.getId());
			if(instructorTemp != null) {
				InstructorDetail instructorDetail = new InstructorDetail(instructor.getInstructorDetail().getYoutubeChannel(), instructor.getInstructorDetail().getHobby());
				instructorDetail.setId(instructor.getInstructorDetail().getId());
				instructorTemp.setEmail(instructor.getEmail());
				instructorTemp.setFirstName(instructor.getFirstName());
				
				instructorTemp.setInstructorDetail(instructorDetail);
				instructorTemp.setLastName(instructor.getLastName());
				
				session.update(instructorTemp); // Update
			}
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			if (transaction != null) {
				System.out.println("hbsbjds");
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Used for deleting instructor.
	 * 
	 * @param id
	 */
	public void deleteInstructor(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, id);

			if (instructor != null) {
				session.delete(instructor);
				System.out.println(instructor.getFirstName() + " deleted..!");

			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Used for getting instructor details.
	 * 
	 * @param id
	 * @return
	 */
	public Instructor getInstructor(int id) {
		Transaction transaction = null;
		Instructor instructor = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			instructor = session.get(Instructor.class, id);

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
