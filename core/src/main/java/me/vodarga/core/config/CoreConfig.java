package me.vodarga.core.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;

@Sources("classpath:app.properties")
public interface CoreConfig extends Config {

  CoreConfig CORE_CFG = ConfigFactory.create(CoreConfig.class);

  @Key("base.url")
  String baseUrl();

}
