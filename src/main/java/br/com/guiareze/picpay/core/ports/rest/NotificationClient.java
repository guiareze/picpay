package br.com.guiareze.picpay.core.ports.rest;

import br.com.guiareze.picpay.core.domain.Transfer;

public interface NotificationClient {

    void sendNotification(Transfer transfer);

}
