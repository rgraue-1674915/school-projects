// Stuart Reges
// 9/6/00 (original code with "Building Java Programs" textbook
//
// Changed 2019 by W.P. Iverson, for CS211 project at Bellevue College
//
// Animal GUI provides method main for a simple GUI simulation program.
// and by the way, GUI == Graphic User Interface

public class AnimalGUI {
    public static void main(String[] args) {
        AnimalFrame frame = new AnimalFrame();

        frame.add(25, Bird.class);
        frame.add(25, Mouse.class);        
        frame.add(25, Frog.class);
       frame.add(25, Rabbit.class);
        frame.add(25, Snake.class);
        frame.add(25, Turtle.class);
        frame.add(25, Wolf.class);

        frame.start();
    }
}
