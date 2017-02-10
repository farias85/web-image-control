package cu.cenpis.gps.wic.data.dao.impl;

import cu.cenpis.gps.wic.data.dao.ModalidadDAO;
import cu.cenpis.gps.wic.data.entity.Modalidad;
import org.springframework.stereotype.Repository;

@Repository
public class ModalidadDAOImpl extends AbstractHibernateDAO<Modalidad, java.lang.Long>
        implements ModalidadDAO {

    private static final long serialVersionUID = 1L;

    public ModalidadDAOImpl() {
        super(Modalidad.class);
        System.out.println("ModalidadDAOImpl");
    }
}
