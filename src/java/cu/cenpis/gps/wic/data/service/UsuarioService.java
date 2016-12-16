package cu.cenpis.gps.wic.data.service;

import cu.cenpis.gps.wic.data.entity.Rol;
import cu.cenpis.gps.wic.data.entity.Usuario;
import java.util.List;

public interface UsuarioService extends BaseService<Usuario, java.lang.Long> {

    public boolean permisoLogin(Usuario usuario);

    public List<Rol> getRolList(Usuario usuario);

    public List<Rol> getRolListNotIn(Usuario usuario);
}
