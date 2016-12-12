package cu.cenpis.gps.wic.data.dao.impl;

import cu.cenpis.gps.wic.data.dao.RolDAO;
import cu.cenpis.gps.wic.data.entity.Rol;
import org.springframework.stereotype.Repository;

@Repository
public class RolDAOImpl extends AbstractHibernateDAO<Rol, java.lang.Long>
        implements RolDAO {

    private static final long serialVersionUID = 1L;

    public RolDAOImpl() {
        super(Rol.class);
        System.out.println("RolDAOImpl");
    }

}
