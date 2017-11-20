package com.lawrencemouarkach;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class HelloResponse {

    private static final String HELLO = "Hello %s, you are %s years old!";
    private ObjectMapper mapper = new ObjectMapper();

    public String responseJson(JsonNode requestJson, Context context) {
        HelloRequest request = new HelloRequest();
        try {
            request = mapper.readValue(requestJson, HelloRequest.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LambdaLogger logger = context.getLogger();
        String responseJson = String.format(HELLO, request.getName(), request.getAge());
        logger.log(responseJson);

        return responseJson;
    }
}
