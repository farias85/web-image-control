package cu.cenpis.gps.wic.controller.converter;

import cu.cenpis.gps.wic.data.entity.Estudio;
import cu.cenpis.gps.wic.controller.EstudioController;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Estudio.class)
public class EstudioConverter extends BaseConverter<Estudio, java.lang.Long, EstudioController> {

    public EstudioConverter() {
        super(Estudio.class, java.lang.Long.class);
    }

}

