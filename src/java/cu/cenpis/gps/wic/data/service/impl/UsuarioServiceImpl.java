package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.service.UsuarioService;
import cu.cenpis.gps.wic.data.entity.Usuario;
import cu.cenpis.gps.wic.data.dao.UsuarioDAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, java.lang.Long, UsuarioDAO>
        implements UsuarioService {

    private static final long serialVersionUID = 1L;

    public UsuarioServiceImpl() {
        System.out.println("UsuarioServiceImpl()");
    }
}
