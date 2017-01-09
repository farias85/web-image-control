package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.service.ProcedenciaService;
import cu.cenpis.gps.wic.data.entity.Procedencia;
import cu.cenpis.gps.wic.util.Bundle;
import cu.cenpis.gps.wic.util.JsfUtil;
import javax.annotation.PostConstruct;

public class ProcedenciaController extends BaseController<Procedencia, java.lang.Long> {

    private ProcedenciaService procedenciaService;

    public ProcedenciaService getProcedenciaService() {
        return procedenciaService;
    }

    public void setProcedenciaService(ProcedenciaService procedenciaService) {
        this.procedenciaService = procedenciaService;
    }

    public ProcedenciaController() {
        super(Procedencia.class);
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(procedenciaService);
    }

    @Override
    public void create() {
        if (validarExiste() != (null)) {
            super.create(Bundle.getString("ProcedenciaCreated"));
        }
    }

    @Override
    public void update() {
        //super.update(Bundle.getString("ProcedenciaUpdated"));
        if (validarExiste() != (null)) {
            super.update(Bundle.getString("ProcedenciaUpdated"));
        } else {
            procedenciaService.refrescarSelected(selected);
        }
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("ProcedenciaDeleted"));
    }

    private String validarExiste() {
        if (procedenciaService.existe(selected)) {
            JsfUtil.addErrorMessage(Bundle.getString("ExisteProcedencia"));
            return null;
        }
        return " ";
    }
}
