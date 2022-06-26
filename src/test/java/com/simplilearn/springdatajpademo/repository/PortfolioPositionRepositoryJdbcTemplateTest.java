package com.simplilearn.springdatajpademo.repository;

import com.simplilearn.springdatajpademo.jdbcTemplateRepository.PortfolioPositionJdbcTemplateRepositoryImpl;
import com.simplilearn.springdatajpademo.model.AssetMapping;
import com.simplilearn.springdatajpademo.model.Client;
import com.simplilearn.springdatajpademo.model.ClientPortfolio;
import com.simplilearn.springdatajpademo.model.PortfolioPosition;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-25
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PortfolioPositionRepositoryJdbcTemplateTest {

    @Autowired
    PortfolioPositionRepository portfolioPositionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientPortfolioRepository clientPortfolioRepository;

    @Autowired
    AssetMappingRepository assetMappingRepository;

    @Autowired
    PortfolioPositionJdbcTemplateRepositoryImpl portfolioPositionJdbcTemplateRepository;


    @Before
    public void initializeTest() {
        Client client = new Client();
        client.setName("my sample client");
        this.clientRepository.save(client);

        ClientPortfolio clientPortfolio = new ClientPortfolio();
        clientPortfolio.setClient(client);
        clientPortfolio.setName("sample portfolio");
        this.clientPortfolioRepository.save(clientPortfolio);

        AssetMapping equityLongAssetMapping = new AssetMapping();
        equityLongAssetMapping.setAssetName("Apple");
        equityLongAssetMapping.setAssetType("equity");
        this.assetMappingRepository.save(equityLongAssetMapping);

        PortfolioPosition portfolioPosition = new PortfolioPosition();
        portfolioPosition.setAssetMapping(equityLongAssetMapping);
        portfolioPosition.setQuantity(5.0);
        portfolioPosition.setClientPortfolio(clientPortfolio);
        this.portfolioPositionRepository.save(portfolioPosition);
    }

    @Test
    public void jdbcTemplateAndDataJpaMustHaveSameSize() {
        Client client = this.clientRepository.findClientByName("my sample client");
        assertThat(client).isNotNull();

        List<PortfolioPosition> positionListByClientNativeQuery = this.portfolioPositionRepository.findAllPositionsByClientIdNative(client.getId());
        assertThat(positionListByClientNativeQuery).isNotNull().isNotEmpty();
        List<PortfolioPosition> positionListByClient = this.portfolioPositionJdbcTemplateRepository.findAllPositionsByClientId(client.getId());
        assertThat(positionListByClient).isNotNull().isNotEmpty();
        assertThat(positionListByClientNativeQuery.size()).isEqualTo(positionListByClient.size());
    }

}
