package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.service.MedicoService;
import cu.cenpis.gps.wic.data.entity.Medico;
import cu.cenpis.gps.wic.util.Bundle;
import cu.cenpis.gps.wic.util.JsfUtil;
import javax.annotation.PostConstruct;

public class MedicoController extends BaseController<Medico, java.lang.Long> {

    private MedicoService medicoService;

    public MedicoService getMedicoService() {
        return medicoService;
    }

    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    public MedicoController() {
        super(Medico.class);
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(medicoService);
    }

    @Override
    public void create() {
        if (validarExiste() != (null)) {
            super.create(Bundle.getString("MedicoCreated"));
        }
    }

    @Override
    public void update() {
        if (validarExiste() != (null)) {
            super.update(Bundle.getString("MedicoUpdated"));
        }

    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("MedicoDeleted"));
    }

    private String validarExiste() {
        if (medicoService.existe(selected)) {
            JsfUtil.addErrorMessage(Bundle.getString("ExisteMedico"));
            return null;
        }
        return " ";
    }
}
