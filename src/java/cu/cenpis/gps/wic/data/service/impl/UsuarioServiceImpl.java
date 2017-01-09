package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.dao.RolDAO;
import cu.cenpis.gps.wic.data.service.UsuarioService;
import cu.cenpis.gps.wic.data.entity.Usuario;
import cu.cenpis.gps.wic.data.dao.UsuarioDAO;
import cu.cenpis.gps.wic.data.entity.Rol;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
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
            if (u.getContrasenna().equalsIgnoreCase(usuario.getContrasenna())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Usuario userAuthentication(Usuario usuario) {
        return dao.userAuthentication(usuario);
    }

    @Override
    public List<Rol> getRolList(Usuario usuario) {
        return rolDAO.findNamedQuery("Rol.findByIdUsuario", "idUsuario", usuario.getIdUsuario());
    }

    @Override
    public List<Rol> getRolListNotIn(Usuario usuario) {
        return rolDAO.findNamedQuery("Rol.findByIdUsuarioNotIn", "idUsuario", usuario.getIdUsuario());
    }

    @Override
    public boolean existe(Usuario usuario) {
        List<Usuario> usuarios = findNamedQuery("Usuario.findByEmail", "email", usuario.getEmail());
        return usuarios.stream().anyMatch((d) -> (d.getEmail().equals(usuario.getEmail()) && !Objects.equals(usuario.getIdUsuario(), d.getIdUsuario())));
    }

    @Override
    public void refrescarSelected(Usuario usuario) {
         Usuario u;
        u = dao.find(usuario.getIdUsuario());
        if (u != null) {
            usuario.setNombre(u.getNombre());
            usuario.setApellidos(u.getApellidos());
            usuario.setEmail(u.getEmail());
            usuario.setContrasenna(u.getContrasenna());
        }
    }
}
