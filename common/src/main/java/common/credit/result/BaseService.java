
package common.credit.result;

import common.credit.enums.ExceptionEnum;
import common.credit.enums.ResponseEnum;


public class BaseService {

	public ResponseResult getResponseResult(String code,String message,Object data) {
		ResponseResult result = new ResponseResult();
		result.setCode(code);
		result.setMessage(message);
		result.setData(data);
		return result;
	}

	public ResponseResult success() {
		return getResponseResult(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getName(),null);
	}

	public ResponseResult success(Object data) {
		return getResponseResult(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getName(),data);
	}

	public ResponseResult error(String message) {
		return getResponseResult(ResponseEnum.ERROR.getCode(), message, null);
	}

	public ResponseResult error(String code, String message) {
		return getResponseResult(code, message, null);
	}
	
	public ResponseResult error(String code, String message, Object data) {
		return getResponseResult(code, message, data);
	}

	public ResponseResult error(ExceptionEnum exceptionEnum) {
		return getResponseResult(exceptionEnum.getCode(), exceptionEnum.getName(), null);
	}

	public ResponseResult error(ExceptionEnum enumCode, String replaceStr) {
		return getResponseResult(enumCode.getCode(), enumCode.getName().replaceAll("\\{\\?\\}", replaceStr), null);
	}
}
