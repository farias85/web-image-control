package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.service.ProcedenciaService;
import cu.cenpis.gps.wic.data.entity.Procedencia;
import cu.cenpis.gps.wic.util.Bundle;
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
        setQueryMethod("getNombre");
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(procedenciaService);
    }

    @Override
    public void create() {
        super.create(Bundle.getString("ProcedenciaCreated"));
    }

    @Override
    public void update() {
        super.update(Bundle.getString("ProcedenciaUpdated"));
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("ProcedenciaDeleted"));
    }
}

