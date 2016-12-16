package cu.cenpis.gps.wic.data.dao.impl;

import cu.cenpis.gps.wic.data.dao.RolDAO;
import cu.cenpis.gps.wic.data.entity.Rol;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class RolDAOImpl extends AbstractHibernateDAO<Rol, java.lang.Long>
        implements RolDAO {

    private static final long serialVersionUID = 1L;

    public RolDAOImpl() {
        super(Rol.class);
        System.out.println("RolDAOImpl");
    }

    public List<Rol> getRolListNotIn() {
        Session session = hibernateUtil.getSession();
        String queryString = "SELECT DISTINCT r FROM Rol r join r.usuarioList u WHERE u.idUsuario NOT IN (:ids)";
        Object[] os = {34L};
        Query query = session.createQuery(queryString).setParameterList("ids", os);
        return query.list();
    }
}
