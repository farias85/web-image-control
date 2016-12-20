package cu.cenpis.gps.wic.data.dao.impl;

import cu.cenpis.gps.wic.data.dao.UsuarioDAO;
import cu.cenpis.gps.wic.data.entity.Usuario;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOImpl extends AbstractHibernateDAO<Usuario, java.lang.Long>
        implements UsuarioDAO {

    private static final long serialVersionUID = 1L;

    public UsuarioDAOImpl() {
        super(Usuario.class);
        System.out.println("UsuarioDAOImpl");
    }

    @Override
    public Usuario userAuthentication(Usuario u) {
        Usuario result = (Usuario) (hibernateUtil.getSession().
                getNamedQuery("Usuario.findByEmail").
                setParameter("email", u.getEmail()).
                uniqueResult());

        Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, u.getEmail());
        Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, result.getEmail());

        Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, u.getContrasenna());
        Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, result.getContrasenna());
        
        return result;
    }
}
