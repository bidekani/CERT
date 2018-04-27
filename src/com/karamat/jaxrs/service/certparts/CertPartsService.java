package com.karamat.jaxrs.service.certparts;

import java.util.List;

import com.karamat.jaxrs.model.CertParts;
import com.karamat.jaxrs.model.Response;

public interface CertPartsService {
    public Response<CertParts> add(CertParts p);

    public Response<CertParts> delete(int id);

    public CertParts get(int id);

    public List<CertParts> getAll();
}
