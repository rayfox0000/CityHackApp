package studytitorial.in.qr_codegenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class TicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        getPayment();
        Button getP = (Button)findViewById(R.id.getPayment);
        getP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(TicketActivity.this, PaymentActivity.class);
                TicketActivity.this.startActivity(i);
            }
        });

    }

    public void getPayment(){

        setTitle("Ticket");
        String username = "system";
        RequestQueue rq = Volley.newRequestQueue(this);
        String URL = "http://192.168.43.191:9000/calculatePrice?email="+ username;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String enterTime = jsonObject.getString("enterTime");
                    Log.d("TIMEeee",enterTime);
                    TextView hour = (TextView) findViewById(R.id.hour);
                    hour.setText(enterTime);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rq.add(stringRequest);
    }
}
