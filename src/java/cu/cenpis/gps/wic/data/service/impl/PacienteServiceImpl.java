package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.dao.EstudioDAO;
import cu.cenpis.gps.wic.data.service.PacienteService;
import cu.cenpis.gps.wic.data.entity.Paciente;
import cu.cenpis.gps.wic.data.dao.PacienteDAO;
import cu.cenpis.gps.wic.data.entity.Estudio;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PacienteServiceImpl extends BaseServiceImpl<Paciente, java.lang.Long, PacienteDAO>
        implements PacienteService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EstudioDAO estudioDAO;

    public PacienteServiceImpl() {
        System.out.println("PacienteServiceImpl()");
    }

    @Override
    public List<Estudio> findEstudiosByPaciente(Paciente paciente) {
        return estudioDAO.findNamedQuery("Estudio.findByPaciente", "idPaciente", paciente.getIdPaciente());
    }   

    @Override
    public boolean existe(Paciente paciente) {
        List<Paciente> pacientes = findNamedQuery("Paciente.findByHistoriaClinica", "historiaClinica", paciente.getHistoriaClinica());
        return pacientes.stream().anyMatch((p) -> (p.getHistoriaClinica().equals(paciente.getHistoriaClinica()) && !Objects.equals(paciente.getIdPaciente(), p.getIdPaciente())));
    }
}
