package com.simplilearn.springdatajpademo.repository;

import com.simplilearn.springdatajpademo.model.AssetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-19
 */
@Repository
public interface AssetMappingRepository extends JpaRepository<AssetMapping, Long> {

}
