package app.cpt.sorapongph.myeasyservice.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import app.cpt.sorapongph.myeasyservice.R;

/**
 * Created by sorapong.ph on 10/22/2017.
 */

public class SecondFragment extends Fragment {

    private ImageView imageView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Back Controller
        backController();

        //Image Controller
        imageController();

    }// Main Method

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //requestCode คือ 1 ทีมาจาก startActivityForResult(intent.createChooser(intent, "Please choose App"), 1);
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            try {
                Uri uri = data.getData();
                Bitmap bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(uri));
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getActivity(), "Not Choose Image", Toast.LENGTH_SHORT).show();
        }
    }

    private void imageController() {
        imageView = getView().findViewById(R.id.imvHumen);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                //ค้นหาโปรแกรมที่เกี่ยวกับรูป
                intent.setType("image/*");
                startActivityForResult(intent.createChooser(intent, "Please choose App"), 1);
            }
        });
    }

    private void backController() {
        Button button = getView().findViewById(R.id.btnBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //สลายหน้ากากตัวเอง แล้วกลับไปยังหน้ากากที่เปิดก่อนหน้า
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        return view;
    }
}// Main Class
