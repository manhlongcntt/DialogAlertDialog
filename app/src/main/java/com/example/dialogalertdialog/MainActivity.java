package com.example.dialogalertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_show_dialog;
    private Button btn_showAlertDialog;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_show_dialog = (Button) findViewById(R.id.btn_show_dialog);
        btn_showAlertDialog = (Button) findViewById(R.id.btn_show_AlertDialog);

        btn_show_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_dialog();
            }
        });
        btn_showAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setCancelable(false);
        builder.setMessage("bạn có đồng ý không");
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Bạn đăng xuất thành công", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Bỏ qua", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void show_dialog(){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Thông báo");
        dialog.setContentView(R.layout.show_dialog);
        dialog.setCancelable(false);
        Button btn_dong_y = (Button) dialog.findViewById(R.id.btn_dong_y);
        Button btn_bo_qua = (Button) dialog.findViewById(R.id.btn_bo_qua);
        btn_dong_y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "bạn đã đăng xuất thanh công" , Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        btn_bo_qua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
