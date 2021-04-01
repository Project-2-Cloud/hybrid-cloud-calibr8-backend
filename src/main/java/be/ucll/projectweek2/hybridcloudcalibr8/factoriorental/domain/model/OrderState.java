package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model;

public enum OrderState {
    SHOPPING("shopping"), ORDER_DETAILS("details"), PAYMENT("payment"), DELIVERED("delivered");

    private final String value;

    OrderState(String value) {
        this.value = value;
    }

    public static OrderState StateOfValue(String value) {
        for (OrderState e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }

}
