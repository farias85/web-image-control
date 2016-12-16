package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.service.UsuarioService;
import cu.cenpis.gps.wic.data.entity.Usuario;
import cu.cenpis.gps.wic.data.dao.UsuarioDAO;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, java.lang.Long, UsuarioDAO>
        implements UsuarioService {

    private static final long serialVersionUID = 1L;

    public UsuarioServiceImpl() {
        System.out.println("UsuarioServiceImpl()");
    }

    @Override
    public boolean permisoLogin(Usuario usuario) {

        List<Usuario> usuarios = findNamedQuery("Usuario.findByEmail", "email", usuario.getEmail());
        for (Usuario u : usuarios) {
            if (u.getContrasenna().equals(usuario.getContrasenna())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
