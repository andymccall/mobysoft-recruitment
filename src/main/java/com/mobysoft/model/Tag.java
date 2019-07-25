package com.mobysoft.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value="Tag", description="Transaction type")
public enum Tag {
    CHARGE("Charge"),
    RENT("Rent"),
    PAYMENT("Payment"),
    CASH("Cash"),
    HOUSING_BENEFIT("HousingBenefit");

    private final String displayName;

    Tag(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
