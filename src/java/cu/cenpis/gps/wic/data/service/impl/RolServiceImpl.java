package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.service.RolService;
import cu.cenpis.gps.wic.data.entity.Rol;
import cu.cenpis.gps.wic.data.dao.RolDAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolServiceImpl extends BaseServiceImpl<Rol, java.lang.Long, RolDAO>
        implements RolService {

    private static final long serialVersionUID = 1L;

    public RolServiceImpl() {
        System.out.println("RolServiceImpl()");
    }
}
