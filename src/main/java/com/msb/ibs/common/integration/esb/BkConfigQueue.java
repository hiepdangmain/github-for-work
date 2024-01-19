package com.msb.ibs.common.integration.esb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BkConfigQueue {
    String queueId;
    String hostName;
    String channel;
    String port;
    String timeout;
    String username;
    String password;
    String queueManager;
    String queueInput;
    String queueOutput;
    String description;
    String headerReqApp;
    String headerAuthorizer;
    String headerPassword;
    String srv;
    String bodyObject;
}
