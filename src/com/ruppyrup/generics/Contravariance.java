package com.ruppyrup.generics;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Contravariance {

    public void feedConsumers(
            Supplier<EnergySource> energy,
            Supplier<Vegatable> veg,
            Supplier<Bamboo> bamboo,
            Consumer<EnergySource> consumerOfAnythingThatBurns,
            Consumer<Vegatable> consumerOfVegetables,
            Consumer<? super Bamboo> consumerofBamboo
    ) {
        consumerOfAnythingThatBurns.accept(energy.get());
        consumerOfAnythingThatBurns.accept(veg.get());
        consumerOfAnythingThatBurns.accept(bamboo.get());

//        consumerOfVegetables.accept(energy.get());
        consumerOfVegetables.accept(veg.get());
        consumerOfVegetables.accept(bamboo.get());

//        consumerofBamboo.accept(energy.get());
//        consumerofBamboo.accept(veg.get());
        consumerofBamboo.accept(bamboo.get());

    }

    public void VegRUs(Supplier<? extends Vegatable> vegSupplier, Consumer<? super EnergySource> vegConsumer) {
        vegConsumer.accept(new Bamboo());
        vegConsumer.accept(new Vegatable());
        vegConsumer.accept(new EnergySource());

        vegConsumer.accept(vegSupplier.get());
    }


    public static void main(String[] args) {
        Supplier<Vegatable> carrots = Vegatable::new;
        Supplier<Bamboo> bamboo = Bamboo::new;
        Supplier<EnergySource> energy = EnergySource::new;
        Consumer<Vegatable> vegie = veg -> System.out.println("Vegie eat veg");
        Consumer<Bamboo> panda = veg -> System.out.println("Panda eat bambo");
        Consumer<EnergySource> fire = fuel -> System.out.println("Fire consumes everthing");

        Contravariance contravariance = new Contravariance();

//        contravariance.VegRUs(carrots, vegie);
//        contravariance.VegRUs(energy, fire); // needs Supplier<? extends Vegatable
//        contravariance.VegRUs(bamboo, panda);
//        contravariance.VegRUs(bamboo, fire);

    }

}

class EnergySource {
}

class Vegatable extends EnergySource {
}

class Bamboo extends Vegatable {
}

