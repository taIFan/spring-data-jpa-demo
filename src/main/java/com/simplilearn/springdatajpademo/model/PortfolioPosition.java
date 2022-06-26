package com.simplilearn.springdatajpademo.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-25
 */
@Entity
public class PortfolioPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private AssetMapping assetMapping;
    @ManyToOne
    private ClientPortfolio clientPortfolio;

    private Double quantity;

    public PortfolioPosition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AssetMapping getAssetMapping() {
        return assetMapping;
    }

    public void setAssetMapping(AssetMapping assetMapping) {
        this.assetMapping = assetMapping;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public ClientPortfolio getClientPortfolio() {
        return clientPortfolio;
    }

    public void setClientPortfolio(ClientPortfolio clientPortfolio) {
        this.clientPortfolio = clientPortfolio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PortfolioPosition that = (PortfolioPosition) o;
        return Objects.equals(id, that.id) && Objects.equals(assetMapping, that.assetMapping) && Objects.equals(clientPortfolio, that.clientPortfolio) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assetMapping, clientPortfolio, quantity);
    }
}
