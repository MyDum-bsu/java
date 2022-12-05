package control_work.cw.kr1.src;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Container {
    public static ArrayList<Worker> inDescendingOrder(ArrayList<Worker> o) {
        return (ArrayList<Worker>) o.stream().sorted((a, b) -> b.calculate() - a.calculate()).collect(Collectors.toList());
    }
    public static ArrayList<Worker> inSalaryPositionOrder(ArrayList<Worker> o) {
        return (ArrayList<Worker>) o.stream().sorted((o1, o2) -> Double.compare(o1.calculate()/o1.getKoef(), o2.calculate()/o1.getKoef())).collect(Collectors.toList());
    }

    public static ArrayList<Worker> beginsWithB(ArrayList<Worker> o) {
        return (ArrayList<Worker>) o.stream().filter(a -> a.getOrganization().startsWith("B")).collect(Collectors.toList());
    }

    public static double averageSalary(ArrayList<Worker> o) {
        double average = 0;
        for (Worker worker : o) {
            average += worker.calculate();
        }
        return average / o.size();
    }
}
