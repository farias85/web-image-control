package cu.cenpis.gps.wic.controller.converter;

import cu.cenpis.gps.wic.data.entity.Diagnostico;
import cu.cenpis.gps.wic.controller.DiagnosticoController;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Diagnostico.class)
public class DiagnosticoConverter extends BaseConverter<Diagnostico, java.lang.Long, DiagnosticoController> {

    public DiagnosticoConverter() {
        super(Diagnostico.class, java.lang.Long.class);
    }

}

