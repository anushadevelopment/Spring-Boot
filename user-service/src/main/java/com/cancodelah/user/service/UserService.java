package com.cancodelah.user.service;

import com.cancodelah.user.VO.Department;
import com.cancodelah.user.VO.ResponseTemplateVO;
import com.cancodelah.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cancodelah.user.repository.UserRepository;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByuserId(userId);

        Department department =
                restTemplate.getForObject(
                        "http://localhost:9002/departments/"+ user.getDepartmentId(), Department.class);

                vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }

}
