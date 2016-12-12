package cu.cenpis.gps.wic.controller.converter;

import cu.cenpis.gps.wic.data.entity.TipoEstudio;
import cu.cenpis.gps.wic.controller.TipoEstudioController;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = TipoEstudio.class)
public class TipoEstudioConverter extends BaseConverter<TipoEstudio, java.lang.Long, TipoEstudioController> {

    public TipoEstudioConverter() {
        super(TipoEstudio.class, java.lang.Long.class);
    }

}

