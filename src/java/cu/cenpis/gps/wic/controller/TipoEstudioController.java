package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.service.TipoEstudioService;
import cu.cenpis.gps.wic.data.entity.TipoEstudio;
import cu.cenpis.gps.wic.util.Bundle;
import javax.annotation.PostConstruct;

public class TipoEstudioController extends BaseController<TipoEstudio, java.lang.Long> {

    private TipoEstudioService tipoEstudioService;

    public TipoEstudioService getTipoEstudioService() {
        return tipoEstudioService;
    }

    public void setTipoEstudioService(TipoEstudioService tipoEstudioService) {
        this.tipoEstudioService = tipoEstudioService;
    }

    public TipoEstudioController() {
        super(TipoEstudio.class);
        setQueryMethod("getNombre");
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(tipoEstudioService);
    }

    @Override
    public void create() {
        super.create(Bundle.getString("TipoEstudioCreated"));
    }

    @Override
    public void update() {
        super.update(Bundle.getString("TipoEstudioUpdated"));
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("TipoEstudioDeleted"));
    }
}

