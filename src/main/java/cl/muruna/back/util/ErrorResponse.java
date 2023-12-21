package cl.muruna.back.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ErrorResponse {

    @Getter
    private String message;

    @Getter
    private int code;
    
    @Getter
    private String moreInfo;
}
