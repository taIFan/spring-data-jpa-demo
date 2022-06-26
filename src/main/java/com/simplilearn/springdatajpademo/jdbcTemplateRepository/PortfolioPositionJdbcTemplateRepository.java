package com.simplilearn.springdatajpademo.jdbcTemplateRepository;

import com.simplilearn.springdatajpademo.model.PortfolioPosition;

import java.util.List;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-25
 */
public interface PortfolioPositionJdbcTemplateRepository {

    List<PortfolioPosition> findAllPositionsByClientId(Long clientId);

}
