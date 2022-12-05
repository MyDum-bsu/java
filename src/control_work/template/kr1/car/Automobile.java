package control_work.template.kr1.car;

import java.util.Objects;

public abstract class Automobile implements Comparable<Automobile>{
    private String name;
    private String color;
    private Fuel fuel;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Automobile that = (Automobile) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(color, that.color)) return false;
        return fuel == that.fuel;
    }

    public Automobile(){
        name = "";
        color = "";
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", fuel=" + fuel +
                '}';
    }

    public abstract void print();

    @Override
    public int compareTo(Automobile o){
        if (this.getName().equals(o.getName()))
            return -1 * (this.getFuel().compareTo(o.getFuel()));
        return this.getName().compareTo(o.getName());
    }

    public Automobile(String name, String color, Fuel fuel){
        this.name = name;
        this.color = color;
        this.fuel = fuel;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
}
