package com.poputchiki.constants;

public interface ApiConstants {

    String API_AUTH_PATH="/auth";
    String API_AUTH_REGISTRATION_PATH="/registration";
    String API_AUTH_LOGIN_PATH="/login";
    String API_AUTH_TOKEN_PATH="/token";
    String API_AUTH_LOGOUT_PATH="/logout";
    String API_TRIPS_PATH="/trips";
    String API_TRIPS_MINE_PATH="mine=true";
    String API_TRIPS_LAST_PATH="latest=true";
    String API_TRIP_ID_PATH="/{TRIP_ID}";
    String API_PLACES_PATH="/places";
    String API_USER_PATH="/user";
    String API_USER_INFO_PATH="/info";
    String API_USER_EDIT_PATH="/edit";


    String[] mas = new String[]{API_AUTH_TOKEN_PATH,API_AUTH_LOGOUT_PATH,API_TRIPS_MINE_PATH,API_USER_PATH};


}
