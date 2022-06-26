package com.simplilearn.springdatajpademo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-19
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    @OneToMany
    private List<ClientPortfolio> clientPortfolios;

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String clientName) {
        this.name = clientName;
    }

    public List<ClientPortfolio> getClientPortfolios() {
        return clientPortfolios;
    }

    public void setClientPortfolios(List<ClientPortfolio> clientPortfolios) {
        this.clientPortfolios = clientPortfolios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(clientPortfolios, client.clientPortfolios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, clientPortfolios);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + name + '\'' +
                '}';
    }
}
