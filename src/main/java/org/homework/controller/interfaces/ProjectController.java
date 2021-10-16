package org.homework.controller.interfaces;

import org.homework.service.interfaces.ProjectService;

import java.util.List;

public interface ProjectController extends ProjectService {

    List<String> getListProjectsWithDate();
}
