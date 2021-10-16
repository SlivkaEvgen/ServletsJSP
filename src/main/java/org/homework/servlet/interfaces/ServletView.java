package org.homework.servlet.interfaces;

import org.homework.model.BaseModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public interface ServletView<T extends BaseModel<ID>, ID> {

    void addNew(HttpServletRequest req, HttpServletResponse resp);

    void delete(HttpServletRequest req, HttpServletResponse resp);

    void getAll(HttpServletRequest req, HttpServletResponse resp);

    void updateGetDo(HttpServletRequest req, HttpServletResponse resp);

    void updatePostDo(HttpServletRequest req, HttpServletResponse resp);

    Optional<T> getById(ID id);
}
