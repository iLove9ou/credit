package common.credit.exceptions;


import common.credit.enums.ExceptionEnum;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String code;//异常码

    public BusinessException() {
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ExceptionEnum enumCode) {
        super(enumCode.getName().replaceAll("\\{\\?\\}", ""));
        this.code = enumCode.getCode();
    }

    public BusinessException(ExceptionEnum enumCode, String replaceStr) {
        super(enumCode.getName().replaceAll("\\{\\?\\}", ":" + replaceStr));
        this.code = enumCode.getCode();
    }

    public String getCode() {
        if (null == code) {
            code = ExceptionEnum.SYSTEM_ERROR.getCode();
        }
        return code;
    }
}
