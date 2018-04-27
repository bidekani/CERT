package com.karamat.jaxrs.service.useraccess;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.karamat.jaxrs.model.Response;
import com.karamat.jaxrs.model.UserAccess;
import com.karamat.jaxrs.service.DbOperations;

@Path("/user")
public class UserAccessImp implements UserAccessService{

    @Override
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<UserAccess> add(UserAccess p) {
        return DbOperations.createRecord(p);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<UserAccess> delete(@PathParam("id") int id) {
        return DbOperations.deleteRecord(id, new UserAccess());
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserAccess get(@PathParam("id") int id) {
        return DbOperations.findRecordById(id, new UserAccess());
    }

    @Override
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserAccess> getAll() {
        return DbOperations.displayRecords(new UserAccess());
    }

}
