/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.util.JsfUtil;
import java.io.Serializable;

/**
 *
 * @author farias-i5
 */
public class DestroyController implements Serializable {

    public String destroySession() {
        
        destroyVars(DiagnosticoController.class);
        destroyVars(EspecialidadController.class);
        destroyVars(EstudioController.class);
        destroyVars(MedicoController.class);
        destroyVars(PacienteController.class);
        destroyVars(ProcedenciaController.class);
        destroyVars(RolController.class);
        destroyVars(TipoEstudioController.class);
        destroyVars(UsuarioController.class);
        
        return "index.jsf";
    }

    private void destroyVars(Class<? extends BaseController> type) {
        BaseController controller = JsfUtil.getController(type);
        controller.setItems(null);
        controller.setFiltered(null);
    }
}
