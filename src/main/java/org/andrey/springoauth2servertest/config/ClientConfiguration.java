package org.andrey.springoauth2servertest.config;

import java.util.Collections;
import java.util.Optional;

import org.andrey.springoauth2servertest.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

@Configuration
public class ClientConfiguration {

	private ClientRepository clientRepository;

	@Autowired
	public ClientConfiguration(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Bean
	public ClientDetailsService clientDetailsService() {
		return (clientId) -> clientRepository.findClientByClientId(clientId).map(client -> {
			BaseClientDetails details = new BaseClientDetails(client.getClientId(), null, client.getScopes(),
					client.getAuthorizedGrantTypes(), client.getAuthorities());
			details.setClientSecret(client.getSecret());
			details.getAuthorizedGrantTypes().add("password");
			String clientRedirectUri = "http://localhost:8080/test-redirect";
			details.setRegisteredRedirectUri(Collections.singleton(clientRedirectUri));
			return details;
		}).orElseThrow(() -> new ClientRegistrationException(String.format("no client %s registered", clientId)));
		
	}
}
