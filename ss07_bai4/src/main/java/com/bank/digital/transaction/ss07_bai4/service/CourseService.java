package com.bank.digital.transaction.ss07_bai4.service;

import com.bank.digital.transaction.ss07_bai4.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    public Object getCourseDetails(Long courseId) {
        if (courseId == 999) {
            throw new ResourceNotFoundException("Khóa học có ID " + courseId + " không tồn tại trên hệ thống.");
        }
        return "Thông tin khóa học hợp lệ";
    }
}
