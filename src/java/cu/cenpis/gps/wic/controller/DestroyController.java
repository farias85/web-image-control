/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Created by Felipe Rodriguez Arias <ucifarias@gmail.com>.
 */
package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.util.JsfUtil;
import java.io.Serializable;

/**
 *
 * @author farias-i5
 */
public class DestroyController implements Serializable {

    public void destroySession() {
        
        destroyVars(DiagnosticoController.class);
        destroyVars(EspecialidadController.class);
        destroyVars(EstudioController.class);
        destroyVars(MedicoController.class);
        destroyVars(PacienteController.class);
        destroyVars(ProcedenciaController.class);
        destroyVars(RolController.class);
        destroyVars(TipoEstudioController.class);
        destroyVars(UsuarioController.class);
        
        UsuarioController uc = JsfUtil.getController(UsuarioController.class);
        uc.setActiveUser(null);
    }

    private void destroyVars(Class<? extends BaseController> type) {
        BaseController controller = JsfUtil.getController(type);
        controller.setItems(null);
        controller.setFiltered(null);
    }
}
