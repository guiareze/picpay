package br.com.guiareze.picpay.rest.dto;

public record AuthorizationResponse(
        String status,
        AuthorizationData data) {}