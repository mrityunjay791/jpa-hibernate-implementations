package com.mrityunjay.jpahibernate;

import com.mrityunjay.jpahibernate.dao.CourseDao;
import com.mrityunjay.jpahibernate.dao.InstructorDao;
import com.mrityunjay.jpahibernate.entity.Course;
import com.mrityunjay.jpahibernate.entity.Instructor;

/**
 * Implemented one-to-many mappings.
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	  InstructorDao instructorDao = new InstructorDao();
    	  CourseDao courseDao = new CourseDao();
    	  
    	  Instructor instructor = new Instructor("Ramesh", "Fadatare", "ramesh@javaguides.com");
    	  instructorDao.saveInstructor(instructor);
    	  
    	  // create some courses
    	  Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
    	  tempCourse1.setInstructor(instructor);
    	  courseDao.saveCourse(tempCourse1);  
    	  
    	  Course tempCourse2 = new Course("The Pinball Masterclass");
    	  tempCourse2.setInstructor(instructor);
    	  courseDao.saveCourse(tempCourse2);
    }
}
