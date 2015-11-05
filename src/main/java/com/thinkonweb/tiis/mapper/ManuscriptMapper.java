package com.thinkonweb.tiis.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ManuscriptMapper {
    @Select("show databases")
    public List<String> test();
}
