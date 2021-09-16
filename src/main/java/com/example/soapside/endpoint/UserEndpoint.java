package com.example.soapside.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.soapside.service.UserService;
import com.soap_side.GetUserRequest;
import com.soap_side.GetUserResponse;


@Endpoint
public class UserEndpoint {
    @Autowired
    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }
    @PayloadRoot(namespace = "http://soap_side.com",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request){
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUser(request.getName()));
        return  response;
    }

}
