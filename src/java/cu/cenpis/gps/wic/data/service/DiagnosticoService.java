package cu.cenpis.gps.wic.data.service;

import cu.cenpis.gps.wic.data.entity.Diagnostico;
import cu.cenpis.gps.wic.data.entity.Estudio;
import java.util.List;

public interface DiagnosticoService extends BaseService<Diagnostico, java.lang.Long> {

    public List<Estudio> findEstudiosByDiagnostico(Diagnostico diagnostico);
}
