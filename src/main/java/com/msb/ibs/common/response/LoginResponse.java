package com.msb.ibs.common.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("access_token")
    @SerializedName("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    @SerializedName("expires_in")
    private Integer expiresIn;

    @JsonProperty("refresh_expires_in")
    @SerializedName("refresh_expires_in")
    private Integer refreshExpiresIn;

    @JsonProperty("refresh_token")
    @SerializedName("refresh_token")
    private String refreshToken;

    @JsonProperty("token_type")
    @SerializedName("token_type")
    private String tokenType;

    @JsonProperty("not-before-policy")
    @SerializedName("not-before-policy")
    private Integer notBeforePolicy;

    @JsonProperty("session_state")
    @SerializedName("session_state")
    private String sessionState;

    private String scope;

}
