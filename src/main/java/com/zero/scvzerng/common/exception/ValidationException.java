package com.zero.scvzerng.common.exception;

import com.zero.scvzerng.common.response.GenericResponse;
import lombok.Data;

import java.util.List;

/**
 * 校验失败
 * <p>
 * 2017-12-29 09:39
 *
 * @author scvzerng
 **/
@Data
public class ValidationException extends AbstractException {
    private List<GenericResponse.FieldError> fieldErrors;
    public ValidationException(List<GenericResponse.FieldError> fieldErrors) {
        super(700, "参数校验失败", null);
        this.fieldErrors = fieldErrors;
    }
}
