package com.mrityunjay.jpahibernate;

import java.util.List;

import com.mrityunjay.jpahibernate.dao.ProjectDao;
import com.mrityunjay.jpahibernate.model.Project;
import com.mrityunjay.jpahibernate.model.ProjectStatus;

/**
 * 
 * Implemented to persist enum types.
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	ProjectDao projectDao = new ProjectDao();
        Project project = new Project();
        project.setProjectName("TPO");
        project.setProjectStatus(ProjectStatus.INPROGESS);
        projectDao.saveProject(project);

        List < Project > projects = projectDao.getProjects();
        projects.forEach(s -> {
            System.out.println(s.getProjectName());
            System.out.println(s.getProjectStatus());
        });
    }
}
