package com.ruppyrup.observer.clock;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class Clock {

  private final Scanner scanner = new Scanner(System.in);

  private LocalTime currentTime;
  private volatile boolean running = true;

  public Clock() {
    this.currentTime = LocalTime.now();
    tic();
    new Thread(this::keyboard).start();
  }

  private void keyboard() {
    while(running) {
      if (scanner.nextLine().equals("q")) {
        running = false;
      }
    }

    StringBuilder test = new StringBuilder();

    Arrays.stream("Hello world".split(""))
        .filter(word -> word.length() > 2)
        .map(word -> String.valueOf(word.charAt(0)))
        .filter(word -> word.matches(""))
        .forEach(test::append);

  }

  private void tic() {
    Thread thread = new Thread(() -> {
      while (running) {
        try {
          Thread.sleep(5000);
          updateTime();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });
    thread.start();
  }

  protected void updateTime() {
    System.out.println("Calling clock updateTime");
    currentTime = LocalTime.now();
  }

  public LocalTime getTime() {
    return currentTime;
  }

}
