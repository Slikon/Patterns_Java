package builder;

public class Builder {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildMake("Ferrari")
                .buildTransmission(Trasnmission.AUTO)
                .buildMaxSpeed(340)
                .build();
        System.out.println(car);
    }
}

enum Trasnmission{
    MANUAL, AUTO
}

class Car{
    String make;
    Trasnmission trasnmission;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public void setTrasnmission(Trasnmission trasnmission) {
        this.trasnmission = trasnmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", trasnmission=" + trasnmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

class CarBuilder{
    String m = "Default";
    Trasnmission t = Trasnmission.MANUAL;
    int s = 120;

    CarBuilder buildMake(String m){
        this.m = m;
        return this;
    }
    CarBuilder buildTransmission(Trasnmission t){
        this.t = t;
        return this;
    }
    CarBuilder buildMaxSpeed(int s){
        this.s = s;
        return this;
    }

    Car build(){
        Car car = new Car();
        car.setMake(m);
        car.setMaxSpeed(s);
        car.setTrasnmission(t);
        return car;
    }
}

