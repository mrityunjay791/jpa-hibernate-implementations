package com.mrityunjay.jpahibernate;

import com.mrityunjay.jpahibernate.dao.InstructorDao;
import com.mrityunjay.jpahibernate.entity.Instructor;
import com.mrityunjay.jpahibernate.entity.InstructorDetail;

/**
 * One to one relationship implementation.
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	Instructor instructor = new Instructor("Raju", "Babu2", "rs@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.fb22.com", "bio");
        instructor.setInstructorDetail(instructorDetail);
        InstructorDao instructorDao = new InstructorDao();
        instructor.setId(1);
//        instructorDao.saveInstructor(instructor);
        instructorDao.updateInstructor(instructor);
        
        
    }
}
