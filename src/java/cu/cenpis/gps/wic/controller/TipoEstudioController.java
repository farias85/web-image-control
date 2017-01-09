package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.service.TipoEstudioService;
import cu.cenpis.gps.wic.data.entity.TipoEstudio;
import cu.cenpis.gps.wic.util.Bundle;
import cu.cenpis.gps.wic.util.JsfUtil;
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
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(tipoEstudioService);
    }

    @Override
    public void create() {
        if (validarExiste() != (null)) {
            super.create(Bundle.getString("TipoEstudioCreated"));
        }
    }

    @Override
    public void update() {
        if (validarExiste() != (null)) {
            super.update(Bundle.getString("TipoEstudioUpdated"));
        } else {
            tipoEstudioService.refrescarSelected(selected);
        }
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("TipoEstudioDeleted"));
    }

    private String validarExiste() {
        if (tipoEstudioService.existe(selected)) {
            JsfUtil.addErrorMessage(Bundle.getString("ExisteTipoEstudio"));
            return null;
        }
        return " ";
    }
}
