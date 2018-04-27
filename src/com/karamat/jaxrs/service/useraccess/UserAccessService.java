package com.karamat.jaxrs.service.useraccess;

import java.util.List;

import com.karamat.jaxrs.model.Response;
import com.karamat.jaxrs.model.UserAccess;

public interface UserAccessService {
    public Response<UserAccess> add(UserAccess p);

    public Response<UserAccess> delete(int id);

    public UserAccess get(int id);

    public List<UserAccess> getAll();
}
