package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.service.RolService;
import cu.cenpis.gps.wic.data.entity.Rol;
import cu.cenpis.gps.wic.data.dao.RolDAO;
import cu.cenpis.gps.wic.data.dao.UsuarioDAO;
import cu.cenpis.gps.wic.data.entity.Usuario;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolServiceImpl extends BaseServiceImpl<Rol, java.lang.Long, RolDAO>
        implements RolService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UsuarioDAO usuarioDAO;

    public RolServiceImpl() {
        System.out.println("RolServiceImpl()");
    }

    @Override
    public List<Usuario> getUsuarioList(Rol rol) {
        return usuarioDAO.findNamedQuery("Usuario.findByIdRol", "idRol", rol.getIdRol());
    }

    @Override
    public List<Usuario> getUsuarioListNotIn(Rol rol) {
        return usuarioDAO.findNamedQuery("Usuario.findByIdRolNotIn", "idRol", rol.getIdRol());
    }

    @Override
    public boolean existe(Rol rol) {
        List<Rol> roles = findNamedQuery("Rol.findByNombre", "nombre", rol.getNombre());
        return roles.stream().anyMatch((d) -> (d.getNombre().equals(rol.getNombre()) && !Objects.equals(rol.getIdRol(), d.getIdRol())));
    }

    @Override
    public void refrescarSelected(Rol rol) {
        Rol r;
        r = dao.find(rol.getIdRol());
        if (r != null) {
            rol.setNombre(r.getNombre());
            rol.setDescripcion(r.getDescripcion());
        }
    }
}
