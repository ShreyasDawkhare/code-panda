package com.dawkhare.shreyas.codepanda.hazlecast.init;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazlecastInitializer {

  @Bean
  public HazelcastInstance hazelcastInstance() {
    Config config = new Config();
    NetworkConfig network = config.getNetworkConfig();
    JoinConfig join = network.getJoin();
    join.getMulticastConfig().setEnabled(false);
    join.getTcpIpConfig().addMember("localhost").setEnabled(true);

    return Hazelcast.newHazelcastInstance(config);
  }
}
