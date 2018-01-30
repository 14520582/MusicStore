package com.musicstore.util;


public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Token";
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 10*24*60*60;
    public static final String SIGNING_KEY = "musicstore123";
}
