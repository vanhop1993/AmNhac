package com.example.amnhac.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChuDe implements Serializable {

@SerializedName("IdChuDe")
@Expose
private String idChuDe;
@SerializedName("Tenchude")
@Expose
private String tenchude;
@SerializedName("HinhChuDe")
@Expose
private String hinhChuDe;

public String getIdChuDe() {
return idChuDe;
}

public void setIdChuDe(String idChuDe) {
this.idChuDe = idChuDe;
}

public String getTenchude() {
return tenchude;
}

public void setTenchude(String tenchude) {
this.tenchude = tenchude;
}

public String getHinhChuDe() {
return hinhChuDe;
}

public void setHinhChuDe(String hinhChuDe) {
this.hinhChuDe = hinhChuDe;
}

}