package com.dawkhare.shreyas.codepanda.hazlecast.controller;

import com.dawkhare.shreyas.codepanda.hazlecast.service.IROHazelcastService;
import com.hazelcast.map.IMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hazlecast-iro/v1")
public class HazelcastCRUDController {
  private final IROHazelcastService iroHazelcastService;

  public HazelcastCRUDController(IROHazelcastService iroHazelcastService) {
    this.iroHazelcastService = iroHazelcastService;
  }

  @PostMapping(value = "/create")
  public String createData(@RequestParam String key, @RequestParam String value) {
    iroHazelcastService.createData(key, value);
    return "Success";
  }

  @GetMapping(value = "/getByKey")
  public String getDataByKey(@RequestParam String key) {
    return iroHazelcastService.getDataByKey(key);
  }

  @GetMapping(value = "/get")
  public IMap<String, String> getData() {
    return iroHazelcastService.getData();
  }

  @PutMapping(value = "/update")
  public String updateData(@RequestParam String key, @RequestParam String value) {
    iroHazelcastService.update(key, value);
    return "Success";
  }

  @DeleteMapping(value = "/delete")
  public String deleteData(@RequestParam String key) {
    iroHazelcastService.deleteData(key);
    return "Success";
  }
}
