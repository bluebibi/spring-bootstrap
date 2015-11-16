package com.thinkonweb.domesticConf.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ConferenceMapper {
    @Select("show databases")
    public List<String> test();
}
