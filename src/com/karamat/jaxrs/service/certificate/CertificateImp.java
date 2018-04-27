package com.karamat.jaxrs.service.certificate;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.karamat.jaxrs.model.Certificate;
import com.karamat.jaxrs.model.Response;
import com.karamat.jaxrs.service.DbOperations;

@Path("/certificate")
public class CertificateImp implements CertificateService {

    @Override
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<Certificate> add(Certificate p) {
        return   DbOperations.createRecord(p);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<Certificate> delete(@PathParam("id") int id) {
        return DbOperations.deleteRecord(id , new Certificate());
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Certificate get(@PathParam("id") int id) {
        return DbOperations.findRecordById(id , new Certificate());
    }

    @Override
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Certificate> getAll() {
        return DbOperations.displayRecords(new Certificate());
    }

    @Override
    @POST
    @Path("/filter")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Certificate> filterCertificate(Certificate cert) throws Exception {
        return DbOperations.filterRecords(cert);
    }

}
