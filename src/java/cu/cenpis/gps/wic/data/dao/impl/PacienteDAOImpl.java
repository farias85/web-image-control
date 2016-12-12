package cu.cenpis.gps.wic.data.dao.impl;

import cu.cenpis.gps.wic.data.dao.PacienteDAO;
import cu.cenpis.gps.wic.data.entity.Paciente;
import org.springframework.stereotype.Repository;

@Repository
public class PacienteDAOImpl extends AbstractHibernateDAO<Paciente, java.lang.Long>
        implements PacienteDAO {

    private static final long serialVersionUID = 1L;

    public PacienteDAOImpl() {
        super(Paciente.class);
        System.out.println("PacienteDAOImpl");
    }

}
