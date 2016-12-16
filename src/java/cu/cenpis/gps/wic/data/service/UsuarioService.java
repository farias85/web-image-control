package cu.cenpis.gps.wic.data.service;

import cu.cenpis.gps.wic.data.entity.Usuario;

public interface UsuarioService extends BaseService<Usuario, java.lang.Long> {

    public boolean permisoLogin(Usuario usuario);
}
