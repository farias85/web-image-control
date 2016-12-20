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
    public Paciente findPacienteByHistoriaClinica(String hc) {
        List<Paciente> list = dao.findNamedQuery("Paciente.findByHistoriaClinica", "historiaClinica", hc);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public boolean existe(Paciente paciente) {
        Paciente findPaciente = findPacienteByHistoriaClinica(paciente.getHistoriaClinica());
        return !Objects.equals(paciente.getHistoriaClinica(), findPaciente.getHistoriaClinica());
    }
}
