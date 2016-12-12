package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.service.TipoEstudioService;
import cu.cenpis.gps.wic.data.entity.TipoEstudio;
import cu.cenpis.gps.wic.data.dao.TipoEstudioDAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoEstudioServiceImpl extends BaseServiceImpl<TipoEstudio, java.lang.Long, TipoEstudioDAO>
        implements TipoEstudioService {

    private static final long serialVersionUID = 1L;

    public TipoEstudioServiceImpl() {
        System.out.println("TipoEstudioServiceImpl()");
    }
}
