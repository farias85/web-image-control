package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.dao.RolDAO;
import cu.cenpis.gps.wic.data.service.UsuarioService;
import cu.cenpis.gps.wic.data.entity.Usuario;
import cu.cenpis.gps.wic.data.dao.UsuarioDAO;
import cu.cenpis.gps.wic.data.entity.Rol;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, java.lang.Long, UsuarioDAO>
        implements UsuarioService {

    private static final long serialVersionUID = 1L;

    @Autowired
    RolDAO rolDAO;
    
    public UsuarioServiceImpl() {
        System.out.println("UsuarioServiceImpl()");
    }

    @Override
    public boolean permisoLogin(Usuario usuario) {

        List<Usuario> usuarios = findNamedQuery("Usuario.findByEmail", "email", usuario.getEmail());
        for (Usuario u : usuarios) {
            if (u.getContrasenna().equals(usuario.getContrasenna())) {
                return true;
            } /*else {
                return false;
            }*/
        }
        return false;
    }

    @Override
    public List<Rol> getRolList(Usuario usuario) {
        return rolDAO.findNamedQuery("Rol.findByIdUsuario", "idUsuario", usuario.getIdUsuario());        
    }

    @Override
    public List<Rol> getRolListNotIn(Usuario usuario) {
        return rolDAO.findNamedQuery("Rol.findByIdUsuarioNotIn", "idUsuario", usuario.getIdUsuario());
    }
}
