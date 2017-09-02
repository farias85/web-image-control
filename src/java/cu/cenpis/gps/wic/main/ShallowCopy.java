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

class Subject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public Subject(String s) {
        name = s;
    }
}

class Student implements Cloneable {

    //Contained object

    private Subject subj;

    private String name;

    public Subject getSubj() {
        return subj;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public Student(String s, String sub) {
        name = s;
        subj = new Subject(sub);
    }

    public Object clone() {
        //shallow copy
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

public class ShallowCopy {

    public static void main(String[] args) {
        //Original Object
        Student stud = new Student("John", "Algebra");

        System.out.println("Original Object: " + stud.getName() + " - "
                + stud.getSubj().getName());

        //Clone Object
        Student clonedStud = (Student) stud.clone();

        System.out.println("Cloned Object: " + clonedStud.getName() + " - "
                + clonedStud.getSubj().getName());

        stud.setName("Dan");
        stud.getSubj().setName("Physics");

        System.out.println("Original Object after it is updated: "
                + stud.getName() + " - " + stud.getSubj().getName());

        System.out.println("Cloned Object after updating original object: "
                + clonedStud.getName() + " - " + clonedStud.getSubj().getName());

    }
}
