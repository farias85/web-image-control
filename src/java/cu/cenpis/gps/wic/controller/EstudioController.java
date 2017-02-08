package cu.cenpis.gps.wic.controller;

import cu.cenpis.gps.wic.data.entity.Diagnostico;
import cu.cenpis.gps.wic.data.entity.Especialidad;
import cu.cenpis.gps.wic.data.service.EstudioService;
import cu.cenpis.gps.wic.data.entity.Estudio;
import cu.cenpis.gps.wic.data.entity.Medico;
import cu.cenpis.gps.wic.data.entity.Paciente;
import cu.cenpis.gps.wic.data.entity.Procedencia;
import cu.cenpis.gps.wic.data.entity.TipoEstudio;
import cu.cenpis.gps.wic.util.Bundle;
import cu.cenpis.gps.wic.util.JsfUtil;
import javax.annotation.PostConstruct;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;

public class EstudioController extends BaseController<Estudio, java.lang.Long> {

    private EstudioService estudioService;

    public EstudioService getEstudioService() {
        return estudioService;
    }

    public void setEstudioService(EstudioService estudioService) {
        this.estudioService = estudioService;
    }

    public EstudioController() {
        super(Estudio.class);
    }

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(estudioService);
        createBarModel();
    }

    @Override
    public void create() {
        super.create(Bundle.getString("EstudioCreated"));
    }

    @Override
    public void update() {
        super.update(Bundle.getString("EstudioUpdated"));
    }

    @Override
    public void destroy() {
        super.destroy(Bundle.getString("EstudioDeleted"));
    }

    @Override
    protected void initializeEmbeddableKey() {
        selected.setPaciente(new Paciente());
        selected.setEspecialidad(new Especialidad());
        selected.setMedico(new Medico());
        selected.setProcedencia(new Procedencia());
        selected.setTipoEstudio(new TipoEstudio());
        selected.setDiagnostico(new Diagnostico());
        super.initializeEmbeddableKey(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setEmbeddableKeys() {

        if (selected.getEspecialidad().getIdEspacialidad() == null) {
            EspecialidadController especialidadController = JsfUtil.getController(EspecialidadController.class);
            Especialidad especialidad = especialidadController.findItemByStringMethod(selected.getEspecialidad().getNombre(),
                    especialidadController.getQueryMethod());
            if (especialidad != null) {
                selected.setEspecialidad(especialidad);
            }
        }

        if (selected.getMedico().getIdMedico() == null) {
            MedicoController medicoController = JsfUtil.getController(MedicoController.class);
            Medico medico = medicoController.findItemByStringMethod(selected.getMedico().getNombreApellidos(),
                    medicoController.getQueryMethod());
            if (medico != null) {
                selected.setMedico(medico);
            }
        }

        if (selected.getProcedencia().getIdProcedencia() == null) {
            ProcedenciaController procedenciaController = JsfUtil.getController(ProcedenciaController.class);
            Procedencia procedencia = procedenciaController.findItemByStringMethod(selected.getMedico().getNombreApellidos(),
                    procedenciaController.getQueryMethod());
            if (procedencia != null) {
                selected.setProcedencia(procedencia);
            }
        }

        if (selected.getTipoEstudio().getIdTipoEstudio() == null) {
            TipoEstudioController tipoEstudioController = JsfUtil.getController(TipoEstudioController.class);
            TipoEstudio tp = tipoEstudioController.findItemByStringMethod(selected.getTipoEstudio().getNombre(),
                    tipoEstudioController.getQueryMethod());
            if (tp != null) {
                selected.setTipoEstudio(tp);
            }
        }

        if (selected.getDiagnostico().getIdDiagnostico() == null) {
            DiagnosticoController diagnosticoController = JsfUtil.getController(DiagnosticoController.class);
            Diagnostico diagnostico = diagnosticoController.findItemByStringMethod(selected.getDiagnostico().getNombre(),
                    diagnosticoController.getQueryMethod());
            if (diagnostico != null) {
                selected.setDiagnostico(diagnostico);
            }
        }

        super.setEmbeddableKeys(); //To change body of generated methods, choose Tools | Templates.
    }

    public void findPacienteByHistoriaClinicaListener() {
        Paciente p = estudioService.findPacienteByHistoriaClinica(selected.getPaciente().getHistoriaClinica());
        if (p != null) {
            selected.setPaciente(p);
        } else {
            selected.getPaciente().setIdPaciente(null);
        }
    }

    private BarChartModel barModel;

    public BarChartModel getBarModel() {
        return barModel;
    }

    

    private void createBarModel() {        
        
         barModel  = new BarChartModel();

        ChartSeries series1 = new ChartSeries();
        series1.setLabel("Boys");
        series1.set("2014-01-01", 51);
        series1.set("2014-01-02", 22);
        series1.set("2014-01-03", 65);
        series1.set("2014-01-04", 74);
        series1.set("2014-01-05", 24);
        series1.set("2014-01-06", 51);
        
        barModel.setBarWidth(10);
        barModel.addSeries(series1);

        DateAxis axis = new DateAxis("Dates");
        //axis.setTickAngle(-50);
        
        axis.setMax("2014-02-10");
        axis.setTickFormat("%#d %b , %y");
        barModel.getAxes().put(AxisType.X, axis);

        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");

       /* Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Días");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(200);*/
    }
}
