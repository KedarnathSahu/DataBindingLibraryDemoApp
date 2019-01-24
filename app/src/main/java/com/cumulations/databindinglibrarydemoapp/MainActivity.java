package com.cumulations.databindinglibrarydemoapp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cumulations.databindinglibrarydemoapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setUser(new User("Rahul", "Jha"));

        binding.setClickHandler1(new ClickHandler1(this));
        binding.setClickHandler2(new ClickHandler2(this, binding.content2.firstNameIncludedLayout2, binding.content2.lastNameIncludedLayout2));
    }

    public class ClickHandler1 {
        private Context context;

        public ClickHandler1(Context context) {
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

    public class ClickHandler2 {
        private Context context;
        private EditText fName, lName;

        public ClickHandler2(Context context, EditText fName, EditText lName) {
            this.context = context;
            this.fName = fName;
            this.lName = lName;
        }

        public void onUpdateUserInfo(View view) {
            binding.setUser(new User(fName.getText().toString(), lName.getText().toString()));
            Toast.makeText(context, "onUpdateUserInfo", Toast.LENGTH_SHORT).show();
        }
    }

}
