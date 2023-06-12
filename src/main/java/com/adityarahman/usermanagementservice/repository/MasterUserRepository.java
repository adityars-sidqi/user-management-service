package com.adityarahman.usermanagementservice.repository;

import com.adityarahman.usermanagementservice.entity.MasterUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasterUserRepository extends JpaRepository<MasterUser, Long> {
    MasterUser getMasterUserByNik(String nik);

    List<MasterUser> findByNeighbourhoodId(Long neighbourhoodId);
}
