package com.poputchiki.constants;

public interface ApiConstants {

    String API_AUTH_PATH="/auth";
    String API_AUTH_REGISTRATION_PATH="/registration";
    String API_AUTH_LOGIN_PATH="/login";
    String API_AUTH_TOKEN_PATH="/token";
    String API_AUTH_LOGOUT_PATH="/logout";
    String API_TRIPS_PATH="/trips";
    String API_TRIPS_MINE_PATH="my";
    String API_TRIPS_LAST_PATH="latest";
    String API_TRIPS_SEARCH_PATH="search";
    String API_TRIP_ID_PATH="/{TRIP_ID}";
    String API_JOIN_TRIP_BY_ID_PATH="/join";
    String API_NEW_TRIP_PATH="/new";
    String API_VIEW_BY_ID_PATH ="/view";
    String API_DELETE_TRIP_BY_ID_PATH="/delete";
    String API_PLACES_PATH="/places";
    String API_USER_PATH="/user";
    String API_USER_INFO_PATH="/info";
    String API_USER_EDIT_PATH="/edit";
    String API_POPUTCHIKI_PATH = "/poputchiki";
    String API_POPUTCHIKI_ACCEPT_PATH = "/accept";
    String API_POPUTCHIKI_REJECT_PATH = "/reject";
    String API_POPUTCHIK_ID_PATH="/{POPUTCHIK_ID}";
    String API_POPUTCHIK_REQUESTS_PATH="/requests";
    String API_POPUTCHIK_ACCEPTED_REQUESTS_PATH = "/acceptedRequests";
    String API_MESSAGES_PATH = "/message";
    String API_UNREAD_MESSAGES_PATH = "/unread";
    String API_READ_MESSAGES_PATH = "/read";
    String API_DIALOG_ID_PATH="/{DIALOG_ID}";
    String API_DIALOGS_PATH="/dialogs";


    String[] securedPaths = new String[]{API_AUTH_TOKEN_PATH,API_AUTH_LOGOUT_PATH,API_TRIPS_MINE_PATH,API_USER_PATH,API_JOIN_TRIP_BY_ID_PATH,API_NEW_TRIP_PATH,API_DELETE_TRIP_BY_ID_PATH, API_POPUTCHIKI_PATH, API_MESSAGES_PATH};


}
