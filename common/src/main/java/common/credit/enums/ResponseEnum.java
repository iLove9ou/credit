package common.credit.enums;


public enum ResponseEnum {

    SUCCESS("success", "成功"),
    ERROR("error", "失败"),
    ;

    private String name;
    private String code;

    private ResponseEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(int code) {
        for (ResponseEnum c : ResponseEnum.values()) {
            if (c.getCode().equals(code)) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
