package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.service.ProcedenciaService;
import cu.cenpis.gps.wic.data.entity.Procedencia;
import cu.cenpis.gps.wic.data.dao.ProcedenciaDAO;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProcedenciaServiceImpl extends BaseServiceImpl<Procedencia, java.lang.Long, ProcedenciaDAO>
        implements ProcedenciaService {

    private static final long serialVersionUID = 1L;

    public ProcedenciaServiceImpl() {
        System.out.println("ProcedenciaServiceImpl()");
    }

    @Override
    public boolean existe(Procedencia procedencia) {
        List<Procedencia> procedencias = findNamedQuery("Procedencia.findByNombre", "nombre", procedencia.getNombre());
        return procedencias.stream().anyMatch((d) -> (d.getNombre().equals(procedencia.getNombre()) && !Objects.equals(procedencia.getIdProcedencia(), d.getIdProcedencia())));
    }

    @Override
    public void refrescarSelected(Procedencia procedencia) {
        Procedencia p;
        p = dao.find(procedencia.getIdProcedencia());
        if (p != null) {
            procedencia.setNombre(p.getNombre());
            procedencia.setDescripcion(p.getDescripcion());
        }
    }
}
