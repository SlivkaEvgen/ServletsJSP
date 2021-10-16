package org.homework.service;

import org.homework.model.Developer;
import org.homework.repository.DeveloperCrudRepositoryImpl;
import org.homework.repository.interfaces.DeveloperCrudRepository;
import org.homework.service.interfaces.DeveloperService;

import java.io.Serializable;
import java.util.List;

public class DeveloperServiceImplImpl extends ModelServiceImpl<Developer, Long> implements DeveloperService, Serializable {

    private static final long serialVersionUID = 10000000024L;
    private final DeveloperCrudRepository CRUD_REPOSITORY = new DeveloperCrudRepositoryImpl(Developer.class);

    public DeveloperServiceImplImpl(Class<Developer> classModel) {
        super(classModel);
    }

    @Override
    public Object getSumSalariesDevelopersOfOneProject(Long projectId) {
        return CRUD_REPOSITORY.getSumSalariesDevelopersOfOneProject(projectId);
    }

    @Override
    public List<Developer> getDevelopersFromOneProject(Long projectId) {
        return CRUD_REPOSITORY.getDevelopersFromOneProject(projectId);
    }

    @Override
    public List<Developer> getDevelopersByActivity(String nameActivity) {
        return CRUD_REPOSITORY.getDevelopersByActivity(nameActivity);
    }

    @Override
    public List<Developer> getDevelopersByLevel(String nameLevel) {
        return CRUD_REPOSITORY.getDevelopersByLevel(nameLevel);
    }
}
