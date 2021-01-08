package ufrj.mobilepoll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Controlador para a tela de contato
 *
 * @version 201510061640
 * @author Anselmo Lira
 */
public class ContactActivity extends AppCompatActivity
{
    /** Tem por fim identificar se o usuário está autenticado ou não */
    public String sessionMode = "";

    /**
     * Inicialização da tela de contato com os administradores do sistema
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            sessionMode = extras.getString("SESSION_MODE");

            Toast toast = Toast.makeText(getApplicationContext(), sessionMode, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}