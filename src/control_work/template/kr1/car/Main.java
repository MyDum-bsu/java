package control_work.template.kr1.car;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        MyContainer<Automobile> cars = new MyContainer<Automobile>();
        MyContainer<Automobile> buses = new MyContainer<Automobile>();
        File fileCars = new File("src\\cars");
        File fileBuses = new File("src\\buses");
        try{
            readCarsFromFile(fileCars, cars);
            cars.printAllElements();
            Car findThisCar = new Car("Audi", "red", Fuel.DIZEL, Material.COTTON);
            Car tempCar;
            System.out.println("Frequency of element: \"" + findThisCar.toString() + "\" +  in our container: " + cars.frequency(findThisCar));
            System.out.println("Max of container: " + cars.max());
            tempCar = (Car) cars.binarySearch(findThisCar);
            if (tempCar == null)
                System.out.println("We don't find such element, as: (" + findThisCar + ") in our container!");
            else
                System.out.println(tempCar + " --- such element we found in our container!");
        } catch (IOException exc){
            System.out.println("IOException. Problem with input cars's files.");
        } catch (NoSuchElementException exc){
            System.out.println("Wrong format of input data in cars input file!");
        } catch (EnumIncorrectException exc){
            System.out.println(exc.getMessage());
        } catch (EmptyException exc){
            System.out.println(exc.getMessage());
        }
        System.out.println("=======================================================================================================");
        System.out.println("=======================================================================================================");
        try{
            readBusesFromFile(fileBuses, buses);
            buses.printAllElements();
            Bus findBuses = new Bus("MAZ", "yellow", Fuel.DIZEL, 30, 3);
            Bus tempBuses;
            System.out.println("Frequency of element: \"" + findBuses.toString() + "\" in our container: " + buses.frequency(findBuses));
            System.out.println("Max of container: " + buses.max());
            tempBuses = (Bus) buses.binarySearch(findBuses);
            if (tempBuses == null)
                System.out.println("We don't find such element, as: (" + findBuses + ") in our container!");
            else
                System.out.println(tempBuses + " --- such element we found in our container!");
        } catch (IOException exc){
            System.out.println("IOException. Problem with input Buses's files.");
        } catch (NoSuchElementException exc){
            System.out.println("Wrong format of input data in buses input file!");
        } catch (EnumIncorrectException exc){
            System.out.println(exc.getMessage());
        } catch (EmptyException exc){
            System.out.println(exc.getMessage());
        } catch (IncorrectIntException exc){
            System.out.println(exc.getMessage());
        }
    }

    public static void readCarsFromFile(File fileCars, MyContainer cars) throws IOException, NoSuchElementException, EnumIncorrectException{
        Scanner scannerCars = new Scanner(fileCars);
        String name, materialTemp, fuelTemp, color;
        Material material = Material.LEATHER;
        Fuel fuel = Fuel.BENZIN;
        while (scannerCars.hasNext()){
            name = scannerCars.next();
            color = scannerCars.next();
            fuelTemp = scannerCars.next();
            materialTemp = scannerCars.next();
            fuel = fuel.toType(fuelTemp);
            material = material.toType(materialTemp);
            cars.add(new Car(name, color, fuel, material));
        }
        System.out.println("Reading from Cars file successfully done! Good job!");
    }

    public static void readBusesFromFile(File fileBuses, MyContainer buses) throws IOException, NoSuchElementException, EnumIncorrectException, IncorrectIntException{
        Scanner scannerBuses = new Scanner(fileBuses);
        String name, fuelTemp, color;
        int places, doors;
        Fuel fuel = Fuel.BENZIN;
        while (scannerBuses.hasNext()){
            name = scannerBuses.next();
            color = scannerBuses.next();
            fuelTemp = scannerBuses.next();
            fuel = fuel.toType(fuelTemp);
            places = scannerBuses.nextInt();
            doors = scannerBuses.nextInt();
            buses.add(new Bus(name, color, fuel, places, doors));
        }
        System.out.println("Reading from Buses file successfully done! Good job!");
    }
}
