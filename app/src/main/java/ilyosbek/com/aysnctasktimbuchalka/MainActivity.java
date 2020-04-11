package ilyosbek.com.aysnctasktimbuchalka;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadData data = new DownloadData();
        data.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml");
        Log.e("Message: ", "done!");

    }

    public void makeToast(View view) {
        Toast.makeText(this, "Here's the change from VCS (GitHub)", Toast.LENGTH_SHORT).show();
    }

    private static class DownloadData extends AsyncTask<String, Void, String> {


        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e("Resource", s);

            Parse parse = new Parse();
            parse.parse(s);

        }

        @Override
        protected String doInBackground(String... strings) {

            return downloadHtml(strings[0]);
        }

        private String downloadHtml(String webContent) {

            StringBuilder stringBuilder = new StringBuilder();
            try {
                URL url = new URL(webContent);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int response = connection.getResponseCode();
                Log.e("RESPONSE CODE: ", " " + response);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));


                int Inputread;
                char[] inputBuffer = new char[5000000];
                while (true) {
                    Inputread = bufferedReader.read(inputBuffer);
                    if (Inputread < 0) {
                        break;
                    } else if (Inputread > 0) {
                        stringBuilder.append(String.copyValueOf(inputBuffer, 0, Inputread));
                    }

                }
                bufferedReader.close();
                return stringBuilder.toString();

            } catch (MalformedURLException e) {
                Log.e("ERROR IN XML: ", Objects.requireNonNull(e.getMessage()));
            } catch (IOException e) {
                Log.e("ERROR IN IO: ", Objects.requireNonNull(e.getMessage()));
            } catch (SecurityException e) {
                Log.e("ERROR IN SECURITY:", Objects.requireNonNull(e.getMessage()));
                e.printStackTrace();
            }

            return "failed!";
        }
    }
}
