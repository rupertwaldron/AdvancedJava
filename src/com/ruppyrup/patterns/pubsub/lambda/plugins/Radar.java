package com.ruppyrup.patterns.pubsub.lambda.plugins;

import com.ruppyrup.patterns.pubsub.lambda.core.Plugin;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Radar extends Plugin {

  final Random random = new Random();
  private final ConcurrentLinkedDeque<Plane> planes = new ConcurrentLinkedDeque<>();
  private final ConcurrentLinkedDeque<ScreenBlob> blobs = new ConcurrentLinkedDeque<>();

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

  @Override
  public void shutdown() {
    System.out.println("Radar shutting down with no planes = " + planes.size());
    System.out.println("Radar shutting down with no blobs = " + blobs.size());
  }

  @Override
  public void start() {
    System.out.println("Starting Radar");
    getNotifier().subscribe(ScreenBlob.class, blob -> {
      blobs.add(blob);
      System.out.println("Radar received Screen blob :: " + blob);
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
