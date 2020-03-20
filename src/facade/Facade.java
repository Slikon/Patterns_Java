package facade;

public class Facade {
    public static void main(String[] args) {
        Comuter comuter = new Comuter();
        comuter.copy();
    }
}

class Comuter{
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd = new HDD();

    void copy(){
        power.on();
        dvdRom.loadon();
        hdd.copyFromDVD(dvdRom);
    }
}


class Power{
    void on(){
        System.out.println("turn on the power");
    }

    void off(){
        System.out.println("turn off the power");
    }
}

class  DVDRom{
    private boolean data = false;
    public boolean hasData(){
        return data;
    }
    void loadon(){
        System.out.println("upload");
        data = true;
    }
    void loadoff(){
        System.out.println("upload");
        data = false;
    }
}

class HDD{
    void copyFromDVD(DVDRom dvd){
        if (dvd.hasData()){
            System.out.println("coping...");
        }else {
            System.out.println("input the dist with data");
        }
    }
}
