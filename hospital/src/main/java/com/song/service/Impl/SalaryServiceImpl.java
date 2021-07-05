package com.song.service.Impl;

import com.song.dao.SalaryDao;
import com.song.pojo.PageInfo;
import com.song.pojo.Salary;
import com.song.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryDao salaryDao;

    public int addSalary(Salary salary) {
        return salaryDao.addSalary(salary);
    }

    public int updateSalary(Salary salary) {
        return salaryDao.updateSalary(salary);
    }

    public Salary findSalaryById(Integer salaryId) {
        return salaryDao.findSalaryById(salaryId);
    }

    public List<Salary> getAll() {
        return salaryDao.getAll();
    }

    public PageInfo<Salary> findPageInfo(String salaryNo, String salaryName, Integer pageIndex, Integer pageSize) {
        PageInfo<Salary> pi = new PageInfo<Salary>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = salaryDao.totalCount(salaryNo,salaryName);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示管理员信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Salary> salaryList = salaryDao.getSalaryList(salaryNo,salaryName,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(salaryList);
        }
        return pi;
    }
}
