package ru.kataproject.p_sm_airlines_1.entity.Enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum CategorySeat {

    BUSINESS("Business",true, true, true, true,
            true, true),
    ECONOMY("Economy", true,false,true, false,
            true, false);

    private final String category;
    private final boolean cabinBaggage;
    private final boolean checkedBaggageAllowance;
    private final boolean mealBeverage;
    private final boolean standardSeatSelection;
    private final boolean changeWithoutFee;
    private final boolean refundPossible;

}
