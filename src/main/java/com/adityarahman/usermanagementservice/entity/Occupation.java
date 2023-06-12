package com.adityarahman.usermanagementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Occupation {
    PNS("PNS"),
    WIRASWASTA("WS"),
    PEGAWAI_SWASTA("PS"),
    BURUH_HARIAN("BH"),
    TNI("TNI"),
    POLRI("POLRI"),
    MAHASISWA("MHS"),
    IBU_RUMAH_TANGGA("IRT"),
    BELUM_BEKERJA("BB");

    private final String code;
}
