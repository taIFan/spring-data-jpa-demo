package com.simplilearn.springdatajpademo.repository;

import com.simplilearn.springdatajpademo.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-25
 */
@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends PagingAndSortingRepository<Client, Long>, CrudRepository<Client, Long> {

    Client findClientByName(String name);

}
