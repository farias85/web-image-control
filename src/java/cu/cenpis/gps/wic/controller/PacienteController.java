package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.entity.Estudio;
import cu.cenpis.gps.wic.data.service.PacienteService;
import cu.cenpis.gps.wic.data.entity.Paciente;
import cu.cenpis.gps.wic.util.Bundle;
import cu.cenpis.gps.wic.util.JsfUtil;
import javax.annotation.PostConstruct;
import java.util.List;

public class PacienteController extends BaseController<Paciente, java.lang.Long> {

    private PacienteService pacienteService;

    public PacienteService getPacienteService() {
        return pacienteService;
    }

    public void setPacienteService(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public PacienteController() {
        super(Paciente.class);
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(pacienteService);
    }

    @Override
    public void create() {
        if (validarExiste() != (null)) {
            super.create(Bundle.getString("PacienteCreated"));
        }
    }

    @Override
    public void update() {
        if (validarExiste() != (null)) {
            super.update(Bundle.getString("PacienteUpdated"));
        }

        EstudioController estudioController = JsfUtil.getController(EstudioController.class);

        List<Estudio> list = pacienteService.findEstudiosByPaciente(selected);
        for (int i = 0; i < list.size(); i++) {
            estudioController.refreshItem(list.get(i));
        }
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("PacienteDeleted"));
    }

    @Override
    public String actionPrepareEdit() {       
        return super.actionPrepareEdit(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actionCancel() {        
        return super.actionCancel(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actionCreate() {
        return (validarExiste() != (null)) ? super.actionCreate() : null;
        //return super.actionCreate();
    }

    @Override
    public String actionEdit() {
        return (validarExiste() != (null)) ? super.actionEdit() : null;
        //return super.actionEdit();
    }

    private String validarExiste() {
        if (pacienteService.existe(selected)) {
            JsfUtil.addErrorMessage(Bundle.getString("ExistePaciente"));
            return null;
        }
        return " ";
    }
}
