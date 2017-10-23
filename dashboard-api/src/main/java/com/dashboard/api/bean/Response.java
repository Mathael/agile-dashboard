package com.dashboard.api.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Leboc Philippe.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public final class Response {
    private ResponseStatus status;
    private String message;
    private Object payload;

    public Response(ResponseStatus status) {
        this(status, null, null);
    }

    public Response(ResponseStatus status, String message) {
        this(status, message, null);
    }

    public enum ResponseStatus {
        SUCCESS, ERROR
    }
}
