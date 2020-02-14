package top.inewbie.service;

import top.inewbie.pojo.AllCourses;
import top.inewbie.pojo.Course;
import top.inewbie.pojo.SelectedCourse;
import top.inewbie.pojo.SubmittedCourse;

import java.util.List;

public interface CourseService {


    void addCourseSelection(String userId, String courseId) ;

    void deleteCourseSelection(String userId, String courseId) ;
}
