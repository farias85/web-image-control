package cu.cenpis.gps.wic.data.service;

import cu.cenpis.gps.wic.data.entity.Rol;
import java.util.List;

public interface RolService extends BaseService<Rol, java.lang.Long> {

    public List<Rol> getRolListNotIn();
}
