package Model;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author phamm
 */
public class Students extends ArrayList<Student>{
    
    public ArrayList<Student> search(Predicate<Student> p) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student stu : this) {
            if (p.test(stu)) result.add(stu);
        }
        return result;
    }
}
