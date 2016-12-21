package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.service.DiagnosticoService;
import cu.cenpis.gps.wic.data.entity.Diagnostico;
import cu.cenpis.gps.wic.data.dao.DiagnosticoDAO;
import cu.cenpis.gps.wic.data.dao.EstudioDAO;
import cu.cenpis.gps.wic.data.entity.Estudio;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiagnosticoServiceImpl extends BaseServiceImpl<Diagnostico, java.lang.Long, DiagnosticoDAO>
        implements DiagnosticoService {

    private static final long serialVersionUID = 1L;

    @Autowired
    protected EstudioDAO estudioDAO;

    public DiagnosticoServiceImpl() {
        System.out.println("DiagnosticoServiceImpl()");
    }

    @Override
    public List<Estudio> findEstudiosByDiagnostico(Diagnostico diagnostico) {
        return estudioDAO.findNamedQuery("Estudio.findByDiagnostico", "idDiagnostico", diagnostico.getIdDiagnostico());
    }

    @Override
    public boolean existe(Diagnostico diagnostico) {
        List<Diagnostico> diagnosticos = findNamedQuery("Diagnostico.findByNombre", "nombre", diagnostico.getNombre());
        return diagnosticos.stream().anyMatch((d) -> (d.getNombre().equals(diagnostico.getNombre()) && !Objects.equals(diagnostico.getIdDiagnostico(), d.getIdDiagnostico())));
    }
}
