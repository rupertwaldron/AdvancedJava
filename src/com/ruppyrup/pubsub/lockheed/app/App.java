package com.ruppyrup.pubsub.lockheed.app;

import com.ruppyrup.pubsub.lockheed.core.Notifier;
import com.ruppyrup.pubsub.lockheed.core.StandardNotifier;
import com.ruppyrup.pubsub.lockheed.plugins.Display;
import com.ruppyrup.pubsub.lockheed.plugins.Radar;
import java.util.UUID;

public class App {

  public static void main(String[] args) {
    Notifier notifier = new StandardNotifier();
    Radar radar = new Radar(UUID.randomUUID());
    Display display = new Display(UUID.randomUUID());

    radar.setNotifier(notifier);
    display.setNotifier(notifier);

    radar.start();
    display.start();

    radar.addPlane();

    radar.shutdown();
    display.shutdown();

  }

}
