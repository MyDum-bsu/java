package control_work.template.kr1.car;

public class Car extends Automobile{
    private Material material;

    public void print()
    {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Car car = (Car) o;

        return material == car.material;
    }

    public Car(){
        super();
    }

    @Override
    public String toString() {
        return "Car{" +
                "material=" + material +
                '}';
    }
//    public String toString()
//    {
//        String temporarory;
//        temporarory = super.toString();
//        temporarory += ", seat material: " + this.getMaterial() + ";";
//        return temporarory;
//    }

    public Car(String name, String color, Fuel fuel, Material material){
        super(name, color, fuel);
        this.material = material;
    }

    public Material getMaterial(){
        return material;
    }

    public void setMaterial(Material material){
        this.material = material;
    }
}