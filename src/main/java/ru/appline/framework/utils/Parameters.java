package ru.appline.framework.utils;

public class Parameters {
    public enum Services {
        CARDS("Карты"), CREDITS("Кредиты"), DEPOSITS("Вклады");

        private String titleService;

        Services(String titleService) {
            this.titleService = titleService;
        }

        public String getTitleService() {
            return titleService;
        }
    }

    public enum Currency {
        RUBLE("Рубли"), DOLLAR("Доллары США");

        private String titleCurrency;

        Currency(String titleCurrency) {
            this.titleCurrency = titleCurrency;
        }

        public String getTitleCurrency() {
            return titleCurrency;
        }
    }

    public enum TimeDeposit {
        FOR_3_MONTHS("3 месяца"),
        FOR_6_MONTHS( "6 месяцев"),
        FOR_9_MONTHS("9 месяцев"),
        FOR_12_MONTHS("12 месяцев"),
        FOR_13_MONTHS("13 месяцев"),
        FOR_18_MONTHS("18 месяцев");

        private String titleTimeDeposit;

        TimeDeposit(String titleTimeDeposit) {
            this.titleTimeDeposit = titleTimeDeposit;
        }

        public String getTitleTimeDeposit() {
            return titleTimeDeposit;
        }
    }

    public enum Tick {
        _ON(true), _OFF(false);
        private boolean stateTick;

        public boolean isStateTick() {
            return stateTick;
        }

        Tick(boolean stateTick) {
            this.stateTick = stateTick;
        }
    }
}
