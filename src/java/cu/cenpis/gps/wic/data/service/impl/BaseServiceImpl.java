/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Created by Felipe Rodriguez Arias <ucifarias@gmail.com>.
 */
package cu.cenpis.gps.wic.data.service.impl;

import cu.cenpis.gps.wic.data.dao.AbstractDAO;
import cu.cenpis.gps.wic.data.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author farias-i5
 * @param <T>
 * @param <I>
 * @param <TDAO>
 */
@Service
@Transactional
public class BaseServiceImpl<T extends Object, I extends Serializable, TDAO extends AbstractDAO<T, I>>
        implements BaseService<T, I>, Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    protected TDAO dao;

    @Override
    public Long create(T object) {
        return dao.create(object);
    }

    @Override
    public T edit(T object) {
        return dao.edit(object);
    }

    @Override
    public void remove(T object) {
        dao.remove(object);
    }

    @Override
    public void removeById(I id) {
        dao.removeById(id);
    }

    @Override
    public boolean exist(I id) {
        return dao.exist(id);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public T find(I id) {
        return dao.find(id);
    }

    @Override
    public List<T> findNamedQuery(String namedQuery) {
        return dao.findNamedQuery(namedQuery);
    }

    @Override
    public List<T> findNamedQuery(String namedQuery, String paramName, Object value) {
        return dao.findNamedQuery(namedQuery, paramName, value);
    }

    @Override
    public List<T> findByExample(T exampleEntity) {
        return dao.findByExample(exampleEntity);
    }

}
