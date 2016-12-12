package cu.cenpis.gps.wic.controller.converter;

import cu.cenpis.gps.wic.data.entity.Rol;
import cu.cenpis.gps.wic.controller.RolController;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Rol.class)
public class RolConverter extends BaseConverter<Rol, java.lang.Long, RolController> {

    public RolConverter() {
        super(Rol.class, java.lang.Long.class);
    }

}

