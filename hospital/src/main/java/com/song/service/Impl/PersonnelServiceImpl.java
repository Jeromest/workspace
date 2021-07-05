package com.song.service.Impl;

import com.song.dao.PersonnelDao;
import com.song.pojo.PageInfo;
import com.song.pojo.Personnel;
import com.song.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personnelService")
public class PersonnelServiceImpl implements PersonnelService {
    @Autowired
    private PersonnelDao personnelDao;

    public int addPersonnel(Personnel personnel) {
        return personnelDao.addPersonnel(personnel);
    }

    public int deletePersonnel(Integer empId) {
        return personnelDao.deletePersonnel(empId);
    }

    public int updatePersonnel(Personnel personnel) {
        return personnelDao.updatePersonnel(personnel);
    }

    public Personnel findPersonnelById(Integer empId) {
        return personnelDao.findPersonnelById(empId);
    }

    public List<Personnel> getAll() {
        return personnelDao.getAll();
    }

    public PageInfo<Personnel> findPageInfo(String empNo, String empName, Integer pageIndex, Integer pageSize) {
        PageInfo<Personnel> pi = new PageInfo<Personnel>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = personnelDao.totalCount(empNo,empName);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示管理员信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Personnel> personnelList = personnelDao.getPersonnelList(empNo,empName,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(personnelList);
        }
        return pi;
    }
}
