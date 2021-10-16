package org.homework.repository.interfaces;

import org.homework.model.Project;

import java.util.List;

public interface ProjectCrudRepository extends CrudRepository<Project,Long> {

    List<String> getListProjectsWithDate();
}
