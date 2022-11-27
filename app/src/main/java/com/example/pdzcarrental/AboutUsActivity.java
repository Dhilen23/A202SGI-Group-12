package com.example.pdzcarrental;

import androidx.appcompat.app.AppCompatActivity;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import android.os.Bundle;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        // getting reference of  ExpandableTextView
        ExpandableTextView expTv = (ExpandableTextView) findViewById(R.id.expand_text_view).findViewById(R.id.expand_text_view);

        // calling setText on the ExpandableTextView so that
        // text content will be  displayed to the user
        expTv.setText(getString(R.string.expandable_text));



    }
}