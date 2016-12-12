package cu.cenpis.gps.wic.controller.converter;

import cu.cenpis.gps.wic.data.entity.Procedencia;
import cu.cenpis.gps.wic.controller.ProcedenciaController;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Procedencia.class)
public class ProcedenciaConverter extends BaseConverter<Procedencia, java.lang.Long, ProcedenciaController> {

    public ProcedenciaConverter() {
        super(Procedencia.class, java.lang.Long.class);
    }

}

