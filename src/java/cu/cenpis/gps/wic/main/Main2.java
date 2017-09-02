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
package cu.cenpis.gps.wic.main;

import cu.cenpis.gps.wic.controller.ProcedenciaController;
import cu.cenpis.gps.wic.data.entity.Diagnostico;
import cu.cenpis.gps.wic.data.entity.Usuario;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author farias-i5
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException {
        // TODO code application logic here

//        String className = ProcedenciaController.class.getSimpleName();
//        String paramName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
//        System.out.println(paramName);
//
//        Class cc = Class.forName("cu.cenpis.gps.wic.data.entity.Diagnostico");
//        Method[] methods = cc.getMethods();
//
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
//        Object obj = cc.newInstance();
//
////        Class[] paramString = new Class[1];
////        paramString[0] = String.class;
//
//        Method method = cc.getDeclaredMethod("setNombre", new Class[]{String.class});
//	method.invoke(obj, "diagnostico 50");
//
//        System.out.println(((Diagnostico)obj).getNombre());
        //cc.getMethod("setNombre", );
//        Field[] ff = cc.getDeclaredFields();        
//        for (Field ff1 : ff) {
//            System.out.println(ff1.getName());
//        }
//        Class ccl = Class.forName("java.lang.Long");
//        Class[] longArgsClass = new Class[]{String.class};
//        Constructor intArgsConstructor;
//        intArgsConstructor = ccl.getConstructor(longArgsClass);
//        Long l = (Long) createObject(intArgsConstructor, new Object[]{"50"});
        //Integer ii = new Integer();
        Field id = getIdField(Usuario.class);
        Method idm = getIdMethod(Usuario.class);
        
        System.out.println(id.getName());
        System.out.println(idm.getName());

//        System.out.println(l);
//        Method[] methods = ccl.getMethods();
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
//        Method method = ccl.getDeclaredMethod("setValue", new Class[]{Object.class});
//        method.invoke(objl, "50L");
//
//        System.out.println(ccl);
//
//        Long x = (Long) (((Num) objl).getValue());
//        System.out.println(x);
    }

    private static Field getIdField(Class entityClass) {

        Field id = null;
        Field[] ff = entityClass.getDeclaredFields();
        for (Field f : ff) {
            if (f.getName().startsWith("id") && (f.getName().equals("id")
                    || Character.isUpperCase(f.getName().charAt(2)))) {
                id = f;
                break;
            }
        }
        return id;
    }

    private static Method getIdMethod(Class entityClass) {

        Method mid = null;
        Method[] mms = entityClass.getMethods();
        for (Method m : mms) {
            if (m.getName().startsWith("getId") && (m.getName().equals("getId")
                    || Character.isUpperCase(m.getName().charAt(5)))) {
                mid = m;
                break;
            }
        }
        return mid;
    }

    public static Object createObject(Constructor constructor, Object[] arguments) {

        System.out.println("Constructor: " + constructor.toString());
        Object object = null;

        try {
            object = constructor.newInstance(arguments);
            System.out.println("Object: " + object.toString());
            return object;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            System.out.println(e);
        }
        return object;
    }

}
