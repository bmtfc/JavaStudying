package com.company.pizzeria;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Order implements Serializable {
    private String orderNumber;
    private List<Pizza> pizzas;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Kiev")
    private Date desiredTime;
    private Boolean isDone;
}