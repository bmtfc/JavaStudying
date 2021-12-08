package com.company.pizzeria;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


@Data
public class Pizzeria implements Serializable {
    private List<Pizza> pizzaList;
    private List<Client> clientList;

    public void initPizzeria(String pathPizzas, String pathClients) {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = Pizzeria.class.getClassLoader();

        try {
            URL resource = classLoader.getResource(pathPizzas);
            pizzaList = mapper.readValue(new File(Objects.requireNonNull(resource).toURI()),
                    new TypeReference<>() {
                    });

            resource = classLoader.getResource(pathClients);
            clientList = mapper.readValue(new File(Objects.requireNonNull(resource).toURI()),
                    new TypeReference<>() {
                    });
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getSortedOrders() {
        return clientList.stream()
                .flatMap(client -> client.getOrders().stream())
                .sorted(Comparator.comparing(Order::getDesiredTime))
                .collect(Collectors.toList());
    }

    public List<String> getAddresses() {
        return clientList.stream()
                .filter(client -> client.getOrders().stream()
                        .mapToInt(order -> order.getPizzas().size())
                        .sum() > 2)
                .flatMap(client -> Stream.of(client.getAddress()))
                .collect(Collectors.toList());
    }

    public long getClientsCount(String pizzaName) {
        return clientList.stream()
                .filter(client -> client.getOrders().stream()
                        .flatMap(order -> order.getPizzas().stream())
                        .anyMatch(pizza -> pizzaName.equals(pizza.getName())))
                .count();
    }

    public long getMaxPizzaCount(Client client, List<Pizza> pizzaList) {
        return pizzaList.stream().map(x -> Collections.frequency(client.getOrders().stream()
                        .flatMap(order -> order.getPizzas().stream())
                        .filter(pizza -> pizzaList.stream()
                                .anyMatch(pizza::equals))
                        .collect(Collectors.toList()), x))
                .max(Comparator.comparing(Integer::intValue)).orElse(0);
    }

    public Map<Pizza, List<Client>> getPizzasClients() {
        Map<Pizza, List<Client>> pizzasClients = new HashMap<>();
        pizzaList.forEach(pizza -> pizzasClients.merge(
                pizza,
                clientList.stream()
                        .filter(client -> client.getOrders().stream()
                                .flatMap(order -> order.getPizzas().stream())
                                .anyMatch(clientPizza -> clientPizza.equals(pizza)))
                        .collect(toList()),
                (l1, l2) -> {
                    List<Client> resList = new ArrayList<>(l1);
                    resList.addAll(l2);
                    return resList;
                }));
        return pizzasClients;
    }

    public Map<Order, Long> getUnfulfilledOrders() {
        return clientList.stream()
                .flatMap(client -> client.getOrders().stream())
                .filter(order -> new Date().after(order.getDesiredTime())
                        && !order.getIsDone())
                .collect(Collectors.toMap(Function.identity(),
                        order -> new Date().getTime() - order.getDesiredTime().getTime()));
    }
}
