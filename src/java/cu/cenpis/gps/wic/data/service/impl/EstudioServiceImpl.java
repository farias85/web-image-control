package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.controller.DiagnosticoController;
import cu.cenpis.gps.wic.controller.EspecialidadController;
import cu.cenpis.gps.wic.controller.MedicoController;
import cu.cenpis.gps.wic.controller.PacienteController;
import cu.cenpis.gps.wic.controller.ProcedenciaController;
import cu.cenpis.gps.wic.controller.TipoEstudioController;
import cu.cenpis.gps.wic.data.dao.DiagnosticoDAO;
import cu.cenpis.gps.wic.data.dao.EspecialidadDAO;
import cu.cenpis.gps.wic.data.service.EstudioService;
import cu.cenpis.gps.wic.data.entity.Estudio;
import cu.cenpis.gps.wic.data.dao.EstudioDAO;
import cu.cenpis.gps.wic.data.dao.MedicoDAO;
import cu.cenpis.gps.wic.data.dao.PacienteDAO;
import cu.cenpis.gps.wic.data.dao.ProcedenciaDAO;
import cu.cenpis.gps.wic.data.dao.TipoEstudioDAO;
import cu.cenpis.gps.wic.data.dao.UsuarioDAO;
import cu.cenpis.gps.wic.data.entity.Paciente;
import cu.cenpis.gps.wic.util.JsfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstudioServiceImpl extends BaseServiceImpl<Estudio, java.lang.Long, EstudioDAO>
        implements EstudioService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PacienteDAO pacienteDAO;

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private EspecialidadDAO especialidadDAO;

    @Autowired
    private MedicoDAO medicoDAO;

    @Autowired
    private ProcedenciaDAO procedenciaDAO;

    @Autowired
    private TipoEstudioDAO tipoEstudioDAO;

    @Autowired
    private DiagnosticoDAO diagnosticoDAO;

    public EstudioServiceImpl() {
        System.out.println("EstudioServiceImpl()");
    }

    @Override
    public Long create(Estudio object) {

        if (object.getPaciente().getIdPaciente() == null) {
            pacienteDAO.create(object.getPaciente());
            PacienteController controller = JsfUtil.getController(PacienteController.class);
            controller.setItems(null);
            controller.setFiltered(null);
        }
        if (object.getEspecialidad().getIdEspacialidad() == null) {
            especialidadDAO.create(object.getEspecialidad());
            EspecialidadController controller = JsfUtil.getController(EspecialidadController.class);
            controller.setItems(null);
            controller.setFiltered(null);
        }
        if (object.getMedico().getIdMedico() == null) {
            medicoDAO.create(object.getMedico());
            MedicoController controller = JsfUtil.getController(MedicoController.class);
            controller.setItems(null);
            controller.setFiltered(null);
        }
        if (object.getProcedencia().getIdProcedencia() == null) {
            procedenciaDAO.create(object.getProcedencia());
            ProcedenciaController controller = JsfUtil.getController(ProcedenciaController.class);
            controller.setItems(null);
            controller.setFiltered(null);
        }
        if (object.getTipoEstudio().getIdTipoEstudio() == null) {
            tipoEstudioDAO.create(object.getTipoEstudio());
            TipoEstudioController controller = JsfUtil.getController(TipoEstudioController.class);
            controller.setItems(null);
            controller.setFiltered(null);
        }
        if (object.getDiagnostico().getIdDiagnostico() == null) {
            diagnosticoDAO.create(object.getDiagnostico());
            DiagnosticoController controller = JsfUtil.getController(DiagnosticoController.class);
            controller.setItems(null);
            controller.setFiltered(null);
        }

        if (object.getUsuario() == null || object.getUsuario().getIdUsuario() == null) {
            object.setUsuario(usuarioDAO.findAll().get(0));
        }
        return super.create(object); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estudio edit(Estudio object) {
        if (object.getPaciente().getIdPaciente() == null) {
            pacienteDAO.create(object.getPaciente());
        } else {
            pacienteDAO.edit(object.getPaciente());
        }
        return super.edit(object); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente findPacienteByHistoriaClinica(String hc) {
        List<Paciente> list = pacienteDAO.findNamedQuery("Paciente.findByHistoriaClinica", "historiaClinica", hc);
        return list.size() > 0 ? list.get(0) : null;
    }
}
