package com.example.amnhac.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Theloaitrongngay {

@SerializedName("Theloai")
@Expose
private List<Theloai> theloai = null;
@SerializedName("ChuDe")
@Expose
private List<ChuDe> chuDe = null;

public List<Theloai> getTheloai() {
return theloai;
}

public void setTheloai(List<Theloai> theloai) {
this.theloai = theloai;
}

public List<ChuDe> getChuDe() {
return chuDe;
}

public void setChuDe(List<ChuDe> chuDe) {
this.chuDe = chuDe;
}

}