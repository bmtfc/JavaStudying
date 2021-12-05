package com.company.pizzeria;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Client implements Serializable {
    private String name;
    private String address;
    private List<Order> orders;
}