package br.com.guiareze.picpay.rest.adapter;

import br.com.guiareze.picpay.core.domain.Transfer;
import br.com.guiareze.picpay.core.ports.rest.NotificationClient;
import br.com.guiareze.picpay.rest.exception.RestIntegrationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationClientImpl implements NotificationClient {

    @Value("${api.notification.url}")
    private String apiNotificationUrl;

    private final RestClient restClient;

    @Override
    public void sendNotification(Transfer transfer) {
        log.info("Sending notification for transfer: {}", transfer.toString());

        try{
            restClient.post()
                    .uri(apiNotificationUrl)
                    .body(transfer)
                    .retrieve()
                    .toBodilessEntity();
            log.info("Notification sent successfully for transfer: {}", transfer.toString());
        } catch (Exception exception){
            log.error("Error sending notification for transfer: {}", transfer.toString(), exception);
//            throw new RestIntegrationException("Error sending notification", exception);
        }
    }

}
