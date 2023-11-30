package com.simplilearn.springdatajpademo;

import com.simplilearn.springdatajpademo.model.Client;
import com.simplilearn.springdatajpademo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@ComponentScan(basePackages = "com.simplilearn.springdatajpademo.*")
public class SpringDataJpaDemoApplication {

    private final ClientRepository clientRepository;

    @Autowired
    public SpringDataJpaDemoApplication(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        Client client = new Client();
        client.setName("Client 1");
        clientRepository.save(client);
        Client client2 = new Client();
        client2.setName("Client 2");
        clientRepository.save(client2);
    }

}
