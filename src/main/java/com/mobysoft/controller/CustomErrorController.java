package com.mobysoft.controller;

import com.mobysoft.model.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Value("${custom-error-controller.debug}")
    private boolean debug;

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH)
    ResponseEntity<CustomError> getError(HttpServletRequest request, WebRequest webRequest){

        Map<String, Object> errorAttributes = getErrorAttributes(request, webRequest, debug);

        return ResponseEntity.status((int)errorAttributes.get("status"))
                .body(new CustomError(getErrorAttributes(request, webRequest, debug)));
    }

    @Override
    public String getErrorPath() {
        return this.PATH;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, WebRequest webRequest,
                                                   boolean includeStackTrace) {

        return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);

    }

}
