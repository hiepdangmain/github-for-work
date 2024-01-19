package com.msb.ibs.common.exception;

import com.msb.ibs.common.base.BaseErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

public class LogicException extends Exception {
    private static final long serialVersionUID = 1L;

    private Object[] args;
    private BaseErrorCode baseErrorCode;
    private String detailMessage;
    private String debugMessage;

    public LogicException() {
        super();
    }

    public LogicException(String message) {
        super(message);
        this.detailMessage = message;
        this.debugMessage = message;
    }

    public LogicException(BaseErrorCode baseErrorCode) {
        super();
        this.debugMessage = baseErrorCode.getMessage();
        this.baseErrorCode = baseErrorCode;
    }

    public LogicException(String message, BaseErrorCode baseErrorCode) {
        super(message);
        this.detailMessage = message;
        this.baseErrorCode = baseErrorCode;
    }

    public LogicException(String message, String debugMessage, BaseErrorCode baseErrorCode) {
        super(message);
        this.detailMessage = message;
        this.debugMessage = debugMessage;
        this.baseErrorCode = baseErrorCode;
    }

    public LogicException(BaseErrorCode baseErrorCode, Object[] args) {
        this.baseErrorCode = baseErrorCode;
        this.args = args;
    }

    public LogicException(String message, BaseErrorCode baseErrorCode, Object[] args) {
        super(message);
        this.debugMessage = message;
        this.baseErrorCode = baseErrorCode;
        this.args = args;
    }

    public LogicException(String message, String debugMessage, BaseErrorCode baseErrorCode, Object[] args) {
        super(message);
        this.detailMessage = message;
        this.debugMessage = debugMessage;
        this.baseErrorCode = baseErrorCode;
        this.args = args;
    }

    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public Object[] getArgs() {
        return args;
    }

    public String getCode() {
        return this.baseErrorCode != null ? this.baseErrorCode.getCode() : "400";
    }

    public String getMessage() {
        if (this.baseErrorCode != null) {
            return StringUtils.isEmpty(this.baseErrorCode.getMessage()) ? this.detailMessage : this.baseErrorCode.getMessage();
        }
        return this.debugMessage;
    }

    public HttpStatus getHttpStatus() {
        return this.baseErrorCode != null ? this.baseErrorCode.getHttpStatus() : HttpStatus.BAD_REQUEST;
    }

    public String getDebugMessage() {
        return this.debugMessage;
    }
}
