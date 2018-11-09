package ua.com.onpu.lab2_final_from_dzyga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import ua.com.onpu.lab2_final_from_dzyga.ActivityContent;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button ContentActivityButton;
    private TextView address;
    private TextView description;
    private TextView time;
    //ArrayList<String> objectsList = new ArrayList<String>();
    static String txtAddress;
    ActivityContent obj1;

    //ActivityContent ob;

    static String[] names = {"1)", "2)", "3)", "4)", "5)", "6)", "7)", "8)", "9)", "10)",};
    static int i = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentActivityButton = (Button) findViewById(R.id.ContentActivityButton);
        ContentActivityButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent().getStringExtra("address") == null)
        {
            return;
        }
        //address = (TextView) findViewById(R.id.textView);
        else {

            txtAddress = getIntent().getStringExtra("address") + ';' +
                    getIntent().getStringExtra("time") + ';' +
                    getIntent().getStringExtra("description");

            //address.setText(address.getText().toString() + " " + txtAddress);
            //objectsList.add(txtAddress);

            i = i + 1;
            if (i == 9 || i < 0) {
                i = 0;
                onPause();
            }
            names[i] += txtAddress;


            ListView List = (ListView) findViewById(R.id.List);


            ArrayAdapter<String> adapter;
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, names);


            List.setAdapter(adapter);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ContentActivityButton:
                Intent intent = new Intent(this, ActivityContent.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                //finish();
                break;

            default:

                break;
        }
    }
}
