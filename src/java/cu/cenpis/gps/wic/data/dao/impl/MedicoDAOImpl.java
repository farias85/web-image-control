package cu.cenpis.gps.wic.data.dao.impl;

import cu.cenpis.gps.wic.data.dao.MedicoDAO;
import cu.cenpis.gps.wic.data.entity.Medico;
import org.springframework.stereotype.Repository;

@Repository
public class MedicoDAOImpl extends AbstractHibernateDAO<Medico, java.lang.Long>
        implements MedicoDAO {

    private static final long serialVersionUID = 1L;

    public MedicoDAOImpl() {
        super(Medico.class);
        System.out.println("MedicoDAOImpl");
    }

}
