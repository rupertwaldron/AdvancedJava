package com.ruppyrup.pubsub.lockheed.plugins;

import com.ruppyrup.pubsub.lockheed.core.Plugin;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Alert extends Plugin {

  List<Plane> planes = new LinkedList<>();

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
