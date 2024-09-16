package Carmodel;

public class Carfactory { 
    public car getCar(int carType) { 
        switch (carType) {
            case 1:
                return new Toyota(); 
            case 2:
                return new RangeRover(); 
            case 3:
                return new Audi(); 
           
            default:
                return null;
        }
    }
}
