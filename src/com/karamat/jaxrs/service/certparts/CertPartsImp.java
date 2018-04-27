package com.karamat.jaxrs.service.certparts;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.karamat.jaxrs.model.CertParts;
import com.karamat.jaxrs.model.Response;
import com.karamat.jaxrs.service.DbOperations;

@Path("/certparts")
public class CertPartsImp implements CertPartsService {

    @Override
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<CertParts> add(CertParts p) {
        return DbOperations.createRecord(p);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<CertParts> delete(@PathParam("id") int id) {
        return DbOperations.deleteRecord(id, new CertParts());
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CertParts get(@PathParam("id") int id) {
        return DbOperations.findRecordById(id, new CertParts());
    }

    @Override
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CertParts> getAll() {
        return DbOperations.displayRecords(new CertParts());
    }
}
