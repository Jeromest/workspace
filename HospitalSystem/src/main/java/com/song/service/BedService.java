package com.song.service;

import com.song.pojo.Bed;
import com.song.pojo.PageInfo;
import com.song.pojo.Room;

import java.util.List;

public interface BedService {
    int addBed(Bed bed);//添加

    int updateBed(Bed bed);//修改

    Bed findBedById(Integer bedId);//根据id号查询

    List<Bed> getAll();//获取所有床位信息


    List<Bed> findRoomT(Room room); //查询指定房间里的病床、病人信息

    //分页查询
    PageInfo<Bed> findPageInfo(String bedNo, String bedRoomId, Integer pageIndex, Integer pageSize);
}
