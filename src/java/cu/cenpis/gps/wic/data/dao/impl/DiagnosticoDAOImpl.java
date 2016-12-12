package cu.cenpis.gps.wic.data.dao.impl;

import cu.cenpis.gps.wic.data.dao.DiagnosticoDAO;
import cu.cenpis.gps.wic.data.entity.Diagnostico;
import org.springframework.stereotype.Repository;

@Repository
public class DiagnosticoDAOImpl extends AbstractHibernateDAO<Diagnostico, java.lang.Long>
        implements DiagnosticoDAO {

    private static final long serialVersionUID = 1L;

    public DiagnosticoDAOImpl() {
        super(Diagnostico.class);
        System.out.println("DiagnosticoDAOImpl");
    }
}
