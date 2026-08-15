package com.br.ecommerce.modules.comum.exceptions;

public record ErrorResponse(
        int code,
        String message
) {
}
