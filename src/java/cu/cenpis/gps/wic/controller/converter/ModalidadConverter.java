package cu.cenpis.gps.wic.controller.converter;

import cu.cenpis.gps.wic.controller.ModalidadController;
import cu.cenpis.gps.wic.data.entity.Modalidad;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Modalidad.class)
public class ModalidadConverter extends BaseConverter<Modalidad, java.lang.Long, ModalidadController> {

    public ModalidadConverter() {
        super(Modalidad.class, java.lang.Long.class);
    }
}

