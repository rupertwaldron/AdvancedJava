package com.ruppyrup.pubsub.lockheed.plugins;

import com.ruppyrup.pubsub.lockheed.core.Plugin;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Display extends Plugin {

  private List<ScreenBlob> blobs = new LinkedList<>();

  public Display(UUID identifier) {
    super(identifier);
  }

  @Override
  public void shutdown() {
    System.out.println("Display shutting down with no blobs = " + blobs.size());
  }

  @Override
  public void start() {
    System.out.println("Starting Display");
    getNotifier().subscribe(Plane.class, plane -> {
      System.out.println("Screen received plane :: " + plane);
      ScreenBlob screenBlob = new ScreenBlob(plane.id, plane.iff);
      setBlobOnScreen(screenBlob);
    });
  }

  private void setBlobOnScreen(ScreenBlob screenBlob) {
    blobs.add(screenBlob);
    getNotifier().publish(ScreenBlob.class, () -> screenBlob);
  }
}

class ScreenBlob {
  int id;
  boolean iff;

  public ScreenBlob(int id, boolean iff) {
    this.id = id;
    this.iff = iff;
  }

  @Override
  public String toString() {
    return "ScreenBlob{" +
        "id=" + id +
        ", iff=" + iff +
        '}';
  }
}
