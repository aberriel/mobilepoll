package ufrj.mobilepoll;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ufrj.mobilepoll.database.helper.PersonDbHelper;

/**
 * Controlador para a tela inicial externa (ponto de início)
 *
 * @version 201510061640
 * @author Anselmo Lira
 */
public class MainActivity extends AppCompatActivity
{
    /** Inicialização da tela */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Aqui é onde realizo o teste do banco */
        PersonDbHelper personDbHelper = new PersonDbHelper(getApplicationContext());
        System.out.println("Teste de log no console.");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    /**
     * Criação do menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);

        MenuItem item = menu.add(0, 1, 1, "Login");
        item = menu.add(0, 2, 2, "Configurações");
        item = menu.add(0, 3, 3, "Contato");
        item = menu.add(0, 4, 4, "Sobre");

        return true;
    }

    /**
     * Implementação do evento de seleção de ítem do menu
     * @param item Ítem do menu selecionado (clicado)
     * @return Flag indicador de sucesso
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case 1:
                Intent loginIntent = new Intent(this, LoginActivity.class);
                this.startActivity(loginIntent);
                break;
            case 2:
                Toast.makeText(MainActivity.this, "Clicou em Configurações", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Intent contactIntent = new Intent(this, ContactActivity.class);
                contactIntent.putExtra("SESSION_MODE", "anonymous");
                this.startActivity(contactIntent);

                //Toast.makeText(getApplicationContext(), "Clicou em Contato", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                aboutIntent.putExtra("SESSION_MODE", "anonymous");
                this.startActivity(aboutIntent);

                //Toast.makeText(getApplicationContext(), "Clicou em Sobre", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    /**
     * Implementação do evento de pressionamento de botão
     * @param keyCode Código do botão pressionado
     * @param event Evento
     * @return Flag indicador de sucesso na operação
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            new AlertDialog.Builder(this).setMessage(R.string.logout_popup_message)
                    .setTitle(R.string.logout_popup_title)
                    .setPositiveButton(R.string.logout_popup_yes, new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            MainActivity.this.finish();
                        }
                    }).setNegativeButton(R.string.logout_popup_no, new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int wich)
                        {
                            dialog.cancel();
                        }
                    }).show();

            return true;
        }
        else
        {
            return super.onKeyDown(keyCode, event);
        }
    }
}