package me.luocaca.model.controller;

import me.luocaca.model.entity.Person;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

public class ExampleUser implements Example<Integer> {
    @Override
    public Integer getProbe() {
        return null;
    }

    @Override
    public ExampleMatcher getMatcher() {
        return null;
    }

    @Override
    public Class<Integer> getProbeType() {
        return null;
    }
}
