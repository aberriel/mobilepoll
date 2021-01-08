package ufrj.mobilepoll.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Métodos utilitários relativos ao teclado do android
 * Created by alira on 30/09/15.
 */
public class KeyboadUtils
{
    /** Construtor */
    public KeyboadUtils() { }

    /**
     * Oculta o teclado do sistema operacional
     * @param context
     * @param view
     */
    public void HideKeyboard(Context context, View view)
    {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}