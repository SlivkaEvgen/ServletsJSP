package org.homework.repository;

import org.homework.model.Developer;
import org.homework.model.Project;
import org.homework.repository.interfaces.ProjectCrudRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProjectCrudRepositoryImpl extends ModelRepositoryImpl<Project, Long> implements ProjectCrudRepository, Serializable {

    private static final long serialVersionUID = 10000000023L;

    public ProjectCrudRepositoryImpl(Class<Project> classModel) {
        super(classModel);
    }

    @Override
    public List<String> getListProjectsWithDate() {
        List<String> projectWithDate = new ArrayList<>();
        for (Project project : findAll()) {
            projectWithDate.add("Project " + project.getName() + " has " +
                    new DeveloperCrudRepositoryImpl(Developer.class)
                            .getDevelopersFromOneProject(project.getId()).size()
                    + " developers, sight date: " +
                    project.getFirstDate());
        }
        return projectWithDate;
    }
}
