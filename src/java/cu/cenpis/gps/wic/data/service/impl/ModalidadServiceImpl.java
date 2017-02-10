package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.dao.ModalidadDAO;
import cu.cenpis.gps.wic.data.entity.Modalidad;
import cu.cenpis.gps.wic.data.service.ModalidadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModalidadServiceImpl extends BaseServiceImpl<Modalidad, java.lang.Long, ModalidadDAO>
        implements ModalidadService {

    private static final long serialVersionUID = 1L;

    public ModalidadServiceImpl() {
        System.out.println("ModalidadServiceImpl()");
    }
}
