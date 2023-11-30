package com.simplilearn.springdatajpademo.repository;

import com.simplilearn.springdatajpademo.model.AssetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-25
 */
@RepositoryRestResource(collectionResourceRel = "clientPortfolio", path = "clientPortfolio")
public interface AssetMappingRepository extends PagingAndSortingRepository<AssetMapping, Long>, JpaRepository<AssetMapping, Long> {

}
