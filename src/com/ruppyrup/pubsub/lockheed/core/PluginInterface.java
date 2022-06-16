package com.ruppyrup.pubsub.lockheed.core;

import java.util.Collection;

public interface PluginInterface extends Notifier {

  Collection<Plugin> getRegisteredPlugins();

  void registerPlugin(Plugin component);
}
