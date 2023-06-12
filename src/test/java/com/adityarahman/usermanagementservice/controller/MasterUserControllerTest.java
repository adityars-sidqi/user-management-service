package com.adityarahman.usermanagementservice.controller;

import com.adityarahman.usermanagementservice.entity.*;
import com.adityarahman.usermanagementservice.service.MasterUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class MasterUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MasterUserService masterUserService;

    @Test
    void getMasterUser_forSavedMasterUser_isReturned() throws Exception {
        //given
        given(masterUserService.getMasterUserByNik(anyString())).willReturn(MasterUser.builder()
                .id(1L)
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

        //when //then
        mockMvc.perform(get("/users/3175091508960003"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1L))
                .andExpect(jsonPath("nik").value("3175091508960003"))
                .andExpect(jsonPath("fullName").value("Aditya Rahman Sidqi"))
                .andExpect(jsonPath("occupation").value("PEGAWAI_SWASTA"));
    }
}
