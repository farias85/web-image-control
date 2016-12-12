package cu.cenpis.gps.wic.controller.converter;

import cu.cenpis.gps.wic.data.entity.Medico;
import cu.cenpis.gps.wic.controller.MedicoController;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Medico.class)
public class MedicoConverter extends BaseConverter<Medico, java.lang.Long, MedicoController> {

    public MedicoConverter() {
        super(Medico.class, java.lang.Long.class);
    }

}

