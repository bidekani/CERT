package com.karamat.jaxrs.service.extfiles;

import java.util.List;

import com.karamat.jaxrs.model.ExtFiles;
import com.karamat.jaxrs.model.Response;

public interface ExtFilesService {
    public Response<ExtFiles> add(ExtFiles p);

    public Response<ExtFiles> delete(int id);

    public ExtFiles get(int id);

    public List<ExtFiles> getAll();
}
