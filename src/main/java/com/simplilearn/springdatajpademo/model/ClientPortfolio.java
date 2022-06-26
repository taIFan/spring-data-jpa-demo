package com.simplilearn.springdatajpademo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-19
 */
@Entity
public class ClientPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToOne
    private Client client;
    @OneToMany
    private List<PortfolioPosition> positionList;

    public ClientPortfolio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String portfolioName) {
        this.name = portfolioName;
    }

    public List<PortfolioPosition> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<PortfolioPosition> positionList) {
        this.positionList = positionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientPortfolio that = (ClientPortfolio) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(client, that.client) && Objects.equals(positionList, that.positionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, client, positionList);
    }
}
