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
        super.create(Bundle.getString("PacienteCreated"));
    }

    @Override
    public void update() {
        super.update(Bundle.getString("PacienteUpdated"));
        
        EstudioController estudioController = getController(EstudioController.class);
        
        List<Estudio> list = pacienteService.findEstudiosByPaciente(selected);
        for (int i = 0; i < list.size(); i++) {
            estudioController.refreshItem(list.get(i));
        }
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("PacienteDeleted"));
    }

    private Boolean exist;

    public Boolean getExist() {
        return exist;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }

    private String hcEdit = "";

    public void findPacienteByHistoriaClinicaListener() {

        if (!hcEdit.equalsIgnoreCase(selected.getHistoriaClinica())) {
            Paciente p = pacienteService.findPacienteByHistoriaClinica(selected.getHistoriaClinica());
            exist = p != null;

            if (exist) {
                JsfUtil.addErrorMessage(Bundle.getString("HCExist"));
            }
        }
    }

    @Override
    public String actionPrepareEdit() {
        hcEdit = selected.getHistoriaClinica();
        return super.actionPrepareEdit(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actionCancel() {
        exist = false;
        return super.actionCancel(); //To change body of generated methods, choose Tools | Templates.
    }
}
