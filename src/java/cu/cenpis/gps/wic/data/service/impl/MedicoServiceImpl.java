package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.service.MedicoService;
import cu.cenpis.gps.wic.data.entity.Medico;
import cu.cenpis.gps.wic.data.dao.MedicoDAO;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicoServiceImpl extends BaseServiceImpl<Medico, java.lang.Long, MedicoDAO>
        implements MedicoService {

    private static final long serialVersionUID = 1L;

    public MedicoServiceImpl() {
        System.out.println("MedicoServiceImpl()");
    }

    @Override
    public boolean existe(Medico medico) {
        List<Medico> medicos = findNamedQuery("Medico.findByNombreApellidos", "nombreApellidos", medico.getNombreApellidos());
        for (Medico m : medicos) {
            if (m.getNombreApellidos().equals(medico.getNombreApellidos()) && !Objects.equals(medico.getIdMedico(), m.getIdMedico())) {
                return true;
            } 
        }
        return false;
    }

    @Override
    public void refrescarSelected(Medico medico) {
        Medico m;
        m = dao.find(medico.getIdMedico());
        if (m != null) {
            medico.setNombreApellidos(m.getNombreApellidos());
            medico.setDescripcion(m.getDescripcion());
        }
    }
}
