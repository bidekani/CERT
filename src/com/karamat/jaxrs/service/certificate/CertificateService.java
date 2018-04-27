package com.karamat.jaxrs.service.certificate;

import java.util.List;

import com.karamat.jaxrs.model.Certificate;
import com.karamat.jaxrs.model.Response;

public interface CertificateService {

    public Response<Certificate> add(Certificate p);

    public Response<Certificate> delete(int id);

    public Certificate get(int id);

    public List<Certificate> getAll();

    public List<Certificate> filterCertificate(Certificate cert) throws Exception;


}
