package com.adityarahman.usermanagementservice.controller;

import com.adityarahman.usermanagementservice.entity.MasterUser;
import com.adityarahman.usermanagementservice.service.MasterUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MasterUserController {

    @Autowired
    private final MasterUserService masterUserService;

    @GetMapping("/users/{nik}")
    MasterUser getUser(@PathVariable String nik) {
        return masterUserService.getMasterUserByNik(nik);
    }
}
