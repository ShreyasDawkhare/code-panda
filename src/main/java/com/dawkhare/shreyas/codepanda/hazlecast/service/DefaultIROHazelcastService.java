package com.dawkhare.shreyas.codepanda.hazlecast.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.stereotype.Service;

@Service
public class DefaultIROHazelcastService implements IROHazelcastService {
  private final String IRO_IMAP_NAME = "iro-data";
  private final HazelcastInstance hazelcastInstance;

  public DefaultIROHazelcastService(HazelcastInstance hazelcastInstance) {
    this.hazelcastInstance = hazelcastInstance;
  }

  @Override
  public String createData(String key, String value) {
    IMap<String, String> map = hazelcastInstance.getMap(IRO_IMAP_NAME);
    map.put(key, value);
    return "Data is stored.";
  }

  @Override
  public String getDataByKey(String key) {
    IMap<String, String> map = hazelcastInstance.getMap(IRO_IMAP_NAME);
    return map.get(key);
  }

  @Override
  public IMap<String, String> getData() {
    return hazelcastInstance.getMap(IRO_IMAP_NAME);
  }

  @Override
  public String update(String key, String value) {
    IMap<String, String> map = hazelcastInstance.getMap(IRO_IMAP_NAME);
    map.set(key, value);
    return "Data is stored.";
  }

  @Override
  public String deleteData(String key) {
    IMap<String, String> map = hazelcastInstance.getMap("iro-data");
    return map.remove(key);
  }
}
