package com.simplilearn.springdatajpademo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-25
 */
@Entity
public class AssetMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String assetType;
    private String assetName;

    public AssetMapping() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssetMapping that = (AssetMapping) o;
        return Objects.equals(id, that.id) && Objects.equals(assetType, that.assetType) && Objects.equals(assetName, that.assetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assetType, assetName);
    }
}
