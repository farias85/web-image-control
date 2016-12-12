package cu.cenpis.gps.wic.data.dao;

import cu.cenpis.gps.wic.data.entity.Estudio;
import java.util.List;

public interface EstudioDAO extends AbstractDAO<Estudio, java.lang.Long> {

    public List<Object[]> queryMultipleTables();
}
