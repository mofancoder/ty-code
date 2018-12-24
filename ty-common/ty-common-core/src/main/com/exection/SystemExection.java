package com.exection;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 系统异常
 */
@Data
public class SystemExection extends RuntimeException{

    private String code;

    private String message;

    public SystemExection(){

    }

}
