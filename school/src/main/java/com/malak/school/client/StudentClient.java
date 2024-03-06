package com.malak.school.client;

import com.malak.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//FeignClient to establish communication and make http call to distant / 3rd party API
@FeignClient(
        name = "student-service",
        // url of student microservice/ endpoint
        url = "${application.config.students-url}"
)
public interface StudentClient {

    @GetMapping("/school/{school-id}")//same as SchoolController line 30
    List<Student> findAllStudentsBySchool(@PathVariable("school-id") Integer schoolId);
    // automatic implementation by openFein to Establish comm with student
}