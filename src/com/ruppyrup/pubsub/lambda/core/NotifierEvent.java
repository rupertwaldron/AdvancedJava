package com.ruppyrup.pubsub.lambda.core;

@FunctionalInterface
public interface NotifierEvent {

  void callBack(NotifierEventArgs args);

}
