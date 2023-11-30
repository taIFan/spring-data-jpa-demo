package com.simplilearn.springdatajpademo.repository;

import com.simplilearn.springdatajpademo.model.ClientPortfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-25
 */
@RepositoryRestResource(collectionResourceRel = "clientPortfolio", path = "clientPortfolio")
public interface ClientPortfolioRepository extends PagingAndSortingRepository<ClientPortfolio, Long>, CrudRepository<ClientPortfolio, Long> {

    ClientPortfolio findClientPortfolioByName(String name);
}
