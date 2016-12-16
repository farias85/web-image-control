package cu.cenpis.gps.wic.data.dao;

import cu.cenpis.gps.wic.data.entity.Rol;
import java.util.List;

public interface RolDAO extends AbstractDAO<Rol, java.lang.Long> {

    public List<Rol> getRolListNotIn();
}

