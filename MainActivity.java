package healthol.latattempt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    String user ;
    String pass ;
    RequestQueue rq;
    String regURL = "https://192.168.43.46:3306/C:/wamp64/reg.php";
    //String regURL = "C:/wamp64/reg.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText u = (EditText)findViewById(R.id.user);
        EditText p = (EditText)findViewById(R.id.pass);
        user = u.getText().toString();
        pass = p.getText().toString();
        Button reg = (Button)findViewById(R.id.reg);

        rq = Volley.newRequestQueue(getApplicationContext());
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest sr = new StringRequest(Request.Method.POST, regURL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parameters = new HashMap<String, String>();
                        parameters.put("user",user);
                        parameters.put("pass",pass);
                        return parameters ;
                    }
                } ;
                rq.add(sr);
            }
        });
    }
}
