package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.entity.Modalidad;
import cu.cenpis.gps.wic.data.service.ModalidadService;
import cu.cenpis.gps.wic.util.Bundle;
import javax.annotation.PostConstruct;

public class ModalidadController extends BaseController<Modalidad, java.lang.Long> {

    private ModalidadService modalidadService;

    public ModalidadService getModalidadService() {
        return modalidadService;
    }

    public void setModalidadService(ModalidadService modalidadService) {
        this.modalidadService = modalidadService;
    }

    public ModalidadController() {
        super(Modalidad.class);
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(modalidadService);
    }

    @Override
    public void create() {
        super.create(Bundle.getString("ModalidadCreated"));
    }

    @Override
    public void update() {
        super.update(Bundle.getString("ModalidadUpdated"));
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("ModalidadDeleted"));
    }
}
