// Stuart Reges
// 1/26/00
//
// Changed 2019 by W.P. Iverson, for CS211 project at Bellevue College
//
// Class AnimalModel keeps track of the state of the creature simulation.

import java.util.*;
import java.awt.*;

public class AnimalModel {
    private int myHeight;
    private int myWidth;
    private Animal[][] myGrid;
    private String[][] display;
    private Map<Animal, Point>myList;
    private SortedMap<String, Integer>creatureCount;

    public AnimalModel(int width, int height) {
        myWidth = width;
        myHeight = height;
        myGrid = new Animal[width][height];
        display = new String[width][height];
        updateDisplay();
        myList = new HashMap<Animal, Point>();
        creatureCount = new TreeMap<String, Integer>();
    }

    public void add(int number, Class<Animal> creature) {
        if (myList.size() + number > myWidth * myHeight)
            throw new RuntimeException("adding too many creatures");
        for (int i = 0; i < number; i++) {
            Object instance;
            try {
                instance = creature.newInstance();
            } catch (Exception e) {
                throw new RuntimeException("no zero-argument constructor for "
                                           + creature);
            }
            if (!(instance instanceof Animal)) {
                throw new RuntimeException(creature
                                           + " does not implement creature");
            }
            Animal next = (Animal)instance;
            int x, y;
            do {
                x = randomInt(0, myWidth - 1);
                y = randomInt(0, myHeight - 1);
            } while (myGrid[x][y] != null);
            myGrid[x][y] = next;
            display[x][y] = next.toString();
            myList.put(next, new Point(x, y));
        }
        String name = creature.getName();
        if (!creatureCount.containsKey(name))
            creatureCount.put(name, number);
        else
            creatureCount.put(name, creatureCount.get(name) + number);
    }

    private static int randomInt(int low, int high) {
        return low + (int)(Math.random() * (high - low + 1));
    }

    public int getWidth() {
        return myWidth;
    }

    public int getHeight() {
        return myHeight;
    }

    public String toString(int x, int y) {
        return display[x][y];
    }

    // We want to ask each creature once on each round how to display it.
    // This method does the asking, storing the result in display.
    private void updateDisplay() {
        // set it to all dots
        for (int x = 0; x < myWidth; x++) 
            for (int y = 0; y < myHeight; y++)
                if (myGrid[x][y] == null)
                    display[x][y] = ".";
                else
                    display[x][y] = myGrid[x][y].toString();
    }
    
    public Animal getAnimal(int i, int j) {
    	return myGrid[i][j];
    }

    public void update() {
        Animal[][] newGrid = new Animal[myWidth][myHeight];
        Object[] list = myList.keySet().toArray();
        Collections.shuffle(Arrays.asList(list));
        for (int i = 0; i < list.length; i++) {
            Animal next = (Animal) list[i];
            Point p = myList.get(next);
            int move = next.getMove(); //formerly Info(p.x, p.y));
            movePoint(p, move);
            if (newGrid[p.x][p.y] != null) {
                String c = newGrid[p.x][p.y].getClass().getName();
                creatureCount.put(c, creatureCount.get(c) - 1);
                myList.remove(newGrid[p.x][p.y]);
            }
            newGrid[p.x][p.y] = next;
        }
        myGrid = newGrid;
        updateDisplay();
    }

    public Set<Map.Entry<String, Integer>> getCounts() {
        return Collections.unmodifiableSet(creatureCount.entrySet());
    }

    // translates a point's coordinates 1 unit in a particular direction
    private void movePoint(Point p, int direction) {
        if (direction == Animal.NORTH)
            p.y = (p.y + myHeight - 1) % myHeight;
        else if (direction == Animal.SOUTH)
            p.y = (p.y + 1) % myHeight;
        else if (direction == Animal.EAST)
            p.x = (p.x + 1) % myWidth;
        else if (direction == Animal.WEST)
            p.x = (p.x + myWidth - 1) % myWidth;
        else if (direction != Animal.HOLD)
            throw new RuntimeException("Illegal direction");
    }
}
