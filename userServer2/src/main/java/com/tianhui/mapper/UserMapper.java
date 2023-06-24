package com.tianhui.mapper;


import com.tianhui.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from users where userId=#{userId} and password=#{password}")
    public User getUserByIdByPass(User user);

    @Select("select * from users where userId=#{userId}")
    public User getUserById(String userId);

    @Insert("insert into users values(#{userId},#{password},#{userName},#{userSex},null,1)")
    public int saveUser(User user);
}