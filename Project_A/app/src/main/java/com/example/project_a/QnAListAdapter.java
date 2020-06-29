package com.example.project_a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class QnAListAdapter extends BaseAdapter {
    Context context;
    ArrayList<QnAListDTO> dtos;
    Point size;

    LayoutInflater inflater;
    AlertDialog dialog;

    public QnAListAdapter(Context context, ArrayList<QnAListDTO> dtos, Point size) {
        this.context = context;
        this.dtos = dtos;
        this.size = size;

        this.inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addDto(QnAListDTO dto){
        dtos.add(dto);
    }

    public void delDto(int position){
        dtos.remove(position);
    }

    public void removeDtos(){
        dtos.clear();
    }

    @Override
    public int getCount() {
        return dtos.size();
    }

    @Override
    public Object getItem(int position) {
        return dtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        homekeeperQnAHolder viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.activity_qna_item,
                    parent, false);
            viewHolder = new homekeeperQnAHolder();
            viewHolder.textView1 = convertView.findViewById(R.id.textView1);
            viewHolder.textView2 = convertView.findViewById(R.id.textView2);
            viewHolder.textView3 = convertView.findViewById(R.id.textView3);
            viewHolder.textView4 = convertView.findViewById(R.id.textView4);
            viewHolder.imageView = convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (homekeeperQnAHolder) convertView.getTag();
        }

        final QnAListDTO dto = dtos.get(position);
        String subject = dto.getSubject();
        String id = dto.getId();
        String date =dto.getDate();
        String readCount = dto.getReadCount();
        int resId = dto.getResId();

        viewHolder.textView1.setText(subject);
        viewHolder.textView2.setText(id);
        viewHolder.textView3.setText(date);
        viewHolder.textView4.setText(readCount);
        viewHolder.imageView.setImageResource(resId);

        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "선택 : " + position
                        + ", 이름 : " + dtos.get(position).getId(), Toast.LENGTH_SHORT).show();

                // 이미지뷰 추가하여 직접 붙임
                //popUpImg(dtos.get(position).getResId());

                // xml파일 추가하여 붙이기
                popUpImgXml(dtos.get(position).getResId(), dtos.get(position).getId());
            }
        });

        return convertView;
    }


    public class  homekeeperQnAHolder{
        public ImageView imageView;
        public TextView textView1,textView2,textView3,textView4;
    }

    public void popUpImg(int resId){
        ImageView image = new ImageView(context);
        image.setImageResource(resId);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("이미지띄우기");
        builder.setView(image);

        builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(dialog != null){
                    dialog.dismiss();
                }

            }
        });

        dialog = builder.create();
        dialog.show();
    }

    public void popUpImgXml(int resId, String subject){
        // 일단 res에 popupimg.xml 만든다
        // 그 다음 화면을 inflate 시켜 setView 한다

        // 팝업창에 xml 붙이기 //////////////////
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_qna_detail_view, null);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        imageView.setImageResource(resId);
        textView.setTextSize(15);
        textView.setText(subject + "\n");
        textView.append(subject + "\n" + subject + "\n" + subject + "\n" );
        ///////////////////////////////////////

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(subject)
                .setView(view);

        builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(dialog != null){
                    dialog.dismiss();
                }

            }
        });

        dialog = builder.create();
        dialog.show();

        // 디바이스 사이즈를 받아 팝업크기창을 조절한다
        int sizeX = size.x;
        int sizeY = size.y;

        // AlertDialog 에서 위치 크기 수정

        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();

        params.x = (int) Math.round(sizeX * 0.005); // X위치
        params.y = (int) Math.round(sizeY * 0.01);  // Y위치
        params.width = (int) Math.round(sizeX * 0.9);
        params.height = (int) Math.round(sizeY * 0.8);
        dialog.getWindow().setAttributes(params);

    }
}
