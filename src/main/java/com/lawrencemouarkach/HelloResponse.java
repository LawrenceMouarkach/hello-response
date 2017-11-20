package com.lawrencemouarkach;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class HelloResponse {

    private static final String HELLO = "Hello %s, you are %s years old!";

    public String responseJson(HelloRequest requestJson, Context context) {
        LambdaLogger logger = context.getLogger();
        String responseJson = String.format(HELLO, requestJson.getName(), requestJson.getAge());
        logger.log(responseJson);

        return responseJson;
    }
}
