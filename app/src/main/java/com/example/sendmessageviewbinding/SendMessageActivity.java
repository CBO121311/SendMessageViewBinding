package com.example.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.sendmessageviewbinding.databinding.ActivitySendMessageBinding;
import com.example.sendmessageviewbinding.model.data.Message;
import com.example.sendmessageviewbinding.model.data.Person;

/**
 * Es la clase que se consideraría el MainActivity del proyecto y es la que se inicia cuando
 * abres por primera vez aplicación.
 *
 * @author Alejandro López
 * @version 1.0
 */
public class SendMessageActivity extends AppCompatActivity {

    public static final String TAG = "SendMessageActivity";
    private ActivitySendMessageBinding binding;

    //region Métodos de ciclo vida del Actibvity
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity --> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity --> onPause()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity --> onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity --> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "SendMessageActivity --> onCreate()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(v -> {
            SendMessage();
        });
    }

    //endregion

    /**
     * Es el método que sirve para crear/inflar el menú ActionBar
     *
     * @param menu Es el menú predeterminado de la actividad
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Método callback que comprueba el componente que has pulsado menu_aboutas y llama
     * su correspondiente actividad
     *
     * @param item Elemento del menu que hico click
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_aboutas: {
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Método que prepara un objeto Message con sus datos para enviarlo a otro Activity (ViewActivity)
     */
    public void SendMessage() {
        Intent intent = new Intent(this, ViewActivity.class);
        Bundle bundle = new Bundle();

        Person persone = new Person("Alejandro", "López", "12345678A");
        Person persond = new Person("Pedro", "Gallardo", "24567787B");

        Message message = new Message(1, binding.edMessage.getText().toString(), persone, persond);

        bundle.putParcelable(Message.KEY, message);
        bundle.putSerializable(Message.KEY, message);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}