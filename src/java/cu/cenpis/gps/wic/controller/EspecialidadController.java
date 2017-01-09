package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.service.EspecialidadService;
import cu.cenpis.gps.wic.data.entity.Especialidad;
import cu.cenpis.gps.wic.util.Bundle;
import cu.cenpis.gps.wic.util.JsfUtil;
import javax.annotation.PostConstruct;

public class EspecialidadController extends BaseController<Especialidad, java.lang.Long> {

    private EspecialidadService especialidadService;

    public EspecialidadService getEspecialidadService() {
        return especialidadService;
    }

    public void setEspecialidadService(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    public EspecialidadController() {
        super(Especialidad.class);
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(especialidadService);
    }

    @Override
    public void create() {
        if (validarExiste() != (null)) {
            super.create(Bundle.getString("EspecialidadCreated"));
        }
    }

    @Override
    public void update() {
        if (validarExiste() != (null)) {
            super.update(Bundle.getString("EspecialidadUpdated"));
        } else {
            especialidadService.refrescarSelected(selected);
        }
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("EspecialidadDeleted"));
    }

    @Override
    public String actionCreate() {
        return (validarExiste() != (null)) ? super.actionCreate() : null;
    }

    @Override
    public String actionEdit() {
        //return (validarExiste() != (null)) ? super.actionEdit() : null; 
        if (validarExiste() != (null)) {
            return super.actionEdit();
        } else {
            especialidadService.refrescarSelected(selected);
            return null;
        }
    }

    private String validarExiste() {
        if (especialidadService.existe(selected)) {
            JsfUtil.addErrorMessage(Bundle.getString("ExisteEspecialidad"));
            return null;
        }
        return " ";
    }

}
