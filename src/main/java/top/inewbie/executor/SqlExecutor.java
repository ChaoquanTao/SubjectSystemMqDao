package top.inewbie.executor;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.inewbie.pojo.MsgTopic;
import top.inewbie.pojo.SelectedCourse;
import top.inewbie.service.CourseService;
import top.inewbie.service.impl.CourseServiceImpl;

@Component
public class SqlExecutor {

    @Autowired
    private CourseService courseService ;

    public void execute(MessageExt messageExt){
        switch (messageExt.getTopic()){
            case MsgTopic
                    .SUBJECT_SELECTION_INSERTION:
                SelectedCourse selectedCourse = (SelectedCourse)JSON.
                        parseObject(messageExt.getBody(), SelectedCourse.class);
                System.out.println("in execute:"+courseService);

            courseService.addCourseSelection(selectedCourse.getStuId(),selectedCourse.getCourseId());
            break;

            case MsgTopic.SUBJECT_SELECTION_DELETION:
                SelectedCourse selectedCourse2 = (SelectedCourse)JSON.
                        parseObject(messageExt.getBody(), SelectedCourse.class);
                System.out.println("in execute:"+courseService);
                courseService.deleteCourseSelection(selectedCourse2.getStuId(),selectedCourse2.getCourseId());

        }
    }
}
