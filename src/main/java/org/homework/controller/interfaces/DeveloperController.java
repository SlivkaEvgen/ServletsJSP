package org.homework.controller.interfaces;

import org.homework.model.Developer;
import org.homework.service.interfaces.DeveloperService;

import java.util.List;

public interface DeveloperController extends DeveloperService {

    Object getSumSalariesDevelopersOfOneProject(Long projectId);

    List<Developer> getDevelopersFromOneProject(Long projectId);

    List<Developer> getDevelopersByActivity(String nameActivity);

    List<Developer> getDevelopersByLevel(String nameLevel);
}
