package cu.cenpis.gps.wic.data.dao.impl;

import cu.cenpis.gps.wic.data.dao.UsuarioDAO;
import cu.cenpis.gps.wic.data.entity.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOImpl extends AbstractHibernateDAO<Usuario, java.lang.Long>
        implements UsuarioDAO {

    private static final long serialVersionUID = 1L;

    public UsuarioDAOImpl() {
        super(Usuario.class);
        System.out.println("UsuarioDAOImpl");
    }

}
