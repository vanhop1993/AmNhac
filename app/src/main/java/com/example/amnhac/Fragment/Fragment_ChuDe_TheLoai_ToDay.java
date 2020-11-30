package com.example.amnhac.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.amnhac.Activity.DanhsachbaihatActivity;
import com.example.amnhac.Activity.DanhsachtatcachudeActivity;
import com.example.amnhac.Activity.DanhsachtheloaitheochudeActivity;
import com.example.amnhac.Model.ChuDe;
import com.example.amnhac.Model.Theloai;
import com.example.amnhac.Model.Theloaitrongngay;
import com.example.amnhac.R;
import com.example.amnhac.Server.APIService;
import com.example.amnhac.Server.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ChuDe_TheLoai_ToDay extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtxemthemchudetheloai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude_theloai_today,container,false);
            //
        horizontalScrollView = view.findViewById(R.id.horizontalscrollview);
            //
        txtxemthemchudetheloai = view.findViewById(R.id.textviewxemthem);
//set sự kiện click chuyển màn hình
        txtxemthemchudetheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachtatcachudeActivity.class);
                startActivity(intent);
            }
        });
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice =  APIService.getService();
        Call<Theloaitrongngay> callback = dataservice.GetCategoryMusic();
        callback.enqueue(new Callback<Theloaitrongngay>() {
            @Override
            public void onResponse(Call<Theloaitrongngay> call, Response<Theloaitrongngay> response) {
                Theloaitrongngay theloaitrongngay =response.body();
                //Log.d("BBB",theloaitrongngay.getTheloai().get(0).getTenTheLoai());
                final ArrayList<ChuDe> chuDeArrayList = new ArrayList<>();
                    // khởi tạo mảng ChuDe
                chuDeArrayList.addAll(theloaitrongngay.getChuDe());
                    //addAll có thể add thêm 1 cái mảng cùng dữ liệu vào mảng ChuDe

                final ArrayList<Theloai> theLoaiArrayList = new ArrayList<>();
                    // khởi tạo mảng Theloai
                theLoaiArrayList.addAll(theloaitrongngay.getTheloai());

                // tạo cái viewgroup.
                LinearLayout linearLayout = new LinearLayout(getActivity());

                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                    // vẽ theo chiều ngang

                // xét lại kích thước cửa hình ảnh
                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580,250);
                layout.setMargins(10,20,10,30);

                for (int i = 0; i < (chuDeArrayList.size()) ; i++) {//duyệt hết các giá trị có trong chủ đề
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);// => bo xung quanh cho đẹp
                    // đưa hình ảnh vào trong cardView
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);// tự cân bằng kích thước hình ảnh
                    if (chuDeArrayList.get(i).getHinhChuDe() != null) {// để chắc rằng có dữ liệu mới đọc
                        //Picasso.get().load(chuDeArrayList.get(i).getHinhChuDe());
                    Picasso.with(getActivity()).load(chuDeArrayList.get(i).getHinhChuDe()).into(imageView); ;//gắn hình ảnh vào
                        // into(imageView) là đổ hình ảnh lên imageView
                    }
                    cardView.setLayoutParams(layout);// cố định kích thước cardView
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                    int finalI = i;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), DanhsachtheloaitheochudeActivity.class);
                            intent.putExtra("chude",chuDeArrayList.get(finalI));
                            startActivity(intent);
                        }
                    });
                }

                for (int j = 0; j <(theLoaiArrayList.size()) ; j++) {
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (theLoaiArrayList.get(j).getHinhTheLoai() != null) {
                        Picasso.with(getActivity()).load(theLoaiArrayList.get(j).getHinhTheLoai()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
//--------------------------------------------------------------------------------------------------
                    //bắt sự kiện cho việc click vào thể loại => chuyển dữ liệu thể loại qua màn hình mới
                    int finalJ = j;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), DanhsachbaihatActivity.class);
                            intent.putExtra("idtheloai",theLoaiArrayList.get(finalJ));
                            startActivity(intent);
                        }
                    });
//--------------------------------------------------------------------------------------------------

                }
                horizontalScrollView.addView(linearLayout);
            }
            @Override
            public void onFailure(Call<Theloaitrongngay> call, Throwable t) {

            }
        });
    }
}
