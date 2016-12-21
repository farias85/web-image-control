package cu.cenpis.gps.wic.data.service;

import cu.cenpis.gps.wic.data.entity.Estudio;
import cu.cenpis.gps.wic.data.entity.Paciente;
import java.util.List;

public interface PacienteService extends BaseService<Paciente, java.lang.Long> {

    public List<Estudio> findEstudiosByPaciente(Paciente diagnostico);    

    public boolean existe(Paciente paciente);
}
