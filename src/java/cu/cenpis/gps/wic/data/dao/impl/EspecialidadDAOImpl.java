package cu.cenpis.gps.wic.data.dao.impl;

import cu.cenpis.gps.wic.data.dao.EspecialidadDAO;
import cu.cenpis.gps.wic.data.entity.Especialidad;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

@Repository
public class EspecialidadDAOImpl extends AbstractHibernateDAO<Especialidad, java.lang.Long>
        implements EspecialidadDAO {

    private static final long serialVersionUID = 1L;

    public EspecialidadDAOImpl() {
        super(Especialidad.class);
        System.out.println("EspecialidadDAOImpl");
    }

    @Override
    public List<Object[]> findNames() {
        Session session = hibernateUtil.getSession();
        String queryString = "SELECT e.nombre "
                + "FROM espacialidad e "
                + "ORDER BY e.nombre";

        SQLQuery query = session.createSQLQuery(queryString).
                addScalar("e.nombre", new StringType());

        List<Object[]> rows = query.list();
        return rows;
    }
}
