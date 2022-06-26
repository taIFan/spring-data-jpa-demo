package com.simplilearn.springdatajpademo.repository;

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
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-25
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PortfolioPositionRepositoryTest {

    @Autowired
    PortfolioPositionRepository portfolioPositionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientPortfolioRepository clientPortfolioRepository;

    @Autowired
    AssetMappingRepository assetMappingRepository;


    @Before
    public void initializeTest() {
        Client client = new Client();
        client.setName("my sample client");

        ClientPortfolio clientPortfolio = new ClientPortfolio();
        clientPortfolio.setClient(client);
        clientPortfolio.setName("sample portfolio");
        this.clientRepository.save(client);

        AssetMapping equityLongAssetMapping = new AssetMapping();
        equityLongAssetMapping.setAssetName("Apple");
        equityLongAssetMapping.setAssetType("equity");
        this.assetMappingRepository.save(equityLongAssetMapping);

        PortfolioPosition portfolioPosition = new PortfolioPosition();
        portfolioPosition.setAssetMapping(equityLongAssetMapping);
        portfolioPosition.setQuantity(5.0);
        portfolioPosition.setClientPortfolio(clientPortfolio);
        this.portfolioPositionRepository.save(portfolioPosition);

        List<PortfolioPosition> positionList = new ArrayList<>();
        positionList.add(portfolioPosition);
        clientPortfolio.setPositionList(positionList);

        this.clientPortfolioRepository.save(clientPortfolio);
    }

    @Test
    public void findClientPositionsById() {
        Client client = this.clientRepository.findClientByName("my sample client");
        assertThat(client).isNotNull();
        List<PortfolioPosition> positionListByClient = this.portfolioPositionRepository.findAllPositionsByClientId(client.getId());
        assertThat(positionListByClient).isNotNull().isNotEmpty();
        List<PortfolioPosition> positionListByClientNativeQuery = this.portfolioPositionRepository.findAllPositionsByClientIdNative(client.getId());
        assertThat(positionListByClientNativeQuery).isNotNull().isNotEmpty();
        assertThat(positionListByClientNativeQuery).isEqualTo(positionListByClient);
    }

    @Test
    public void findPortfolioPositions() {
        ClientPortfolio clientPortfolio = this.clientPortfolioRepository.findClientPortfolioByName("sample portfolio");
        assertThat(clientPortfolio).isNotNull();
        assertThat(clientPortfolio.getPositionList()).isNotNull().isNotEmpty();
        List<PortfolioPosition> positionListByPortfolio = this.portfolioPositionRepository.findAllPositionsByPortfolioId(clientPortfolio.getId());
        assertThat(positionListByPortfolio).isNotNull().isNotEmpty();
        assertThat(positionListByPortfolio).isEqualTo(clientPortfolio.getPositionList());
    }

    @Test
    public void findClientPositionsByName() {
        List<PortfolioPosition> positionListByClient = this.portfolioPositionRepository.findAllPositionsByClientName("my sample client");
        assertThat(positionListByClient).isNotNull().isNotEmpty();
    }

}
