package org.labzin.task.tracker.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RequiredArgsConstructor
@Controller
public class GlobalErrorController implements ErrorController {

    public static final String PATH = "/error";
    public final ErrorAttributes errorAttributes;

    @RequestMapping(GlobalErrorController.PATH)
    public ResponseEntity<ErrorDto> error(WebRequest webRequest) {

        Map<String, Object> attibutes = errorAttributes.getErrorAttributes(webRequest,
                ErrorAttributeOptions.of(
                        ErrorAttributeOptions.Include.EXCEPTION,
                        ErrorAttributeOptions.Include.MESSAGE));
        return ResponseEntity.status((Integer) attibutes.get("status"))
                .body(ErrorDto
                        .builder()
                        .error((String) attibutes.get("error"))
                        .errorDescription((String) attibutes.get("message"))
                        .build());
    }

}
