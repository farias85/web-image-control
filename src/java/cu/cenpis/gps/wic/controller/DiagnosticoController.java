package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.service.DiagnosticoService;
import cu.cenpis.gps.wic.data.entity.Diagnostico;
import cu.cenpis.gps.wic.data.entity.Estudio;
import cu.cenpis.gps.wic.util.Bundle;
import cu.cenpis.gps.wic.util.JsfUtil;
import javax.annotation.PostConstruct;
import java.util.List;

public class DiagnosticoController extends BaseController<Diagnostico, java.lang.Long> {

    private DiagnosticoService diagnosticoService;

    public DiagnosticoService getDiagnosticoService() {
        return diagnosticoService;
    }

    public void setDiagnosticoService(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    public DiagnosticoController() {
        super(Diagnostico.class);
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(diagnosticoService);
    }

    @Override
    public void create() {
        if (validarExiste() != (null)) {
            super.create(Bundle.getString("DiagnosticoCreated"));
        }
    }

    @Override
    public void update() {
        if (validarExiste() != (null)) {
            super.update(Bundle.getString("DiagnosticoUpdated"));
        } else {
            diagnosticoService.refrescarSelected(selected);
        }
    }

    @Override
    public void destroy() {

        EstudioController estudioController = JsfUtil.getController(EstudioController.class);

        //EstudioController estudioController = (EstudioController)findController(EstudioController.class);
        List<Estudio> list = diagnosticoService.findEstudiosByDiagnostico(selected);
        for (Estudio var : list) {
            estudioController.getItems().remove(var);
        }
        super.destroy(Bundle.getString("DiagnosticoDeleted"));
    }

    public String onDetailCancel() {
        return "index.jsf";
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
            diagnosticoService.refrescarSelected(selected);
            return null;
        }
    }

    private String validarExiste() {
        if (diagnosticoService.existe(selected)) {
            JsfUtil.addErrorMessage(Bundle.getString("ExisteDiagnostico"));
            return null;
        }
        return " ";
    }
}
