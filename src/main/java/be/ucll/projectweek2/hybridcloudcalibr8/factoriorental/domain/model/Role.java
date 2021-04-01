package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model;

public enum Role {
    DEV("dev"), ADMIN("admin"), USER("user");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
