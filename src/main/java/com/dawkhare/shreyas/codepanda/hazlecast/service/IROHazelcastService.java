package com.dawkhare.shreyas.codepanda.hazlecast.service;

import com.hazelcast.map.IMap;

public interface IROHazelcastService {
  String createData(String key, String value);

  String getDataByKey(String key);

  IMap<String, String> getData();

  String update(String key, String value);

  String deleteData(String key);
}
