package com.ruppyrup.generics.list;

import java.util.ArrayList;
import java.util.List;

public class Contravariance {

//    I have an X in my hand. If I want to write my X into a List, that List needs to be either a List of X
//    or a List of things that my X can be upcast to as I write them in i.e. any superclass of X...
//
//    java.util.List<? super   X>


//    If I get a List and I want to read an X out of that List, that better be a List of X
//    or a List of things that can be upcast to X as I read them out, i.e. anything that extends X
//
//    List<? extends X>


    public static void main(String[] args) {
        List<Vegatable> vegies = new ArrayList<>();
        List<Bamboo> bamboos = new ArrayList<>();
        List<EnergySource> energies = new ArrayList<>();
        consumeEnergySource(energies);
        produceEnergySource(vegies);
        consumeEnergySource1(energies);
        produceEnergySource1(bamboos);

    }

    static void consumeEnergySource(List<? super Vegatable> energy) {
        energy.add(new Vegatable());
        energy.add(new Bamboo());
//        energy.add(new EnergySource());
    }

     static Vegatable produceEnergySource(List<? extends Vegatable> bamboos) {
        EnergySource es = bamboos.get(1);
        return bamboos.get(0);
    }

    static void consumeEnergySource1(List<? super Vegatable> energy) {
        energy.add(new Vegatable());
        energy.add(new Bamboo());
//        energy.add(new EnergySource());
    }

    static Vegatable produceEnergySource1(List<? extends Bamboo> bamboos) {
        return bamboos.get(0);
    }


}



class EnergySource {
}

class Vegatable extends EnergySource {
}

class Bamboo extends Vegatable {
}

