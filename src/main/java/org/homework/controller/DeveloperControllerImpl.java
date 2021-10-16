package org.homework.controller;

import org.homework.controller.interfaces.DeveloperController;
import org.homework.model.Developer;
import org.homework.service.interfaces.DeveloperService;
import org.homework.service.DeveloperServiceImplImpl;

import java.io.Serializable;
import java.util.List;

public class DeveloperControllerImpl extends ModelControllerImpl<Developer, Long> implements Serializable, DeveloperController {

    private static final long serialVersionUID = 10000000027L;
    private final DeveloperService DEVELOPER_SERVICE = new DeveloperServiceImplImpl(Developer.class);

    public DeveloperControllerImpl(Class<Developer> classModel) {
        super(classModel);
    }

    @Override
    public Object getSumSalariesDevelopersOfOneProject(Long projectId) {
        return DEVELOPER_SERVICE.getSumSalariesDevelopersOfOneProject(projectId);
    }

    @Override
    public List<Developer> getDevelopersFromOneProject(Long projectId) {
        return DEVELOPER_SERVICE.getDevelopersFromOneProject(projectId);
    }

    @Override
    public List<Developer> getDevelopersByActivity(String nameActivity) {
        return DEVELOPER_SERVICE.getDevelopersByActivity(nameActivity);
    }

    @Override
    public List<Developer> getDevelopersByLevel(String nameLevel) {
        return DEVELOPER_SERVICE.getDevelopersByLevel(nameLevel);
    }
}
