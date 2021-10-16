package org.homework.service;

import org.homework.model.Project;
import org.homework.repository.ProjectCrudRepositoryImpl;
import org.homework.repository.interfaces.ProjectCrudRepository;
import org.homework.service.interfaces.ProjectService;

import java.io.Serializable;
import java.util.List;

public class ProjectServiceImplImpl extends ModelServiceImpl<Project, Long> implements ProjectService, Serializable {

    private static final long serialVersionUID = 10000000026L;
    private final ProjectCrudRepository CRUD_REPOSITORY = new ProjectCrudRepositoryImpl(Project.class);

    public ProjectServiceImplImpl(Class<Project> classModel) {
        super(classModel);
    }

    @Override
    public List<String> getListProjectsWithDate() {
        return CRUD_REPOSITORY.getListProjectsWithDate();
    }
}
