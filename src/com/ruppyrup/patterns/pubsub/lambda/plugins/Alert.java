package com.ruppyrup.patterns.pubsub.lambda.plugins;

import com.ruppyrup.patterns.pubsub.lambda.core.Plugin;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Alert extends Plugin {

  final private ConcurrentLinkedDeque<Plane> planes = new ConcurrentLinkedDeque<>();

  public Alert(UUID identifier) {
    super(identifier);
  }

  @Override
  public void shutdown() {
    System.out.println("Alert shutting down with no planes = " + planes.size());
  }

  @Override
  public void start() {
    System.out.println("Starting Alert");
    getNotifier().subscribe(Plane.class, plane -> {
      planes.add(plane);
      System.out.println("Alert received plane :: " + plane);
    });
  }
}
