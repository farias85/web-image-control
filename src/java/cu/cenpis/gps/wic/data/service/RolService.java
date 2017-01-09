package cu.cenpis.gps.wic.data.service;

import cu.cenpis.gps.wic.data.entity.Rol;
import cu.cenpis.gps.wic.data.entity.Usuario;
import java.util.List;

public interface RolService extends BaseService<Rol, java.lang.Long> {

    public List<Usuario> getUsuarioList(Rol rol);

    public List<Usuario> getUsuarioListNotIn(Rol rol);

    public boolean existe(Rol rol);

    public void refrescarSelected(Rol rol);
}
