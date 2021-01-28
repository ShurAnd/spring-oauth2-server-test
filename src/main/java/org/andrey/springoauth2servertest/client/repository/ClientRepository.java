package org.andrey.springoauth2servertest.client.repository;

import java.util.Optional;

import org.andrey.springoauth2servertest.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	public Optional<Client> findClientByClientId(String clientId);
}
