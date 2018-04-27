package com.karamat.jaxrs.service.certext;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.karamat.jaxrs.model.CertExt;
import com.karamat.jaxrs.model.Response;
import com.karamat.jaxrs.service.DbOperations;

//  certificate/cert_id/extentions/ext_id/ext
//  certificate/cert_id/extentions/ext_id/parts
@Path("/certext")
public class CertExtServiceImpl implements CertExtService {

//    private static Map<Integer,CertExt> certExts = new HashMap<Integer,CertExt>();

    @Override
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<CertExt> add(CertExt p) {
        return   DbOperations.createRecord(p);
    }


    @Override
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<CertExt> delete(@PathParam("id") int id) {
        return DbOperations.deleteRecord(id, new CertExt());
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CertExt get(@PathParam("id") int id) {
             return DbOperations.findRecordById(id, new CertExt());
    }


    @Override
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CertExt> getAll() {
        return DbOperations.displayRecords(new CertExt());
    }

}