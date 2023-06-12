package com.adityarahman.usermanagementservice.service;

import com.adityarahman.usermanagementservice.entity.MasterUser;
import com.adityarahman.usermanagementservice.exception.MasterUserNotFoundException;
import com.adityarahman.usermanagementservice.repository.MasterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class MasterUserService {

    @Autowired
    private MasterUserRepository masterUserRepository;

    @Cacheable("users")
    public MasterUser getMasterUserByNik(String nik) {
        MasterUser masterUser = masterUserRepository.getMasterUserByNik(nik);
        if (ObjectUtils.isEmpty(masterUser))
            throw new MasterUserNotFoundException();
       return masterUser;
    }
}
