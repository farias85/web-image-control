package cu.cenpis.gps.wic.data.service;

import cu.cenpis.gps.wic.data.entity.Estudio;
import cu.cenpis.gps.wic.data.entity.Paciente;

public interface EstudioService extends BaseService<Estudio, java.lang.Long> {

    public Paciente findPacienteByHistoriaClinica(String hc);
}
