package com.example.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewRandomNumber;
    private TextView textView;
    EditText eText;

    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextPhoneNumber;
    private TextView textViewUserInfo;

    private ImageView imageView;

    private int scaleTypeIndex = 0;

    ImageButton button;


    @Override
    protected void onCreate(Bundle savedInstanceState) { // 애플리케이션이 이전에 실행되었던 상태 전달
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // activity_main.xml 파일을 액티비티 화면으로
        textViewRandomNumber = findViewById(R.id.textViewRandomNumber);
        eText = findViewById(R.id.edittext);
        textView = findViewById(R.id.textView);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        textViewUserInfo = findViewById(R.id.textViewUserInfo);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.imageButton);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClicked_Call(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1111-2222"));
        startActivity(intent);
    }

    public void onClicked_Text(View v){
        String str = eText.getText().toString();
        textView.setText(str);
    }

    public void onSignupButtonClick(View view){
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();

        // 입력된 정보를 화면 하단에 출력
        String userInfo = "아이디: " + username + "\n패스워드: " + password + "\n전화번호: " + phoneNumber;
        textViewUserInfo.setText(userInfo);
    }


    public void generateRandomNumber(View view){
        //난수 생성
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        // 텍스트 뷰에 난수 표시
        textViewRandomNumber.setText("난수: "+randomNumber);
    }

    // 버튼 클릭 이벤트 처리: Scale Type 변경
    public void changeScaleType(View view){
        ImageView.ScaleType[] scaleTypes = {
                ImageView.ScaleType.CENTER,
                ImageView.ScaleType.CENTER_CROP,
                ImageView.ScaleType.CENTER_INSIDE,
                ImageView.ScaleType.FIT_CENTER,
                ImageView.ScaleType.FIT_XY
        };

        imageView.setScaleType(scaleTypes[scaleTypeIndex]);
        scaleTypeIndex = (scaleTypeIndex + 1) % scaleTypes.length;
    }
    // 버튼 클릭 이벤트 처리 : 투명도 변경
    public void changeAlpha(View view){
        float alpha = imageView.getAlpha();
        alpha = (alpha == 1.0f) ? 0.5f : 1.0f;
        imageView.setAlpha(alpha);
    }

    public void setImage(View view){
        imageView.setImageResource(R.drawable.itkong2);
    }

}