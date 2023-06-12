package com.adityarahman.usermanagementservice.cache;

import com.adityarahman.usermanagementservice.entity.*;
import com.adityarahman.usermanagementservice.repository.MasterUserRepository;
import com.adityarahman.usermanagementservice.service.MasterUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MasterUserCacheTest {

    @Autowired
    private MasterUserService masterUserService;

    @MockBean
    private MasterUserRepository masterUserRepository;

    @Test
    void getMasterUserByNik_forMultipleRequest_isRetrievedFromCache()
    {
        //given
        String nik = "3175091508960000";
        given(masterUserRepository.getMasterUserByNik(nik)).willReturn(MasterUser.builder()
                .id(1L)
                .nik("3175091508960000")
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

        //when
        masterUserService.getMasterUserByNik(nik);
        masterUserService.getMasterUserByNik(nik);
        masterUserService.getMasterUserByNik(nik);

        //then
        then(masterUserRepository).should(times(1)).getMasterUserByNik(nik);
    }
}
