package com.beesion.ms.util;

import com.beesion.ms.dto.PolicyDomainDto;

public class PolicyValidator {
    public static void validate(PolicyDomainDto policy) {
        if (policy.getMinLength() < 4) {
            throw new IllegalArgumentException("La longitud de la contraseña debe ser al menos 4 caracteres.");
        }
    }
}