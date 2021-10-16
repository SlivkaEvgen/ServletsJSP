package org.homework.controller;

import org.homework.controller.interfaces.ProjectController;
import org.homework.model.Project;
import org.homework.service.interfaces.ProjectService;
import org.homework.service.ProjectServiceImplImpl;

import java.io.Serializable;
import java.util.List;

public class ProjectControllerImpl extends ModelControllerImpl<Project, Long> implements ProjectController, Serializable {

    private static final long serialVersionUID = 10000000029L;
    private final ProjectService PROJECT_SERVICE = new ProjectServiceImplImpl(Project.class);

    public ProjectControllerImpl(Class<Project> classModel) {
        super(classModel);
    }

    @Override
    public List<String> getListProjectsWithDate() {
        return PROJECT_SERVICE.getListProjectsWithDate();
    }
}
