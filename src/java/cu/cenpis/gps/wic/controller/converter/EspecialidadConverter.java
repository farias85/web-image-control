package cu.cenpis.gps.wic.controller.converter;

import cu.cenpis.gps.wic.data.entity.Especialidad;
import cu.cenpis.gps.wic.controller.EspecialidadController;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Especialidad.class)
public class EspecialidadConverter extends BaseConverter<Especialidad, java.lang.Long, EspecialidadController> {

    public EspecialidadConverter() {
        super(Especialidad.class, java.lang.Long.class);
    }

}

