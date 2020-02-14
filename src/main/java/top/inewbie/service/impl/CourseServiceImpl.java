package top.inewbie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.inewbie.Main;
import top.inewbie.dao.CourseMapper;
import top.inewbie.pojo.AllCourses;
import top.inewbie.pojo.Course;
import top.inewbie.pojo.SelectedCourse;
import top.inewbie.pojo.SubmittedCourse;
import top.inewbie.service.CourseService;

import java.util.List;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper ;


    @Override
    public void addCourseSelection(String userId, String courseId) {
        System.out.println("in courseServiceImpl:"+courseMapper+" "+userId+" "+courseId);
        courseMapper.insertSelectedCourse(userId,courseId);
        System.out.println("插入后返回值：");
    }

    @Override
    public void deleteCourseSelection(String userId, String courseId) {
        courseMapper.deleteSelectedCourse(userId,courseId);
    }
}
