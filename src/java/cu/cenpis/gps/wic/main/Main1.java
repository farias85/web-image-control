/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.cenpis.gps.wic.main;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import cu.cenpis.gps.wic.controller.BaseController;
import cu.cenpis.gps.wic.controller.ProcedenciaController;
import cu.cenpis.gps.wic.data.dao.DiagnosticoDAO;
import cu.cenpis.gps.wic.data.entity.Diagnostico;
import cu.cenpis.gps.wic.data.entity.Especialidad;
import cu.cenpis.gps.wic.data.entity.Estudio;
import cu.cenpis.gps.wic.data.entity.Medico;
import cu.cenpis.gps.wic.data.entity.Paciente;
import cu.cenpis.gps.wic.data.entity.Procedencia;
import cu.cenpis.gps.wic.data.entity.Rol;
import cu.cenpis.gps.wic.data.entity.TipoEstudio;
import cu.cenpis.gps.wic.data.entity.Usuario;
import cu.cenpis.gps.wic.data.service.DiagnosticoService;
import cu.cenpis.gps.wic.data.service.EspecialidadService;
import cu.cenpis.gps.wic.data.service.EstudioService;
import cu.cenpis.gps.wic.data.service.MedicoService;
import cu.cenpis.gps.wic.data.service.PacienteService;
import cu.cenpis.gps.wic.data.service.ProcedenciaService;
import cu.cenpis.gps.wic.data.service.RolService;
import cu.cenpis.gps.wic.data.service.TipoEstudioService;
import cu.cenpis.gps.wic.data.service.UsuarioService;
import cu.cenpis.gps.wic.util.Util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author farias-i5
 */
public class Main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ApplicationContext context = new ClassPathXmlApplicationContext("cu/cenpis/gps/wic/config/mvc-dispatcher-servlet.xml");

        DiagnosticoService diagnosticoService = (DiagnosticoService) context.getBean("diagnosticoServiceImpl");
        EspecialidadService especialidadService = (EspecialidadService) context.getBean("especialidadServiceImpl");
        EstudioService estudioService = (EstudioService) context.getBean("estudioServiceImpl");
        MedicoService medicoService = (MedicoService) context.getBean("medicoServiceImpl");
        PacienteService pacienteService = (PacienteService) context.getBean("pacienteServiceImpl");
        ProcedenciaService procedenciaService = (ProcedenciaService) context.getBean("procedenciaServiceImpl");
        RolService rolService = (RolService) context.getBean("rolServiceImpl");
        TipoEstudioService tipoEstudioService = (TipoEstudioService) context.getBean("tipoEstudioServiceImpl");
        UsuarioService usuarioService = (UsuarioService) context.getBean("usuarioServiceImpl");
        List<Diagnostico> list = diagnosticoService.findNamedQuery("Diagnostico.findAll");

//        for (Diagnostico d : list) {
//            System.err.println(d.getNombre());
//        }
//        Diagnostico diagnostico = new Diagnostico(1L, "Diagnostico1");
//        diagnosticoService.create(diagnostico);
//        Diagnostico diagnostico = diagnosticoService.find(1);
//        Especialidad especialidad = new Especialidad(1L, "Esta es la especialidad");
//        especialidadService.create(especialidad);
//
//        Medico medico = new Medico(1L, "Roberto Estadella");
//        medicoService.create(medico);
//
//        Paciente paciente = new Paciente(Long.MIN_VALUE, "HC-850511", "Paciente", "Apellidos", 34, true);
//        pacienteService.create(paciente);
//
//        Procedencia procedencia = new Procedencia(Long.MIN_VALUE, "Esta es la Procedencia");
//        procedenciaService.create(procedencia);
//
//        TipoEstudio tipoEstudio = new TipoEstudio(Long.MIN_VALUE, "Tipo Estudio X");
//        tipoEstudioService.create(tipoEstudio);
//
//        Usuario usuario = new Usuario(Long.MIN_VALUE, "Usuario1", "Rodriguez", "farias@uo.edu.cu", "password");
//        usuarioService.create(usuario);
//
//        Estudio estudio = new Estudio(50, new Date(), "Esta es mi impresión", true,
//                diagnostico, especialidad, medico, paciente, procedencia, tipoEstudio, usuario);
//        estudioService.create(estudio);        
        // TODO org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: 
        // TODO cu.cenpis.gps.wic.entity.Diagnostico.estudioList, could not initialize proxy - no Session
        // TODO List<Estudio> listE = diagnostico.getEstudioList(); 
//        List<Estudio> listE = estudioService.findAll();
//        for (Estudio var : listE) {
//            System.err.println(var.getRmiId());
//        }
//        Estudio estudio = estudioService.find(2L);
//        System.err.println(estudio.getDiagnostico());
//        List<Object[]> list2 = estudioService.queryMultipleTables();
//
//        for (Object[] row : list2) {
//            StringBuilder sb = new StringBuilder();
//            sb.append(row[0]);
//            sb.append(" - ");
//            sb.append(row[1]);
//            sb.append(" - ");
//            sb.append(row[2]);
//            sb.append(" - ");
//            sb.append(row[3]);
//            System.out.println(sb.toString());
//        }
//        Medico medico = new Medico();
//        medico.setNombreApellidos("%fel%");
//        Estudio estudio = new Estudio();
//        estudio.setMedico(medico);
//        estudio.setImpresionDiagnostica("%seg%");
//        estudio.setPositivo(true);
//        List<Estudio> list3 = estudioService.findByExample(estudio);
//
//        System.err.println("COUNT -> " + list3.size());
//        for (Estudio var : list3) {
//            System.err.println(var.getMedico().getNombreApellidos());
//        }
        //muchos a muchos insertando desde el usuario
//        Rol rol1 = rolService.find(1L);
//        Rol rol2 = rolService.find(2L);
//        List<Rol> rolList = new ArrayList<>();
//        rolList.add(rol1);
//        rolList.add(rol2);
//        
//        Usuario usuario = usuarioService.find(1L);
//        usuario.setRolList(rolList);
//        usuarioService.edit(usuario);
//        Usuario usuario = usuarioService.find(2L);
//        Rol rol3 = rolService.find(3L);
//        usuario.getRolList().add(rol3);
//        usuarioService.edit(usuario);
//        for (Rol value : usuario.getRolList()) {
//            System.out.println(value.getNombre());
//        }
        //muchos a muchos insertando desde el rol (si pincha)
//        Usuario u1 = usuarioService.find(1L);
//        Usuario u2 = usuarioService.find(2L);
//        List<Usuario> uList = new ArrayList<>();
//        uList.add(u1);
//        uList.add(u2);
//
//        Rol rol = rolService.find(1L);
//        rol.setUsuarioList(uList);
//        rolService.edit(rol);
//        Rol rol = rolService.find(1L);
//        for (Diagnostico list1 : list) {
//            
//        }
        Usuario usuario = usuarioService.find(23L);
        //List<Rol> all = rolService.findAll();
        System.out.println("ESTOS SON LOS ROLES...");
        for (Rol value : usuario.getRolList()) {
            System.out.println(value.getNombre());
        }
        
//        List<Rol> rl = usuario.getRolList();
//        //List<Rol> rlCopy = new ArrayList<>(rl);
//        List<Rol> rlCopy = new ArrayList<>();
//        for (Rol r : rl) {
//            rlCopy.add(r);
//        }
//        usuario.setRolList(rlCopy);
//        usuarioService.edit(usuario);
        
//        List<String> ll = getItemsAsStringListNotIn(usuario.getRolList(), all);
//        System.out.println("ESTAS ES LA DIFERENCIA...");
//        for (String ll1 : ll) {
//            System.out.println(ll1);
//        }
    }

    public static List<String> getItemsAsStringListNotIn(List<Rol> pitems, List<Rol> all) {

        List<String> result = new ArrayList<>();
        List<Rol> resultRol = new ArrayList<>(all);
        
        try {
            Method method = Rol.class.getMethod("getNombre");
            for (Rol itemI : pitems) {                
                String valueI = String.valueOf(method.invoke(itemI));
                for (Rol itemJ : all) {
                    String valueJ = String.valueOf(method.invoke(itemJ));
                    if (Util.toSlug(valueI).equalsIgnoreCase(Util.toSlug(valueJ))) {
                        resultRol.remove(itemJ);
                        break;
                    }
                }
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Rol rr : resultRol) {
            result.add(rr.getNombre());
        }
        
        return result;
    }
}
