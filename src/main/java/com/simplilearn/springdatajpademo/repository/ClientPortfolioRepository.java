package com.simplilearn.springdatajpademo.repository;

import com.simplilearn.springdatajpademo.model.ClientPortfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-25
 */
@Repository
public interface ClientPortfolioRepository extends CrudRepository<ClientPortfolio, Long> {

    ClientPortfolio findClientPortfolioByName(String name);
}
