package challengeStream;

public enum SexEnum {
    MALE("male"),
    FEMALE("female");

    private String value;
    SexEnum(String value) {
        this.value=value;
    }

    public String getValue(){return this.value;}
}
