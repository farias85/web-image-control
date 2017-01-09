package cu.cenpis.gps.wic.data.service;

import cu.cenpis.gps.wic.data.entity.Medico;

public interface MedicoService extends BaseService<Medico, java.lang.Long> {

    public boolean existe(Medico medico);

    public void refrescarSelected(Medico medico);
}
