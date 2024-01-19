package com.msb.ibs.common.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.msb.ibs.common.utils.CommonStringUtils;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipal implements UserDetails {

    private Integer userId;
    private String username;
    private Integer corpId;
    private Integer roleId;
    private String corpName;
    private String cifNo;
    private String email;
    private String mobile;
    private String loginFlag;
    private String securityType;
    private String orgId;
    private String certCode;
    private String nick;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(AuthInfo authInfo){
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(!CollectionUtils.isEmpty(authInfo.getAuthorities()))
            authorities = authInfo.getAuthorities()
                    .stream().map(o -> new SimpleGrantedAuthority(o))
                    .collect(Collectors.toList());
        return new UserPrincipal(authInfo.getUserId(),
                authInfo.getUserName(), authInfo.getCorpId(), authInfo.getRoleId(),
                authInfo.getCorpName(), authInfo.getCifNo(), authInfo.getEmail(), authInfo.getMobile(),
                authInfo.getLoginFlag(), authInfo.getSecurityType(), authInfo.getOrgId(),authInfo.getCertCode(), authInfo.getNick(), authorities);
    }

    @Override
    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public boolean isCustomer() {
        return !CommonStringUtils.isNullOrEmpty(cifNo);
    }
}
