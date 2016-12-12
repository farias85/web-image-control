package cu.cenpis.gps.wic.data.dao;

import cu.cenpis.gps.wic.data.entity.Especialidad;
import java.util.List;

public interface EspecialidadDAO extends AbstractDAO<Especialidad, java.lang.Long> {

    public List<Object[]> findNames();
}
