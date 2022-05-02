package com.example.forumdois.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service

public interface CookieService {

    public static void setCookie(HttpServletResponse response,int segundos){};
    public static String readAllCookies(HttpServletRequest request){return null;};

}
