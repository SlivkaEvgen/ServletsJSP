package org.homework.service.interfaces;

import org.homework.repository.interfaces.ProjectCrudRepository;

import java.util.List;

public interface ProjectService extends ProjectCrudRepository {

    List<String> getListProjectsWithDate();
}
