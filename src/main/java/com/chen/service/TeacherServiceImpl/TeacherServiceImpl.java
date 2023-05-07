package com.chen.service.TeacherServiceImpl;

import com.chen.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    @Override

    @PreAuthorize("hasAuthority('teacher:add')")//使用预授权
    public String add() {
      log.info("教师添加成功");
      return "添加成功";

    }


    @Override
    @PreAuthorize("hasAuthority('teacher:update')")
    public String update() {
        log.info("修改教师成功");
        return "修改教师成功";
    }

    @Override
    @PreAuthorize("hasAuthority('teacher:delete')")
    public String delete() {
        log.info("删除教师成功");
        return "删除教师成功";
    }

    @Override
    @PreAuthorize("hasAnyAuthority('teacher:query')")
    public String query() {
        log.info("查询教师成功");
        return "查询教师成功";
    }
}
