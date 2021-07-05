package com.song.dao;

import com.song.pojo.Tms;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TmsDao {


    Tms findTms(Tms tms); //通过账号和密码查询Tms

    int addTms(Tms tms);//添加

    int deleteTms(Integer tmId);//删除

    int updateTms(Tms tms);//修改

    Tms findTmsById(Integer tmId);//根据id号查信息

    List<Tms> getAll();//获取所有管理员信息

    //查询
    int totalCount(@Param("tmsUser") String tmsUser, @Param("tmsName") String tmsName);
    //获取用户列表
    List<Tms> getTmsList(@Param("tmsUser") String tmsUser, @Param("tmsName") String tmsName, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);
}
