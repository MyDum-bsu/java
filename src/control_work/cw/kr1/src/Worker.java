package control_work.cw.kr1.src;

import java.util.Scanner;

public abstract class Worker {
    protected String name;
    protected String organization;
    protected double koef;

    public Worker() {
        name = "";
        organization = "";
        koef = 0;
    }

    public Worker(String name, String organisation, double koef) {
        this.name = name;
        this.organization = organisation;
        this.koef = koef;

    }
    protected abstract int calculate();

    public String getName() {
        return name;
    }

    public String getOrganization() {
        return organization;
    }

    public double getKoef() {
        return koef;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setKoef(double koef) {
        this.koef = koef;
    }

    public static Worker parseFromString(String s) {
        Scanner scanner = new Scanner(s);
        Worker w = new Worker() {
            @Override
            protected int calculate() {
                return 0;
            }
        };
        w.name = scanner.next();
        w.organization = scanner.next();
        w.koef = scanner.nextDouble();
        return w;
    }

}
