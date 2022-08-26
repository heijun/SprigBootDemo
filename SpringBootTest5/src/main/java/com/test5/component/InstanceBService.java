package com.test5.component;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class InstanceBService {
    public InstanceBService(@Lazy InstanceCService instanceCService) {

    }
}