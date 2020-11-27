package com.example.amnhac.Server;

import com.example.amnhac.Model.Album;
import com.example.amnhac.Model.Baihat;
import com.example.amnhac.Model.ChuDe;
import com.example.amnhac.Model.Playlist;
import com.example.amnhac.Model.Quangcao;
import com.example.amnhac.Model.Theloai;
import com.example.amnhac.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {

    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("chudevatheloai.php")
    Call<Theloaitrongngay> GetCategoryMusic();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("baihatduocyeuthich.php")
    Call<List<Baihat>> GetBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoplaylist(@Field("idplaylist") String idplaylist);

    @GET("danhsachplaylist.php")
    Call<List<Playlist>> GetDanhsachcacplaylist();

    //tạo phương thức để tương tác với API mình đã viết
    @FormUrlEncoded
    @POST("danhsachbaihat.php")//mình có gửi sever 1 id vs sever gửi lại cho mình dữ liệu nên xài phương thức post
    Call<List<Baihat>> GetDanhsachbaihattheotheloai(@Field("idtheloai") String idtheloai);

    // tạo phương thức gửi lên server
    @GET("tatcachude.php")
    Call<List<ChuDe>> getAllchude();

    @FormUrlEncoded
    @POST("theloaitheochude.php")
    Call<List<Theloai>> GetTheloaitheochude(@Field("idchude" ) String idchude);
}
