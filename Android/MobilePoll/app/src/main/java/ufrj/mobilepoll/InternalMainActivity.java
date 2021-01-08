package ufrj.mobilepoll;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Controlador para a tela de início da parte interna da aplicação
 *
 * @version 201510061640
 * @author Anselmo Lira
 */
public class InternalMainActivity extends AppCompatActivity
{
    /** Inicialização da tela principal interna */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_main);
    }

    /** Evento de continuidade na execução após uma pausa. */
    @Override
    protected void onResume()
    {
        super.onResume();
    }

    /**
     * Criação do menu interno
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);

        MenuItem item = menu.add(0, 1, 1, "Configurações");
        item = menu.add(0, 2, 2, "Pesquisas");
        item = menu.add(0, 3, 3, "Contato");
        item = menu.add(0, 4, 4, "Sobre");
        item = menu.add(0, 5, 5, "Sair");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case 1:
                Toast.makeText(InternalMainActivity.this, "Clicou em Configurações", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(InternalMainActivity.this, "Clicou em Pesquisas", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Intent contactIntent = new Intent(this, ContactActivity.class);
                contactIntent.putExtra("SESSION_MODE", "logged");
                this.startActivity(contactIntent);

                //Toast.makeText(getApplicationContext(), "Clicou em Contato", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                aboutIntent.putExtra("SESSION_MODE", "logged");
                this.startActivity(aboutIntent);

                //Toast.makeText(getApplicationContext(), "Clicou em Sobre", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                new AlertDialog.Builder(this).setMessage(R.string.logout_popup_message)
                        .setTitle(R.string.logout_popup_title)
                        .setPositiveButton(R.string.logout_popup_yes, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Intent externalMainIntent = new Intent(getApplicationContext(), MainActivity.class);

                                externalMainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                externalMainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(externalMainIntent);
                            }
                        }).setNegativeButton(R.string.logout_popup_no, null).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            new AlertDialog.Builder(this).setMessage(R.string.logout_popup_message)
                    .setTitle(R.string.logout_popup_title)
                    .setPositiveButton(R.string.logout_popup_yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent externalMainIntent = new Intent(getApplicationContext(), MainActivity.class);

                            externalMainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            externalMainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(externalMainIntent);
                        }
                    }).setNegativeButton(R.string.logout_popup_no, null).show();

            return true;
        }
        else
        {
            return super.onKeyDown(keyCode, event);
        }
    }
}