package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.service.MedicoService;
import cu.cenpis.gps.wic.data.entity.Medico;
import cu.cenpis.gps.wic.data.dao.MedicoDAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicoServiceImpl extends BaseServiceImpl<Medico, java.lang.Long, MedicoDAO>
        implements MedicoService {

    private static final long serialVersionUID = 1L;

    public MedicoServiceImpl() {
        System.out.println("MedicoServiceImpl()");
    }
}
