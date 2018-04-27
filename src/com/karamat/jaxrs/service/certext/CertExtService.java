package com.karamat.jaxrs.service.certext;

import java.util.List;

import com.karamat.jaxrs.model.CertExt;
import com.karamat.jaxrs.model.Response;

public interface CertExtService {

    public Response<CertExt> add(CertExt p);

    public Response<CertExt> delete(int id);

    public CertExt get(int id);

    public List<CertExt> getAll();

}