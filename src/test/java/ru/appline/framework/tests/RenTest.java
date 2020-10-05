package ru.appline.framework.tests;

import org.junit.jupiter.api.Test;
import ru.appline.framework.base.BaseClass;
import ru.appline.framework.utils.Parameters;

public class RenTest extends BaseClass {

    @Test
    void renRubleTest() {
        app.getStartPage()
                .selectServicesList(Parameters.Services.DEPOSITS)
                .selectCurrency(Parameters.Currency.RUBLE)
                .fillForm("300000", Parameters.TimeDeposit.FOR_6_MONTHS, "50000", Parameters.Tick._ON)
                .expectedResults("8 490,49", "250 000", "558 490,49");
    }

    @Test
    void renDollarTest() {
        app.getStartPage()
                .selectServicesList(Parameters.Services.DEPOSITS)
                .selectCurrency(Parameters.Currency.DOLLAR)
                .fillForm("500000", Parameters.TimeDeposit.FOR_9_MONTHS, "30000", Parameters.Tick._ON)
                .expectedResults("690,81", "240 000", "740 690,81");
    }
}
