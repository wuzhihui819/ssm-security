package org.lanqiu.mapper;

import org.lanqiu.entity.Security;

public interface SecurityMapper {
    Security  queryBySecurityId(String securityid);
    void  updateById(Integer id);
}