package cu.cenpis.gps.wic.data.service;

import cu.cenpis.gps.wic.data.entity.Especialidad;
import java.util.List;

public interface EspecialidadService extends BaseService<Especialidad, java.lang.Long> {

    public List<String> findNames();

    public boolean existe(Especialidad especialidad);
    
    public void refrescarSelected(Especialidad especialidad);
}
