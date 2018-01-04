package tw.com.pcschool.dd2018010403;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> data;
    Spinner spi;
    ArrayAdapter<String> aada;
    TextView tv;

    int pos;
    TextView tv2;

    EditText et;

    Spinner spi2;
    TextView tv3;
    String[] str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        data.add("AAA");
        data.add("BBB");
        data.add("CCC");
        spi = (Spinner)findViewById(R.id.spinner);
        aada = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                data
        );
        spi.setAdapter(aada);

        tv = (TextView)findViewById(R.id.textView);
        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(data.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tv3 = (TextView)findViewById(R.id.textView3);
        spi2 = (Spinner)findViewById(R.id.spinner2);
        spi2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str = getResources().getStringArray(R.array.cities);
                tv3.setText(str[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void click1(View v)
    {
        pos = spi.getSelectedItemPosition();
        tv2 = (TextView)findViewById(R.id.textView2);
        tv2.setText(data.get(pos));
    }
    public void clickAdd(View v)
    {
        et = (EditText)findViewById(R.id.editText);
        data.add(et.getText().toString());
        aada.notifyDataSetChanged();
    }
    public void clickDel(View v)
    {
        if(data.isEmpty()){
            aada.notifyDataSetChanged();
        }
        else
        {
            data.remove(spi.getSelectedItemPosition());
            aada.notifyDataSetChanged();
        }
    }
}
