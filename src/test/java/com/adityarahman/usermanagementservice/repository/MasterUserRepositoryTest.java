package com.adityarahman.usermanagementservice.repository;

import com.adityarahman.usermanagementservice.entity.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
class MasterUserRepositoryTest {

    @Autowired
    private MasterUserRepository masterUserRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private MasterUser construct_default_masterUser() {
        return MasterUser.builder()
                .id(null)
                .nik("3175091508960003")
                .fullName("Aditya Rahman Sidqi")
                .gender(Gender.MALE)
                .birthDate(LocalDate.of(1996,8,15))
                .religion(Religion.ISLAM)
                .occupation(Occupation.PEGAWAI_SWASTA)
                .maritalStatus(MaritalStatus.KAWIN)
                .address("Jl. Regalia No.62")
                .email("adityars.sidqi@gmail.com")
                .neighbourhoodId(1L)
                .build();
    }

    private MasterUser construct_masterUser(String nik, String fullname,
                                            Gender gender, LocalDate birthDate,
                                            Religion religion, Occupation occupation,
                                            MaritalStatus maritalStatus, String address,
                                            String email, Long neighbourhoodId) {
        return MasterUser.builder()
                .id(null)
                .nik(nik)
                .fullName(fullname)
                .gender(gender)
                .birthDate(birthDate)
                .religion(religion)
                .occupation(occupation)
                .maritalStatus(maritalStatus)
                .address(address)
                .email(email)
                .neighbourhoodId(neighbourhoodId)
                .build();
    }

    @Test
    @DisplayName("Get MasterUser By NIK expect success")
    void testGetMasterUserByNik_returnMasterUserDetails() {
        // given
        MasterUser savedMasterUser = testEntityManager.persistFlushFind(construct_default_masterUser());
        // when
        MasterUser masterUser = masterUserRepository.getMasterUserByNik("3175091508960003");
        // then
        then(masterUser.getId()).isNotNull();
        then(masterUser.getNik()).isEqualTo(savedMasterUser.getNik());
    }

    @Test
    @DisplayName("Get MasterUser List By Neighbourhood Id")
    void testGetMasterUserByNeighbourhoodId_returnListMasterUser() {
        // given
        MasterUser sidqiAditya = construct_masterUser("3175091508960001", "Sidqi Aditya Rahman", Gender.MALE,
                LocalDate.of(1998,12,1), Religion.ISLAM, Occupation.MAHASISWA, MaritalStatus.KAWIN,
                "Jl. Margonda", "sidqi.aditya@gmail.com", 1L);
        MasterUser sidqiRahman = construct_masterUser("3175091508960002", "Sidqi Rahman", Gender.FEMALE,
                LocalDate.of(1998,8,15), Religion.KATOLIK, Occupation.PNS, MaritalStatus.KAWIN,
                "Jl. Depok", "rahman.sidqi@gmail.com", 1L);
        MasterUser dheyaWiansyah = construct_masterUser("3175091508960003", "Dheya Rahmani Wiansyah", Gender.FEMALE,
                LocalDate.of(1998,10,19), Religion.ISLAM, Occupation.IBU_RUMAH_TANGGA, MaritalStatus.KAWIN,
                "Jl. GDC", "dheya.sidqi@gmail.com", 1L);
        Arrays.asList(sidqiAditya, sidqiRahman, dheyaWiansyah).forEach(testEntityManager::persistFlushFind);
        // when
        List<MasterUser> masterUsers = masterUserRepository.findByNeighbourhoodId(1L);
        // then
        then(masterUsers).isNotEmpty();
        then(masterUsers.size()).isEqualTo(3);
        then(masterUsers).contains(dheyaWiansyah);
    }

}
