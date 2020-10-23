package com.example.fun;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class FunController {

    private final Map<FunType, Fun> someFun;
    private final MessageSource messageSource;

    public FunController(Map<FunType, Fun> someFun, MessageSource messageSource) {
        this.someFun = someFun;
        this.messageSource = messageSource;
    }

    @GetMapping("/fun")
    public List<FunResponse> getSomeFun(Locale locale) {
        return someFun.entrySet().stream()
                .map((entry) -> new FunResponse(locale.getLanguage(), entry.getKey(), translate(entry.getValue(), locale)))
                .collect(Collectors.toList());
    }

    private String translate(Fun fun, Locale locale) {
        String messageKey = fun.getName();
        Object[] optionalArguments = fun.getSummary() != null ? new String[]{fun.getSummary()} : null;
        return messageSource.getMessage(messageKey, optionalArguments, locale);
    }

    static class FunResponse {
        private String language;
        private FunType funType;
        private String funName;

        public FunResponse(String language, FunType funType, String funName) {
            this.language = language;
            this.funType = funType;
            this.funName = funName;
        }

        public String getLanguage() {
            return language;
        }

        public FunType getFunType() {
            return funType;
        }

        public String getFunName() {
            return funName;
        }
    }

}
