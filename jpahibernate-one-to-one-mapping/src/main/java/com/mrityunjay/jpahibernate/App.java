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
    	Instructor instructor = new Instructor("Ankit", "Sharmaji", "mks@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.google.com", "Maths-testing2");
        instructor.setInstructorDetail(instructorDetail);
        InstructorDao instructorDao = new InstructorDao();
        instructorDao.saveInstructor(instructor);
//        instructorDao.updateInstructor(instructor);
        
        
    }
}
