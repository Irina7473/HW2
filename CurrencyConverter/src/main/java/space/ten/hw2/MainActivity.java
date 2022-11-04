package space.ten.hw2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<String> currencySP = new ArrayList<>();
    private List<MainCurrency> currency = new ArrayList<MainCurrency>();
    String type="";

    private EditText number;
    private Spinner sp1, sp2;
    private TextView rate,result;
    private Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        СreateListCurrencies();

        number = (EditText)findViewById(R.id.number);
        rate = (TextView) findViewById(R.id.rate);
        result = (TextView)findViewById(R.id.result);
        calc = (Button) findViewById(R.id.calc);

        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);

        // Создаем адаптер ArrayAdapter с помощью стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, currencySP);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        sp1.setAdapter(adapter);
        sp2.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Получаем выбранный объект
                String item = (String)parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        sp1.setOnItemSelectedListener(itemSelectedListener);
        sp2.setOnItemSelectedListener(itemSelectedListener);
    }

    public  void onButtonClicked(View view){
        int value = Integer.parseInt(number.getText().toString());
        MainCurrency currency1 = currency.get(sp1.getSelectedItemPosition());
        MainCurrency currency2 = currency.get(sp2.getSelectedItemPosition());
        float rateK, res;
        if (type!="") {
            //rateK = currency1.Conversion(currency2, type);
            rateK = currency2.CB / currency1.CB;
            res = value * rateK;
            rate.setText(String.valueOf(rateK));
            result.setText(String.valueOf(res));
        }

    }

    public String onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        if (checked) type = ((RadioButton) view).getText().toString();

        /*// Получаем нажатый переключатель
        switch(view.getId()) {
            case R.id.cb:
                if (checked) type = "cb";
                break;
            case R.id.buy:
                if (checked) type = "buy";
                break;
            case R.id.sale:
                if (checked) type = "buy";
                break;
        }*/

        return  type;
    }

    private void СreateListCurrencies (){
        currency.add(new MainCurrency("RUB", "Рубль", 1, 1F, 1F, 1F));
        currency.add(new MainCurrency("USD", "Доллар США", 1, 61.55F, 61.75F, 61.25F));
        currency.add(new MainCurrency("EUR", "Евро", 1, 60.55F, 60.75F, 60.25F));
        currency.add(new MainCurrency("CNY", "Китайских юаней", 10, 84.28F, 86.28F, 82.28F));
        currency.add(new MainCurrency("jPY", "Японских иен", 100, 41.50F, 41.70F, 41.30F));
        currency.add(new MainCurrency("KZT", "Казахстанских тенге", 100, 13.35F, 13.50F, 13.20F));
        currency.add(new MainCurrency("TRY", "Турецких лир", 10, 33.30F, 33.50F, 33.20F));
        for (MainCurrency c: currency) currencySP.add(c.Name);
    }

}