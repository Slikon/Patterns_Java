package prototype;



public class Prototype {
    public static void main(String[] args) {
        Human human = new Human(18,"vasya");
        System.out.println(human);

        Human humanCopy = (Human) human.copy();
        System.out.println(humanCopy);

        HumanFactory  humanFactory= new HumanFactory(humanCopy);
        Human human1 = humanFactory.makeCopy();
        System.out.println(human1);

        humanFactory.setPrototype(new Human(32,"Kolya"));
        Human human2 = humanFactory.makeCopy();
        System.out.println(human2);

    }
}

interface Copybale{
    Object copy();
}

class Human implements Copybale{
    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    int age;
    String name;
    public Human(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        Human copy = new Human(age,name);
        return copy;
    }
}

class HumanFactory{
    Human human;
    public HumanFactory(Human human){
        setPrototype(human);
    }

    public void setPrototype(Human human) {
        this.human = human;
    }
    Human makeCopy(){
        return (Human)human.copy();
    }
}