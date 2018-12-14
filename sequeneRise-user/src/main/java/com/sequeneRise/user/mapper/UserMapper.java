package com.sequeneRise.user.mapper;

import com.sequeneRise.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insert(User user);
}
