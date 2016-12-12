package cu.cenpis.gps.wic.data.dao.impl;

import cu.cenpis.gps.wic.data.dao.ProcedenciaDAO;
import cu.cenpis.gps.wic.data.entity.Procedencia;
import org.springframework.stereotype.Repository;

@Repository
public class ProcedenciaDAOImpl extends AbstractHibernateDAO<Procedencia, java.lang.Long>
        implements ProcedenciaDAO {

    private static final long serialVersionUID = 1L;

    public ProcedenciaDAOImpl() {
        super(Procedencia.class);
        System.out.println("ProcedenciaDAOImpl");
    }

}
