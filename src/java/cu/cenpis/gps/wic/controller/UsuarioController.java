package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.service.UsuarioService;
import cu.cenpis.gps.wic.data.entity.Usuario;
import cu.cenpis.gps.wic.util.Bundle;
import java.util.ArrayList;
import java.util.HashSet;
import javax.annotation.PostConstruct;

public class UsuarioController extends BaseController<Usuario, java.lang.Long> {

    private UsuarioService usuarioService;

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public UsuarioController() {
        super(Usuario.class);
    }

    private RolController rolController;
    
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(usuarioService);
        rolController = getController(RolController.class);
    }

    @Override
    public void create() {
        super.create(Bundle.getString("UsuarioCreated"));
    }

    @Override
    protected void setEmbeddableKeys() {
        selected.setRolList(new HashSet<>(rolController.getFiltered()));
        super.setEmbeddableKeys(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void initializeEmbeddableKey() {

        selected.setNombre("Felipe");
        selected.setApellidos("Rdguez");
        selected.setEmail("a@a.com");
        selected.setContrasenna("psw");
        
        rolController.setFiltered(new ArrayList<>());
        super.initializeEmbeddableKey(); //To change body of generated methods, choose Tools | Templates.
    }

    public void findRolListener() {        
        rolController.setFiltered(new ArrayList<>(selected.getRolList()));
    }

    @Override
    public void update() {
        super.update(Bundle.getString("UsuarioUpdated"));
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("UsuarioDeleted"));
    }
}
