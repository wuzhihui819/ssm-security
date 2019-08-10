package org.lanqiu.service;

import org.lanqiu.entity.Security;
import org.lanqiu.mapper.SecurityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    private SecurityMapper securityMapper;

    public Security queryBySecurityId(String securityid){
        Security security = securityMapper.queryBySecurityId(securityid);
        return security;
    }

    public void updateById(Integer id){
        securityMapper.updateById(id);
    }
}
