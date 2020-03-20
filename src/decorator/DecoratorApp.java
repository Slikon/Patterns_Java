package decorator;

public class DecoratorApp {
    public static void main(String[] args) {
        //PrintInterface printer =new Printer("Hi");
        PrintInterface printer = new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hi") )));
        printer.print();
    }
}

interface PrintInterface{
    void print();
}

abstract class Decorator implements PrintInterface{
    PrintInterface component;

    public Decorator(PrintInterface component) {
        this.component = component;
    }
}

class Printer implements PrintInterface{

    String value;
    public Printer(String value){this.value = value;}

    @Override
    public void print() {
        System.out.println(value);
    }

}

class QuotesDecorator extends Decorator{
    PrintInterface component;
    public QuotesDecorator(PrintInterface component){super(component);}
    @Override
    public void print() {
        System.out.println("/");
        component.print();
        System.out.println("/");
    }
}

class LeftBracketDecorator extends Decorator{
    PrintInterface component;
    public LeftBracketDecorator(PrintInterface component){
        super(component);
    }

    @Override
    public void print() {
        System.out.println("[");
        component.print();
    }
}

class RightBracketDecorator extends Decorator{
    PrintInterface component;
    public RightBracketDecorator(PrintInterface component){
        super(component);
    }

    @Override
    public void print() {
        component.print();
        System.out.println("]");
    }
}