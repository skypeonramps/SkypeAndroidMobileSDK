package sdk.android.skype.com.skypeandroidsdktestapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.skype.android.mobilesdk.SkypeSdkException;
import com.skype.android.mobilesdk.api.Modality;
import com.skype.android.mobilesdk.api.SkypeApi;

public class MainActivity extends AppCompatActivity {

    private EditText skypeId;
    private SkypeApi skypeApi = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button chatButton = (Button) findViewById(R.id.chatButton);
        chatButton.setOnClickListener(chatClickListener);
        Button callButton = (Button) findViewById(R.id.audioCallButton);
        callButton.setOnClickListener(callClickListener);
        Button videoCallButton = (Button) findViewById(R.id.videoCallButton);
        videoCallButton.setOnClickListener(videoCallClickListener);

        skypeId = (EditText) findViewById(R.id.skypeIdInput);
        try {
            skypeApi = new SkypeApi(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Button.OnClickListener chatClickListener =
            new Button.OnClickListener(){
                @Override
                public void onClick(View v) {
                    CharSequence skypeIdValue =
                            skypeId.getText();
                    try {
                        if(skypeApi != null) {
                            Log.d("TestApp", "chatting to skypeid: " + skypeIdValue.toString());
                            skypeApi.startConversation(skypeIdValue.toString(), Modality.Chat);
                        }
                    } catch (SkypeSdkException e) {
                        Toast.makeText(getApplicationContext(), "No application can handle this request. Please install a web browser or the Skype app",
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            };

    private Button.OnClickListener callClickListener =
            new Button.OnClickListener(){
                @Override
                public void onClick(View v) {
                    CharSequence skypeIdValue =
                            skypeId.getText();
                    try {
                        if (skypeApi != null) {
                            skypeApi.startConversation(skypeIdValue.toString(), Modality.AudioCall);
                        }
                    } catch (SkypeSdkException e) {
                        Toast.makeText(getApplicationContext(), "No application can handle this request. Please install a web browser or the Skype app",
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            };

    private Button.OnClickListener videoCallClickListener =
            new Button.OnClickListener(){
                @Override
                public void onClick(View v){
                    CharSequence skypeIdValue =
                            skypeId.getText();
                    try{
                        if (skypeApi != null){
                            skypeApi.startConversation(skypeIdValue.toString(), Modality.VideoCall);
                        }
                    } catch (SkypeSdkException e) {
                        Toast.makeText(getApplicationContext(), "No application can handle this request. Please install a web browser or the Skype app",
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            };

    private Button.OnClickListener joinClickListener =
            new Button.OnClickListener(){
                @Override
                public void onClick(View v) {
                    CharSequence skypeIdValue =
                            skypeId.getText();
                    try {
                        Log.d("TestApp", "Skype id value is : " + skypeIdValue.toString());
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://join.skype.com/" + skypeIdValue.toString()));
                        browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getApplicationContext().startActivity(browserIntent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getApplicationContext(), "No application can handle this request. Please install a web browser or the Skype app",
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            };

    private Button.OnClickListener botClickListener =
            new Button.OnClickListener(){
                @Override
                public void onClick(View v) {
                    try {
                        CharSequence skypeIdValue = skypeId.getText();
                        if (TextUtils.isEmpty(skypeIdValue)) {
                            skypeIdValue = "32553cf6-2f7f-4931-89f2-b6aee797ae52";
                        }
                        Log.d("TestApp", "Skype id value is : " + skypeIdValue.toString());
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://join.skype.com/bot/" + skypeIdValue.toString()));
                        browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getApplicationContext().startActivity(browserIntent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getApplicationContext(), "No application can handle this request. Please install a web browser or the Skype app",
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            };
}
