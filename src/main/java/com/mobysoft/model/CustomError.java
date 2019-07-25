package com.mobysoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

@ApiModel(value="CustomError", description="Model that contains details about a request or server error")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomError {

    @ApiModelProperty(value = "HTTP status code of the error")
    private Integer status;

    @ApiModelProperty(value = "The error type")
    private String error;

    @JsonIgnore
    private String message;

    @ApiModelProperty(value = "The time of the error")
    private String timeStamp;

    @ApiModelProperty(value = "If enabled via config, the stack trace of the error")
    private String trace;

    public CustomError() {

    }

    public CustomError(Map<String, Object> errorAttributes) {
        this.status = (int) errorAttributes.get("status");
        this.error = (String) errorAttributes.get("error");
        this.message = (String) errorAttributes.get("message");
        this.timeStamp = errorAttributes.get("timestamp").toString();
        this.trace = (String) errorAttributes.get("trace");
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    @Override
    public String toString() {
        return "CustomError{" +
                "status=" + status +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", trace='" + trace + '\'' +
                '}';
    }
}
