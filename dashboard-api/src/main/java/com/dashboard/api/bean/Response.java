package com.dashboard.api.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author LEBOC Philippe
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public final class Response {
    private Object payload;
}
