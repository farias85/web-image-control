package cu.cenpis.gps.wic.data.service.impl;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import cu.cenpis.gps.wic.data.service.EspecialidadService;
import cu.cenpis.gps.wic.data.entity.Especialidad;
import cu.cenpis.gps.wic.data.dao.EspecialidadDAO;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EspecialidadServiceImpl extends BaseServiceImpl<Especialidad, java.lang.Long, EspecialidadDAO>
        implements EspecialidadService {

    private static final long serialVersionUID = 1L;

    public EspecialidadServiceImpl() {
        System.out.println("EspecialidadServiceImpl()");
    }

    @Override
    public List<String> findNames() {
        List<Object[]> list = dao.findNames();
        List<String> result = new ArrayList<>();
        for (Object[] row : list) {            
            result.add(row[0].toString());
        }
        return result;
    }
}