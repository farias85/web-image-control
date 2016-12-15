package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.service.RolService;
import cu.cenpis.gps.wic.data.entity.Rol;
import cu.cenpis.gps.wic.util.Bundle;
import javax.annotation.PostConstruct;

public class RolController extends BaseController<Rol, java.lang.Long> {

    private RolService rolService;

    public RolService getRolService() {
        return rolService;
    }

    public void setRolService(RolService rolService) {
        this.rolService = rolService;
    }

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
        super.create(Bundle.getString("RolCreated"));
    }

    @Override
    public void update() {
        super.update(Bundle.getString("RolUpdated"));
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("RolDeleted"));
    }
}
