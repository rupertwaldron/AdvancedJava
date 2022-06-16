package com.ruppyrup.pubsub.lockheed.core;

@FunctionalInterface
public interface NotifierEvent {

  void callBack(NotifierEventArgs args);

}
