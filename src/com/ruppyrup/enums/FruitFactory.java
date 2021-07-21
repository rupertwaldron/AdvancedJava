package com.ruppyrup.enums;

public class FruitFactory {
    public static void main(String[] args) {
//        FruitBuilder getSample1 = () -> new Pear();
//        FruitBuilder getSample2 = Apple::new;
//        Fruit s1 = getSample1.get();
//        Fruit s2 = getSample2.get();
        FruitFactory fruitFactory = new FruitFactory();
        Fruit apple = FruitType.Apple.createFruit();
        apple.eatFruit();
        Fruit pear = FruitType.Pear.createFruit();
        pear.eatFruit();
        Fruit banana = FruitType.Banana.createFruit();
        banana.eatFruit();

    }
}

@FunctionalInterface
interface FruitBuilder {
    Fruit get();
}

enum FruitType {
    Apple(Apple::new),
    Pear(Pear::new),
    Banana(Bananna::new);

    private final FruitBuilder fruitBuilder;
    private static String colour = "";

    FruitType(FruitBuilder fruitBuilder) {
        this.fruitBuilder = fruitBuilder;
    }

    public Fruit createFruit() {
        return fruitBuilder.get();
    }
}

interface Fruit {
    void eatFruit();
}

class Apple implements Fruit {
    public Apple() {
        System.out.println("Apple Constructor Execution");
    }

    @Override
    public void eatFruit() {
        System.out.println("Eating an apple");
    }
}

class Pear implements Fruit {
    public Pear() {
        System.out.println("Pear Constructor Execution");
    }

    @Override
    public void eatFruit() {
        System.out.println("Eating a pear");
    }
}

class Bananna implements Fruit {
    private String colour;

    public Bananna() {
        System.out.println("Banana Constructor Execution");
    }

    public Bananna(String colour) {
        this();
        this.colour = colour;
        System.out.println(colour + " Banana Constructor Execution");
    }

    @Override
    public void eatFruit() {
        System.out.println("Eating a " + colour + " Bananna");
    }
}
