package com.bluohazard.soilmonitoring.models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Soil {
    public int air;
    public int kelembaban;
    public int oksigen;
    public int suhu;

    public Soil() {
    }

    public Soil(int air, int kelembaban, int oksigen, int suhu) {
        this.air = air;
        this.kelembaban = kelembaban;
        this.oksigen = oksigen;
        this.suhu = suhu;
    }

    public int getAir() {
        return air;
    }

    public void setAir(int air) {
        this.air = air;
    }

    public int getKelembaban() {
        return kelembaban;
    }

    public void setKelembaban(int kelembaban) {
        this.kelembaban = kelembaban;
    }

    public int getOksigen() {
        return oksigen;
    }

    public void setOksigen(int oksigen) {
        this.oksigen = oksigen;
    }

    public int getSuhu() {
        return suhu;
    }

    public void setSuhu(int suhu) {
        this.suhu = suhu;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("air", air);
        result.put("kelembaban", kelembaban);
        result.put("oksigen", oksigen);
        result.put("suhu", suhu);
        return result;
    }
}
