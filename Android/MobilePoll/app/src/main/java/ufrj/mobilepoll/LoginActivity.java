package ufrj.mobilepoll;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para a tela de autenticação.
 *
 * @version 201510061640
 * @author Anselmo Lira
 * */
public class LoginActivity extends Activity implements LoaderCallbacks<Cursor>
{
    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{ "aberriel:hello", "qrodrigues:world" };

    /** Keep track of the login task to ensure we can cancel it if requested. */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private AutoCompleteTextView txtLogin;
    private EditText txtPassword;
    private View mProgressView;
    private View mLoginFormView;
    private UserLoginUtils loginUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        txtLogin = (AutoCompleteTextView) findViewById(R.id.txt_login);
        populateAutoComplete();

        txtPassword = (EditText) findViewById(R.id.txt_password);
        txtPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        loginUtils = new UserLoginUtils(this);

        Button loginButton = (Button) findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void populateAutoComplete()
    {
        getLoaderManager().initLoader(0, null, this);
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the errors are presented and no actual login attempt is made.
     */
    public void attemptLogin()
    {
        if (mAuthTask != null)
        {
            return;
        }

        // Oculta o teclado
        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(txtLogin.getWindowToken(), 0);

        // Reset errors.
        txtLogin.setError(null);
        txtPassword.setError(null);

        // Store values at the time of the login attempt.
        String login = txtLogin.getText().toString();
        String password = txtPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password))
        {
            txtPassword.setError(getString(R.string.error_invalid_password));
            focusView = txtPassword;
            cancel = true;
        }

        // Check for a valid login address.
        if (TextUtils.isEmpty(login))
        {
            txtLogin.setError(getString(R.string.error_field_required));
            focusView = txtLogin;
            cancel = true;
        }
        else if (!isLoginValid(login))
        {
            txtLogin.setError(getString(R.string.error_invalid_login));
            focusView = txtLogin;
            cancel = true;
        }

        if (cancel)
        {
            // There was an error; don't attempt login and focus the first form field with an error.
            loginUtils.showErrorDialog(false);
            focusView.requestFocus();
        }
        else
        {
            // Show a progress spinner, and kick off a background task to perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(login, password, this);
            mAuthTask.execute((Void) null);
        }
    }

    /**
     * Realiza a validação inicial do login recebido.
     * @param loginReceived Login fornecido pelo usuário na tela de autenticação
     * @return Flag indicando se login passou pelas validações iniciais
     */
    private boolean isLoginValid(String loginReceived)
    {
        //TODO: Replace this with your own logic
        return loginReceived.length() > 2 && loginReceived.length() < 20;
    }

    private boolean isPasswordValid(String password)
    {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show)
    {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2)
        {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter()
            {
                @Override
                public void onAnimationEnd(Animator animation)
                {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        }
        else
        {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(this,
                                // Retrieve data rows for the device user's 'profile' contact.
                                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                                ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,
                                // Select only email addresses.
                                ContactsContract.Contacts.Data.MIMETYPE + " = ?", new String[]{ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE},
                                // Show primary email addresses first. Note that there won't be a primary email address if the user hasn't specified one.
                                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor)
    {
        List<String> emails = new ArrayList<String>();
        cursor.moveToFirst();

        while (!cursor.isAfterLast())
        {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(emails);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) { }

    private interface ProfileQuery
    {
        String[] PROJECTION = { ContactsContract.CommonDataKinds.Email.ADDRESS, ContactsContract.CommonDataKinds.Email.IS_PRIMARY, };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }


    private void addEmailsToAutoComplete(List<String> emailAddressCollection)
    {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LoginActivity.this, android.R.layout.simple_dropdown_item_1line, emailAddressCollection);
        txtLogin.setAdapter(adapter);
    }

    public class UserLoginUtils
    {
        private final Activity sourceActivity;

        public UserLoginUtils(Activity sourceActivity)
        {
            this.sourceActivity = sourceActivity;
        }

        public void showErrorDialog(boolean authenticationError)
        {
            if(authenticationError)
            {
                new AlertDialog.Builder(sourceActivity).setMessage(R.string.login_error_popup_message1)
                        .setTitle(R.string.login_error_popup_title)
                        .setPositiveButton(R.string.login_error_popup_yes1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Toast.makeText(LoginActivity.this, "Vai abrir a recuperação quando implementada", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton(R.string.login_error_popup_no, null).show();
            }
            else
            {
                new AlertDialog.Builder(sourceActivity).setMessage(R.string.login_error_popup_message2)
                        .setTitle(R.string.login_error_popup_title)
                        .setPositiveButton(R.string.login_error_popup_yes2, null).show();
            }
        }
    }

    /** Representa tarefa assíncrona de autenticação */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean>
    {
        private final String mLogin;
        private final String mPassword;
        private final Activity sourceActivity;

        /**
         * Construtor
         * @param login Login fornecido pelo usuário na tela de autenticação
         * @param password Senha fornecida pelo usuário na tela de autenticação
         * @param activity Referência à tela de origem da requisição.
         */
        UserLoginTask(String login, String password, Activity activity)
        {
            mLogin = login;
            mPassword = password;
            sourceActivity = activity;
        }

        @Override
        protected Boolean doInBackground(Void... params)
        {
            // TODO: attempt authentication against a network service.
            try
            {
                // Simulate network access.
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS)
            {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mLogin))
                {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success)
        {
            UserLoginUtils loginUtils = new UserLoginUtils(sourceActivity);
            mAuthTask = null;
            showProgress(false);

            if (success)
            {
                Intent internalMainActivity = new Intent(sourceActivity, InternalMainActivity.class);
                sourceActivity.startActivity(internalMainActivity);
                finish();
            }
            else
            {
                txtPassword.setError(getString(R.string.error_incorrect_password));
                txtPassword.requestFocus();
                loginUtils.showErrorDialog(true);
            }
        }

        @Override
        protected void onCancelled()
        {
            mAuthTask = null;
            showProgress(false);
        }
    }
}