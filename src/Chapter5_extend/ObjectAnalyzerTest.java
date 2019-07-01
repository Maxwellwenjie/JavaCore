package Chapter5_extend;

import java.util.ArrayList;

public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i=1; i<=5; i++){
            squares.add(i*i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
        System.out.println(squares.getClass().getName());

        Double a = new Double(2);
        System.out.println(new ObjectAnalyzer().toString(a));

        int[] b = {1, 2, 3, 4, 5};
        System.out.println(new ObjectAnalyzer().toString(b));
        int c = 1;
        System.out.println(new ObjectAnalyzer().toString(c));

        Employee carl = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        System.out.println(new ObjectAnalyzer().toString(carl));
    }
}
