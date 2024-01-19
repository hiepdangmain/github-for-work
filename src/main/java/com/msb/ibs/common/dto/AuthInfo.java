package com.msb.ibs.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String currentTranSn;
    private Integer userId;
    private String userName;
    private Integer corpId;
    private Integer roleId;
    private String corpName;
    private String loginFlag;
    private List<OutputMenu> menus;
    private List<String> authorities;
    private String securityType;
    private String expiration;
    private Long expire;
    private String refreshToken;
    private Long expireRefresh;
    private String refreshTime;
    private String email;
    private String mobile;
    private String cifNo;
    private String orgId;
    private String certCode;
    private String nick;

    public AuthInfo(String userName, Integer userId, Integer corpId, Integer roleId, String corpName, String loginFlag,
                    String securityType, List<OutputMenu> menus, List<String> authorities, String email, String mobile, String cifNo) {
        this.userName = userName;
        this.userId = userId;
        this.corpId = corpId;
        this.roleId = roleId;
        this.corpName = corpName;
        this.securityType = securityType;
        this.authorities = authorities;
        this.menus = menus;
        this.loginFlag = loginFlag;
        this.email = email;
        this.mobile = mobile;
        this.cifNo = cifNo;
    }

}