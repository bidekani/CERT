package com.karamat.jaxrs.service.certpartcert;

import java.util.List;
import com.karamat.jaxrs.model.CertPartCert;
import com.karamat.jaxrs.model.Response;

public interface CertPartCertService {

    public Response<CertPartCert> add(CertPartCert p);

    public Response<CertPartCert> delete(int id);

    public CertPartCert get(int id);

    public List<CertPartCert> getAll();
}
