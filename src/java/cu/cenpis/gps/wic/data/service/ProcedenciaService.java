package cu.cenpis.gps.wic.data.service;

import cu.cenpis.gps.wic.data.entity.Procedencia;

public interface ProcedenciaService extends BaseService<Procedencia, java.lang.Long> {
    
    public boolean existe(Procedencia procedencia);

    public void refrescarSelected(Procedencia procedencia);

}
