package com.simplilearn.springdatajpademo.jdbcTemplateRepository;

import com.simplilearn.springdatajpademo.model.PortfolioPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-25
 */
@Repository
public class PortfolioPositionJdbcTemplateRepositoryImpl implements PortfolioPositionJdbcTemplateRepository {

    private static final String FIND_ALL_POSITIONS_BY_CLIENT_ID_SQL = "SELECT portfolio_position.id AS id, " +
            "portfolio_position.asset_mapping_id AS asset_mapping_id, " +
            "portfolio_position.client_portfolio_id AS client_portfolio_id, " +
            "portfolio_position.quantity AS quantity FROM portfolio_position portfolio_position " +
            "WHERE portfolio_position.client_portfolio_id IN " +
            "(SELECT client_portfolio.id FROM client_portfolio client_portfolio " +
            "WHERE client_portfolio.client_id IN (SELECT client.id FROM client client WHERE client.id=?1))";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PortfolioPositionJdbcTemplateRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PortfolioPosition> findAllPositionsByClientId(Long clientId) {
        return jdbcTemplate.query(FIND_ALL_POSITIONS_BY_CLIENT_ID_SQL,
                BeanPropertyRowMapper.newInstance(PortfolioPosition.class), clientId);
    }

    @Override
    public List<PortfolioPosition> findAllPositionsByClientIdCustomObjectMapper(Long clientId) {
        return jdbcTemplate.query(FIND_ALL_POSITIONS_BY_CLIENT_ID_SQL,
                new RowMapperResultSetExtractor<>((rs, rowNum) -> {
                    PortfolioPosition portfolioPosition = new PortfolioPosition();
                    portfolioPosition.setId(rs.getLong("id"));
                    portfolioPosition.setQuantity(rs.getDouble("quantity"));
                    //Add client ClientPortfolioRepository
                    //Lookup ClientPortfolio and set is as object
                    //Add AssetMappingRepository repository
                    //Lookup AssetMapping and set is as object
                    return portfolioPosition;
                }), clientId);
    }
}
