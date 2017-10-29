package studytitorial.in.qr_codegenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProcessingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processing);
        setTitle("Processing");
        Button getP = (Button)findViewById(R.id.payticket);
        getP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(ProcessingActivity.this, QRGenerateActivity.class);
                ProcessingActivity.this.startActivity(i);
            }
        });
    }
}
