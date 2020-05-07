package com.kevinjanvier.bloodbanksignupservice.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class Utils {

    public static
    Gson prettyJson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
}
