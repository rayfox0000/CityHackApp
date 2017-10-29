package studytitorial.in.qr_codegenerator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.scheme.VCard;

import org.json.JSONObject;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private String hour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button exit = (Button)findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, TicketActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        setTitle("Your QR Code");

        // get QR file from text using defaults
        //Bitmap myBitmap = QRCode.from("www.studytutorial.in").bitmap();
        VCard abhay = new VCard("system")
                .setEmail("MelFox.gmail.com");

        Bitmap myBitmap = QRCode.from(abhay).withSize(250, 250).bitmap();
        ImageView myImage = (ImageView) findViewById(R.id.imageView);
        myImage.setImageBitmap(myBitmap);
        Boolean hourExist = false;
//        int counter =0;
//        do{
//            counter++;
//        }while(counter <10);



    }


}




