package cu.cenpis.gps.wic.data.dao.impl;

import cu.cenpis.gps.wic.data.dao.EstudioDAO;
import cu.cenpis.gps.wic.data.entity.Estudio;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

@Repository
public class EstudioDAOImpl extends AbstractHibernateDAO<Estudio, java.lang.Long>
        implements EstudioDAO {

    private static final long serialVersionUID = 1L;

    public EstudioDAOImpl() {
        super(Estudio.class);
        System.out.println("EstudioDAOImpl");
    }

    @Override
    public List<Object[]> queryMultipleTables() {
        Session session = hibernateUtil.getSession();
        String queryString = "SELECT e.id_estudio, d.id_diagnostico, d.nombre, m.nombre_apellidos "
                + "FROM estudio e "
                + "INNER JOIN diagnostico d ON e.diagnostico = d.id_diagnostico "
                + "INNER JOIN medico m ON e.medico = m.id_medico "
                + "WHERE e.id_estudio > 0 "
                + "ORDER BY e.id_estudio";

        SQLQuery query = session.createSQLQuery(queryString).
                addScalar("e.id_estudio", new IntegerType()).
                addScalar("d.id_diagnostico", new IntegerType()).
                addScalar("d.nombre", new StringType()).
                addScalar("m.nombre_apellidos", new StringType());

        List<Object[]> rows = query.list();
        return rows;
    }
}
