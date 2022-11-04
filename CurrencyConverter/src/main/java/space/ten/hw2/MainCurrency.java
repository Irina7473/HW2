package space.ten.hw2;

public class MainCurrency {

    String CharCode;
    String Name;
    int Nominal;
    float CB;
    float Buy;
    float Sale;

    public MainCurrency(){}

    public MainCurrency(String charCode, String name, int nominal, float cb, float buy, float sale){
        this.CharCode=charCode;
        this.Name=name;
        this.Nominal=nominal;
        this.CB=cb;
        this.Buy=buy;
        this.Sale = sale;
    }

    protected float Conversion (MainCurrency currency, String type){
        float rate = 1;
        switch(type) {
            case "cb":
                rate=(this.CB/this.Nominal)/(currency.CB/ currency.Nominal);
                break;
            case "buy":
                rate=(this.Buy/this.Nominal)/(currency.Sale/ currency.Nominal);
                break;
            case "sale":
                rate=(this.Sale/this.Nominal)/(currency.Buy/ currency.Nominal);
                break;
        }
        return  rate;
    }


}
