package com.example.online_cafe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.online_cafe.authentication.Authentication;
import com.example.online_cafe.authentication.Yorum;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class YorumActivity extends AppCompatActivity{

        private EditText commentEditText;
        private Button commentButton;
        private String yorum;
        FirebaseDatabase rootNode;
        DatabaseReference reference;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_yorum);
            commentEditText = findViewById(R.id.comment_edit_text);
            commentButton = findViewById(R.id.comment_button);
            FirebaseApp.initializeApp(getApplicationContext());
            commentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    register("yorum");
                }
                private void register(String path) {
                    yorum = commentEditText.getText().toString();
                    Yorum user = new Yorum(yorum);
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference(path);
                    reference.child(yorum).setValue(user);


                }
            });
        }

}
