package com.mrityunjay.jpahibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mrityunjay.jpahibernate.model.Project;
import com.mrityunjay.jpahibernate.util.HibernateUtil;

/**
 * 
 * @author mrityunjaykumar
 *
 */
public class ProjectDao {
	public void saveProject(Project project) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			Transaction transaction = session.beginTransaction();
			// save the project object
			session.save(project);
			// commit transaction
			transaction.commit();
		}
	}

	public List<Project> getProjects() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Project", Project.class).list();
		}
	}
}