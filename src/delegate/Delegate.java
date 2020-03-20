package delegate;

public class Delegate {
    public static void main(String[] args) {
        /*A a = new A();
        a.f();*/
        Painter painter = new Painter();
        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Triangle());
        painter.draw();
    }
}

class A{
    void f(){
        System.out.println("f()");
    }
}

//class B делегирует свои полномочия классу А
//В использует А
class B{
    A a = new A();
    void f(){
        a.f();
    }
}

interface Graphics{
    void draw();
}

class Triangle implements Graphics{
    @Override
    public void draw() {
        System.out.println("Draw triangle");
    }
}

class Square implements Graphics{
    @Override
    public void draw() {
        System.out.println("Draw square");
    }
}

class Circle implements Graphics{
    @Override
    public void draw() {
        System.out.println("Draw circle");
    }
}

class Painter{
    Graphics graphics;
    void setGraphics(Graphics g){
        graphics = g;
    }

    void draw(){
        graphics.draw();
    }
}
