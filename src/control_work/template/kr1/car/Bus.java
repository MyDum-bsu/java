package control_work.template.kr1.car;

public class Bus extends Automobile {
    private int places;
    private int doors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Bus bus = (Bus) o;

        if (places != bus.places) return false;
        return doors == bus.doors;
    }

    public String toString() {
        String temporarory;
        temporarory = super.toString();
        temporarory += ", seat places: " + this.getPlaces() + ", doors: " + this.getDoors() + ";";
        return temporarory;
    }

    public Bus(String name, String color, Fuel fuel, int places, int doors) throws IncorrectIntException {
        super(name, color, fuel);
        if (places < 0 || doors < 1)
            throw new IncorrectIntException();
        this.places = places;
        this.doors = doors;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void print() {
        System.out.println(this);
    }
}
