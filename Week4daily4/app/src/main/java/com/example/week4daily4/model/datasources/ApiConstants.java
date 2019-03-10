package com.example.week4daily4.model.datasources;

public class ApiConstants {
    static final String BASE_URL = "https://api.flickr.com/";
    static final String REST_API = "services/rest/";
    static final String METHOD = "method";
    static final String API_KEY = "api_key";
    static final String TEXT = "text";
    static final String PER_PAGE = "per_page";
    static final String FORMAT = "format";
    static final String NO_JSON_CALLBACK = "nojsoncallback";

    // API constant values
    static final String METHOD_VAL = "flickr.photos.search";
    static final String API_KEY_VAL = "6bf318919bbbc455f3573d18798a58e3";
    static final String PER_PAGE_VAL = "100";
    static final String FORMAT_VAL = "json";
    static final String NO_CALLBACK_VAL = "1";

    // URL TO GET PHOTO WITH GIVEN PARAMETERS
    public static final String BUILD_PHOTO = "http://farm%s.static.flickr.com/%s/%s_%s.jpg";
}
