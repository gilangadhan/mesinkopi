package id.codinate.mesinkopi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //variable global
    int quatitiy = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //methode increment
    public void increment(View view) {
        quatitiy = quatitiy + 1;
        display(quatitiy);
    }

    public void decrement(View view) {
        quatitiy = quatitiy - 1;
        display(quatitiy);
    }
    private void display(int quatitiy) {
        TextView textView = (TextView) findViewById(R.id.quantity);
        textView.setText(""+quatitiy);
    }
    public void submitOrder(View view){
        int price = calculatePrice();
        displayPrice(price);
    }
    private int calculatePrice() {
        int price = quatitiy * 5000;
        return price;
    }
    private void displayPrice(int price){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(""+price);
        String priceMessage = createOrderSummary(price);
        AlertDialog builder = new AlertDialog.Builder(MainActivity.this).create();
        builder.setMessage(priceMessage);
        builder.setTitle("Message");
        builder.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
    private String createOrderSummary(int price){
        String priceMessage = "Name : Gilang \n Quentity : " + quatitiy +"\n Total : " + price + "\n Thank You";
        return priceMessage;
    }

}
