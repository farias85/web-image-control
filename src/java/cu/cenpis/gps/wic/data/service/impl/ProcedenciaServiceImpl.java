package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.service.ProcedenciaService;
import cu.cenpis.gps.wic.data.entity.Procedencia;
import cu.cenpis.gps.wic.data.dao.ProcedenciaDAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProcedenciaServiceImpl extends BaseServiceImpl<Procedencia, java.lang.Long, ProcedenciaDAO>
        implements ProcedenciaService {

    private static final long serialVersionUID = 1L;

    public ProcedenciaServiceImpl() {
        System.out.println("ProcedenciaServiceImpl()");
    }
}
