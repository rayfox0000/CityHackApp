package studytitorial.in.qr_codegenerator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.scheme.VCard;

public class QRGenerateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrgenerate);
        setTitle("Exit QR Generation");
        // get QR file from text using defaults
        //Bitmap myBitmap = QRCode.from("www.studytutorial.in").bitmap();
        VCard abhay = new VCard("systemOut")
                .setEmail("rayfox00@hotmail.com");

        Bitmap myBitmap = QRCode.from(abhay).withSize(250, 250).bitmap();
        ImageView myImage = (ImageView) findViewById(R.id.imageView);
        myImage.setImageBitmap(myBitmap);
        Button exit = (Button)findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(QRGenerateActivity.this, MainActivity.class);
                QRGenerateActivity.this.startActivity(i);
            }
        });



    }
}
