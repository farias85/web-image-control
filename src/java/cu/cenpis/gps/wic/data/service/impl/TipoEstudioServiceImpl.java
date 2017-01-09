package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.service.TipoEstudioService;
import cu.cenpis.gps.wic.data.entity.TipoEstudio;
import cu.cenpis.gps.wic.data.dao.TipoEstudioDAO;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoEstudioServiceImpl extends BaseServiceImpl<TipoEstudio, java.lang.Long, TipoEstudioDAO>
        implements TipoEstudioService {

    private static final long serialVersionUID = 1L;

    public TipoEstudioServiceImpl() {
        System.out.println("TipoEstudioServiceImpl()");
    }

    @Override
    public boolean existe(TipoEstudio tipoEstudio) {
        List<TipoEstudio> tipoEstudios = findNamedQuery("TipoEstudio.findByNombre", "nombre", tipoEstudio.getNombre());
        return tipoEstudios.stream().anyMatch((d) -> (d.getNombre().equals(tipoEstudio.getNombre()) && !Objects.equals(tipoEstudio.getIdTipoEstudio(), d.getIdTipoEstudio())));
    }

    @Override
    public void refrescarSelected(TipoEstudio tipoEstudio) {
        TipoEstudio te;
        te = dao.find(tipoEstudio.getIdTipoEstudio());
        if (te != null) {
            tipoEstudio.setNombre(te.getNombre());
            tipoEstudio.setDescripcion(te.getDescripcion());
        }
    }
}
