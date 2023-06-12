package com.adityarahman.usermanagementservice.service;

import com.adityarahman.usermanagementservice.entity.*;
import com.adityarahman.usermanagementservice.repository.MasterUserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class MasterUserServiceTest {


    @Autowired
    private MasterUserRepository masterUserRepository;
    @Autowired
    private MasterUserService masterUserService;

    @Test
    void getMasterUserByNik_forSavedMasterUser_isReturned() {
        // given
        MasterUser savedMasterUser = masterUserRepository.save(
                MasterUser.builder()
                        .id(null)
                        .nik("3175091508960003")
                        .fullName("Aditya Rahman Sidqi")
                        .gender(Gender.MALE)
                        .birthDate(LocalDate.of(1996, 8, 15))
                        .religion(Religion.ISLAM)
                        .occupation(Occupation.PEGAWAI_SWASTA)
                        .maritalStatus(MaritalStatus.KAWIN)
                        .address("Jl. Regalia No.62")
                        .email("adityars.sidqi@gmail.com")
                        .neighbourhoodId(1L)
                        .build());
        // when
        MasterUser masterUser = masterUserService.getMasterUserByNik(savedMasterUser.getNik());
        // then
        then(masterUser.getFullName()).isEqualTo("Aditya Rahman Sidqi");
        then(masterUser.getId()).isNotNull();
    }
}
