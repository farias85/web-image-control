package cu.cenpis.gps.wic.data.service;

import cu.cenpis.gps.wic.data.entity.TipoEstudio;

public interface TipoEstudioService extends BaseService<TipoEstudio, java.lang.Long> {

    public boolean existe(TipoEstudio tipoEstudio);

    public void refrescarSelected(TipoEstudio tipoEstudio);
}
