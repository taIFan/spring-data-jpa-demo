package com.simplilearn.springdatajpademo.repository;

import com.simplilearn.springdatajpademo.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pavel Tikhomirov
 * @since 2022-06-25
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    Client findClientByName(String name);

}
