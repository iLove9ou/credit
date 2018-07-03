package common.credit.enums;


public enum ExceptionEnum {

    SYSTEM_ERROR("10000","系统错误"),
    ;

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private ExceptionEnum() {}

    private ExceptionEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(String code) {
        ExceptionEnum[] exCeptionEnums = ExceptionEnum.values();
        for (ExceptionEnum exceptionEnum : exCeptionEnums) {
            if (code.equals(exceptionEnum.getCode())) {
                return exceptionEnum.getName();
            }
        }
        return code;
    }
}
