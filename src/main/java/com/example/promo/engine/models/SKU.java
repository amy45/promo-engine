package com.example.promo.engine.models;

import com.example.promo.engine.enums.SKUTYPE;
import lombok.Data;

/**
 * @author Amit Jethwani
 */
@Data
public class SKU {
    private SKUTYPE name;
    private long price;

    public SKU(SKUTYPE name) {
        this.name = name;
    }
}