package com.example.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sendmessageviewbinding.databinding.ActivityViewBinding;
import com.example.sendmessageviewbinding.model.data.Message;

/***
 * Clase que muestra una vista que es cuando recibe un mensaje de SendMessageActivity.
 *
 * @author Alejandro López
 * @version 1.0
 */
public class ViewActivity extends AppCompatActivity {
    private ActivityViewBinding binding;
    private Message message;

    public static final String TAG = "ViewActivity";

    //region Métodos de ciclo vida del Activity
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ViewActivityy --> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ViewActivity --> onPause()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Se ha iniciado la Activity ViewActivity", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "SendmessageActivity --> onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ViewActivity --> onStop()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "ViewActivity --> onCreate()");
    }
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();

        message = bundle.getParcelable(Message.KEY);
        initiliceView();
    }

    /**
     * Método que inicializa todas las vistas a widgets de la interfaz o del Layout
     * */
    private void initiliceView() {
        String userinfo = message.getSender().getName() + " " + message.getSender().getSurname() +
                " con DNI: " + message.getSender().getDni() + " envió un mensaje";


        userinfo += "\n\n" + message.getReceiver().getName() + " " + message.getReceiver().getSurname() +
                " con DNI: " + message.getReceiver().getDni() + " recibió un mensaje";

        binding.tvUserInfo.setText(userinfo);
        binding.tvMessage.setText(message.getContent());
    }


}