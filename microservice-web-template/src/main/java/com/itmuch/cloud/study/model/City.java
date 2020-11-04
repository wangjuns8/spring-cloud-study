package com.itmuch.cloud.study.model;

import lombok.Data;

@Data
public class City {
    Long id;
    String name;
    String population;

    public City(Long id, String name, String population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }
}
