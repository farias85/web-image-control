package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.service.EspecialidadService;
import cu.cenpis.gps.wic.data.entity.Especialidad;
import cu.cenpis.gps.wic.util.Bundle;
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
        setQueryMethod("getNombre");
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(especialidadService);
    }

    @Override
    public void create() {
        super.create(Bundle.getString("EspecialidadCreated"));
    }

    @Override
    public void update() {
        super.update(Bundle.getString("EspecialidadUpdated"));
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("EspecialidadDeleted"));
    }

}
