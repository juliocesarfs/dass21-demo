package com.cis.dass21.domain.participant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumDASS21Classification {

    NO_SYMPTOMS("0 - Sem sintomas"),
    MILD_SYMPTOMS("1 - Sintomas leves"),
    MODERATE_SYMPTOMS("2 - Sintomas moderados"),
    SEVERE_SYMPTOMS("3 - Sintomas graves"),
    VERY_SERIOUS_SYMPTOMS("4 - Sintomas muito graves");

    private final String classification;
}
