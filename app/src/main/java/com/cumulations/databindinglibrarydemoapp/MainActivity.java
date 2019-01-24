package com.cumulations.databindinglibrarydemoapp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cumulations.databindinglibrarydemoapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setUser(new User("Rahul", "Jha"));

        binding.setClickHandler(new ClickHandler(this));
    }

    public class ClickHandler {
        private Context context;

        public ClickHandler(Context context) {
            this.context = context;
        }

        public void onClick(View view) {
            Toast.makeText(context, "onSimpleClick", Toast.LENGTH_SHORT).show();
        }

        public boolean onLongClick(View view) {
            Toast.makeText(context, "onSimpleLongClick", Toast.LENGTH_SHORT).show();
            return false;
        }

        public void onClickWithParameters(View view, User user) {
            Toast.makeText(context, user.firstName + " " + user.lastName, Toast.LENGTH_SHORT).show();
        }
    }

}
