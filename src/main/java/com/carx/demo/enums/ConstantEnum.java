package com.carx.demo.enums;

import java.util.HashMap;
import java.util.Map;

public enum ConstantEnum {

    MAX_CATEGORY_LIMIT("Max 3 kateqoriya seçmək olar."),
    ALREADY_SPUN_THIS_MONTH("Bu ay artıq seçim etmisiniz."),
    NOT_CHOSEN_CATEGORY("Heç bir kateqoriya seçilməyib");

    private final String message;

    ConstantEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

