package com.ruppyrup.patterns.pubsub.lambda.core;

@FunctionalInterface
public interface NotifierEvent {

  void callBack(NotifierEventArgs args);

}
