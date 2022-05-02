package com.example.forumdois.service.impl;

import com.example.forumdois.service.CookieService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CookieServiceImpl implements CookieService {

    public static void setCookie(HttpServletResponse response, int segundos) {
        Cookie cookie = new Cookie("chave", "valor");
        cookie.setMaxAge(segundos);
        //add cookie to response
        response.addCookie(cookie);
    }

    public static String readAllCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
        }

        return "No cookies";
    }

}




