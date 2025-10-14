package br.com.guiareze.picpay.rest.adapter;

import br.com.guiareze.picpay.core.ports.rest.AuthorizationClient;
import br.com.guiareze.picpay.rest.dto.AuthorizationData;
import br.com.guiareze.picpay.rest.dto.AuthorizationResponse;
import br.com.guiareze.picpay.rest.exception.RestIntegrationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorizationClientImpl implements AuthorizationClient {

    @Value("${api.authorization.url}")
    private String apiAuthorizationUrl;

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    @Override
    public boolean isAuthorized() {
        log.info("Checking authorization status");
        AuthorizationResponse authorizationResponse;
        try{
            authorizationResponse = restClient.get()
                    .uri(apiAuthorizationUrl)
                    .retrieve()
                    .body(AuthorizationResponse.class);
        } catch (HttpClientErrorException exception){
            authorizationResponse = tryToDeserializeErrorResponse(exception.getResponseBodyAsString());
        } catch (Exception exception){
            throw new RestIntegrationException("Error fetching authorization status", exception);
        }

        return Optional.ofNullable(authorizationResponse)
                .map(AuthorizationResponse::data)
                .map(AuthorizationData::authorization)
                .orElseThrow(()  -> new RestIntegrationException("No authorization data found"));
    }

    private AuthorizationResponse tryToDeserializeErrorResponse(String responseBody) {
        AuthorizationResponse authorizationResponse;

        try {
            authorizationResponse =  objectMapper.readValue(responseBody, AuthorizationResponse.class);
        } catch (Exception e) {
            log.error("Failed to deserialize error response: {}", responseBody, e);
            return null;
        }

        return authorizationResponse;
    }

}
