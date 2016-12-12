package cu.cenpis.gps.wic.data.dao.impl;

import cu.cenpis.gps.wic.data.dao.TipoEstudioDAO;
import cu.cenpis.gps.wic.data.entity.TipoEstudio;
import org.springframework.stereotype.Repository;

@Repository
public class TipoEstudioDAOImpl extends AbstractHibernateDAO<TipoEstudio, java.lang.Long>
        implements TipoEstudioDAO {

    private static final long serialVersionUID = 1L;

    public TipoEstudioDAOImpl() {
        super(TipoEstudio.class);
        System.out.println("TipoEstudioDAOImpl");
    }

}
