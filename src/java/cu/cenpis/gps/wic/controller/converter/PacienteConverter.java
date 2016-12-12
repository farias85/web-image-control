package cu.cenpis.gps.wic.controller.converter;

import cu.cenpis.gps.wic.data.entity.Paciente;
import cu.cenpis.gps.wic.controller.PacienteController;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Paciente.class)
public class PacienteConverter extends BaseConverter<Paciente, java.lang.Long, PacienteController> {

    public PacienteConverter() {
        super(Paciente.class, java.lang.Long.class);
    }

}

