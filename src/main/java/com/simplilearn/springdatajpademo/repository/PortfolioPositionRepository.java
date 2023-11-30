package com.simplilearn.springdatajpademo.repository;

import com.simplilearn.springdatajpademo.model.PortfolioPosition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-25
 */
@RepositoryRestResource(collectionResourceRel = "portfolio", path = "portfolio")
public interface PortfolioPositionRepository extends PagingAndSortingRepository<PortfolioPosition, Long>, CrudRepository<PortfolioPosition, Long> {

    /**
     * By default Spring data uses jpql
     *
     * @return list of portfolios by client id
     */
    @Query("SELECT pp FROM PortfolioPosition pp WHERE pp.clientPortfolio " +
            "IN (SELECT cp FROM ClientPortfolio cp WHERE cp.client " +
            "IN (SELECT c FROM Client c WHERE c.id = :clientId))")
    List<PortfolioPosition> findAllPositionsByClientId(Long clientId);

    @Query("SELECT pp FROM PortfolioPosition pp WHERE pp.clientPortfolio " +
            "IN (SELECT cp FROM ClientPortfolio cp WHERE cp.client " +
            "IN (SELECT c FROM Client c WHERE c.name = :clientName))")
    List<PortfolioPosition> findAllPositionsByClientName(String clientName);

    @Query(value = "SELECT portfolio_position.id AS id, portfolio_position.asset_mapping_id AS asset_mapping_id, " +
            "portfolio_position.client_portfolio_id AS client_portfolio_id, portfolio_position.quantity AS quantity " +
            "FROM portfolio_position portfolio_position WHERE portfolio_position.client_portfolio_id IN " +
            "(SELECT client_portfolio.id FROM client_portfolio client_portfolio WHERE client_portfolio.client_id IN " +
            "(SELECT client.id FROM client client WHERE client.id=:clientId))", nativeQuery = true)
    List<PortfolioPosition> findAllPositionsByClientIdNative(Long clientId);

    @Query("SELECT pp FROM PortfolioPosition pp WHERE pp.clientPortfolio " +
            "IN (SELECT cp FROM ClientPortfolio cp WHERE cp.id = :portfolioId)")
    List<PortfolioPosition> findAllPositionsByPortfolioId(Long portfolioId);

}
