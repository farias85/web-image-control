package cu.cenpis.gps.wic.controller.converter;

import cu.cenpis.gps.wic.data.entity.Usuario;
import cu.cenpis.gps.wic.controller.UsuarioController;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter extends BaseConverter<Usuario, java.lang.Long, UsuarioController> {

    public UsuarioConverter() {
        super(Usuario.class, java.lang.Long.class);
    }

}

