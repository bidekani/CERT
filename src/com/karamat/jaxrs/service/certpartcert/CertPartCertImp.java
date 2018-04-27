package com.karamat.jaxrs.service.certpartcert;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.karamat.jaxrs.model.CertPartCert;
import com.karamat.jaxrs.model.Response;
import com.karamat.jaxrs.service.DbOperations;

@Path("/certpartcert")
public class CertPartCertImp implements CertPartCertService {

    @Override
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<CertPartCert> add(CertPartCert p) {
        return DbOperations.createRecord(p);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<CertPartCert> delete(@PathParam("id") int id) {
        return DbOperations.deleteRecord(id, new CertPartCert());
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CertPartCert get(@PathParam("id") int id) {
        return DbOperations.findRecordById(id, new CertPartCert());
    }

    @Override
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CertPartCert> getAll() {
        return DbOperations.displayRecords(new CertPartCert());
    }

}
