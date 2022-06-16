package com.ruppyrup.pubsub.lockheed.plugins;

import com.ruppyrup.pubsub.lockheed.core.Plugin;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.UUID;

public class Radar extends Plugin {

  final Random random = new Random();
  final Deque<Plane> planes = new LinkedList<>();

  public Radar(UUID identifier) {
    super(identifier);
  }

  public void addPlane() {
    try {
      Thread.sleep((long) (100 * Math.random()));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    int ran = random.nextInt(200);
    System.out.println("Radar sent a num :: ran");
    Plane plane = new Plane(ran, true);
    planes.addFirst(plane);
    getNotifier().publish(Plane.class, () -> plane);
  }

  public Plane getLastPlane() {
    return planes.removeLast();
  }

  @Override
  public void shutdown() {
    System.out.println("Radar shutting down");
  }

  @Override
  public void start() {
    System.out.println("Starting Radar");
    getNotifier().subscribe(ScreenBlob.class, blob -> {
      System.out.println("Screen blob received :: " + blob);
    });
  }
}

class Plane {
  int id;
  boolean iff;

  public Plane(int id, boolean iff) {
    this.id = id;
    this.iff = iff;
  }

  @Override
  public String toString() {
    return "Plane{" +
        "id=" + id +
        ", iff=" + iff +
        '}';
  }
}
