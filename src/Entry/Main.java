package Entry;

import Controller.Controller;
import View.StudentView;

/**
 *
 * @author phamm
 */
public class Main {
    public static void main(String[] args) {
        StudentView sView = new StudentView();
        new Controller(sView).run();
    }
}
