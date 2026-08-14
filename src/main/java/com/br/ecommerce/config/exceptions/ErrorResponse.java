package com.br.ecommerce.config.exceptions;

public record ErrorResponse(
        int code,
        String message
) {
}
