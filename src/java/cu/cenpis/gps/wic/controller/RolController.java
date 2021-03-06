package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.service.RolService;
import cu.cenpis.gps.wic.data.entity.Rol;
import cu.cenpis.gps.wic.data.entity.Usuario;
import cu.cenpis.gps.wic.util.Bundle;
import cu.cenpis.gps.wic.util.JsfUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.model.DualListModel;

public class RolController extends BaseController<Rol, java.lang.Long> {

    private RolService rolService;

    private DualListModel<Usuario> model;

    public RolController() {
        super(Rol.class);
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(rolService);
    }

    @Override
    public void create() {
        if (validarExiste() != (null)) {
            super.create(Bundle.getString("RolCreated"));
        }
    }

    @Override
    public void update() {
        //super.update(Bundle.getString("RolUpdated"));
        if (validarExiste() != (null)) {
            super.update(Bundle.getString("RolUpdated"));
        } else {
            rolService.refrescarSelected(selected);
        }
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("RolDeleted"));
    }

    @Override
    protected void setEmbeddableKeys() {
        if (model != null) {
            selected.setUsuarioList(new HashSet<>(model.getTarget()));
        }

//        UsuarioController usuarioController = JsfUtil.getController(UsuarioController.class);
//        selected.setUsuarioList(new HashSet<>(usuarioController.getFiltered()));
        super.setEmbeddableKeys(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void initializeEmbeddableKey() {

//        UsuarioController usuarioController = JsfUtil.getController(UsuarioController.class);
//        usuarioController.setFiltered(new ArrayList<>());
        UsuarioController usuarioController = JsfUtil.getController(UsuarioController.class);
        model = new DualListModel<>(usuarioController.getItems(), new ArrayList<>());
        super.initializeEmbeddableKey(); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getEditRendered() {
        if (selected == null) {
            return false;
        }

        List<Usuario> target = rolService.getUsuarioList(selected);
        List<Usuario> source = rolService.getUsuarioListNotIn(selected);
        model = new DualListModel<>(source, target);

//        UsuarioController usuarioController = JsfUtil.getController(UsuarioController.class);
//        List<Usuario> ul = rolService.getUsuarioList(selected);
//        usuarioController.setFiltered(ul);
        return true;
    }

    public RolService getRolService() {
        return rolService;
    }

    public void setRolService(RolService rolService) {
        this.rolService = rolService;
    }

    public DualListModel<Usuario> getModel() {
        if (model == null) {
            UsuarioController usuarioController = JsfUtil.getController(UsuarioController.class);
            model = new DualListModel<>(
                    new ArrayList<>(usuarioController.getItems()),
                    new ArrayList<Usuario>());
        }
        return model;
    }

    public void setModel(DualListModel<Usuario> model) {
        this.model = model;
    }

    private String validarExiste() {
        if (rolService.existe(selected)) {
            JsfUtil.addErrorMessage(Bundle.getString("ExisteRol"));
            return null;
        }
        return " ";
    }
}

//                        <p:outputLabel value="Usuarios" for="usuarios" />
//                        <p:autoComplete id="usuarios" multiple="true" value="#{usuarioController.filtered}" completeMethod="#{usuarioController.autoCompleteQueryItems}"
//                                        var="usuario" itemLabel="#{usuario.nombre}" itemValue="#{usuario}" forceSelection="true" required="true"
//                                        requiredMessage="#{bundle.RolUsuarioNotEmpty}">
//                            <o:converter converterId="omnifaces.ListConverter" list="#{usuarioController.items}" />
//                            <p:column>
//                                <h:outputText value="#{usuario.nombre}" />
//                            </p:column>
//                            <p:column>
//                                <h:outputText value="#{usuario.apellidos}" />
//                            </p:column>
//                        </p:autoComplete>
//                        <p:pickList id="usuarios" value="#{rolController.model}" var="usuario" itemValue="#{usuario}" itemLabel="#{usuario.nombre} #{usuario.apellidos} #{usuario.email}"
//                                    required="true" requiredMessage="#{bundle.RolUsuarioNotEmpty}">
//                            <o:converter converterId="omnifaces.ListConverter" list="#{usuarioController.items}" />
//                        </p:pickList>
