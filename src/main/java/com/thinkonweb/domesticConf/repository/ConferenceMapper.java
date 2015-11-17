package com.thinkonweb.domesticConf.repository;

import com.thinkonweb.domesticConf.domain.Conference;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceMapper {
    @Select("show databases")
    List<String> test();

    @Insert("INSERT INTO domesticConf.conference (nameId, name, hostingInstitution, location, submissionDueDate," +
            " conferenceStartDate, conferenceEndDate, creationTime) VALUES (#{nameId}, #{name}, #{hostingInstitution}, #{location}," +
            " #{submissionDueDate, javaType=java.sql.Date, jdbcType=DATE}," +
            " #{conferenceStartDate, javaType=java.sql.Date, jdbcType=DATE}," +
            " #{conferenceEndDate, javaType=java.sql.Date, jdbcType=DATE}," +
            " #{creationTime, javaType=java.sql.Timestamp, jdbcType=TIMESTAMP})")
    @SelectKey(statement = "select @@identity", keyProperty = "id", before = false, resultType = int.class)
    void insert(Conference conference);

    @Update("UPDATE domesticConf.conference SET nameId = #{nameId}, name = #{name}," +
            " hostingInstitution = #{hostingInstitution}, location = #{location}"  +
            " submissionDueDate = #{metaSaveTimestamp, javaType=java.sql.Timestamp, jdbcType=TIMESTAMP}," +
            " conferenceStartDate = #{conferenceStartDate, javaType=java.sql.Date, jdbcType=DATE}," +
            " conferenceEndDate = #{conferenceEndDate, javaType=java.sql.Date, jdbcType=DATE}," +
            " creationTime = #{creationTime, javaType=java.sql.Timestamp, jdbcType=TIMESTAMP}" +
            " WHERE id = #{id}")
    void update(Conference conference);

    @Select("SELECT * FROM domesticConf.conference WHERE nameId = #{nameId}")
    Conference getConferenceByNameId(@Param("nameId") String nameId);
}
