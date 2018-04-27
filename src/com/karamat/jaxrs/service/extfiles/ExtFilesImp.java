package com.karamat.jaxrs.service.extfiles;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.karamat.jaxrs.model.ExtFiles;
import com.karamat.jaxrs.model.Response;
import com.karamat.jaxrs.service.DbOperations;

@Path("/extfiles")
public class ExtFilesImp implements ExtFilesService {

    @Override
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<ExtFiles> add(ExtFiles p) {
        return DbOperations.createRecord(p);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<ExtFiles> delete(@PathParam("id") int id) {
        return DbOperations.deleteRecord(id, new ExtFiles());
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ExtFiles get(@PathParam("id") int id) {
        return DbOperations.findRecordById(id, new ExtFiles());
    }

    @Override
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ExtFiles> getAll() {
        return DbOperations.displayRecords(new ExtFiles());
    }

}
