package composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape triangle1 = new Square();

        Shape square3 = new Square();
        Shape circle2 = new Square();
        Shape circle3 = new Square();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite.addComponent(square1);
        composite.addComponent(square2);
        composite.addComponent(triangle1);

        composite1.addComponent(square3);
        composite1.addComponent(circle2);
        composite1.addComponent(circle3);

        composite2.addComponent(composite1);
        composite2.addComponent(composite2);

        composite.draw();


    }

}

interface Shape{
    void draw();
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Hi,I`m square");
    }
}
class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Hi,I`m triangle");
    }
}
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Hi,I`m circle");
    }
}

class Composite implements Shape{

    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component){
        components.add(component);
    }
    public void removeComponent(Shape component){
        components.remove(component);
    }

    @Override
    public void draw() {
        for (Shape component: components) {
            component.draw();
        }
    }
}