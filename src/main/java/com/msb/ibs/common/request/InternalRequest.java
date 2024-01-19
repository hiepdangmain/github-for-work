package com.msb.ibs.common.request;

import com.msb.ibs.common.dto.UserPrincipal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternalRequest {
    private Object data;
    private UserPrincipal userPrincipal;
    private String token;
    private String language;
    private String channel;

    public InternalRequest(Object data, UserPrincipal userPrincipal, String token) {
        this.data = data;
        this.userPrincipal = userPrincipal;
        this.token = token;
    }
    
    public InternalRequest(Object data, UserPrincipal userPrincipal, String token, String channel) {
        this.data = data;
        this.userPrincipal = userPrincipal;
        this.token = token;
        this.channel = channel;
    }
}
