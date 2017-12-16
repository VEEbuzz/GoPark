package vaibhav.vaibhavmain;

/**
 * Created by simpl on 12-04-2017.
 */


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {

    private boolean running = false;
    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "Re2xLcDHKxphJxxH3FoHtRk8p";
    private static final String TWITTER_SECRET = "DLFDH2KrCxhJ5twoLjEF06R8I5hCswP4aTE6fQlfvGQACAoNSX";


    //defining view objects
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignup;
    private Button AlrRegister;
    private ProgressDialog progressDialog;


    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;
   private UserInfo userInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        running = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  User = FirebaseDatabase.getInstance().getReference("artists");
        DigitsAuthButton digitsButton = (DigitsAuthButton) findViewById(R.id.auth_button);

       digitsButton.setCallback(new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                // TODO: associate the session userID with your user model
                Toast.makeText(getApplicationContext(), "Authentication successful for "
                        + phoneNumber, Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(DigitsException exception) {
                Log.d("Digits", "Sign in with Digits failure", exception);
            }
        });

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits.Builder().build());




        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        //initializing views
      //  editTextName = (EditText) findViewById(R.id.editTextName);
      //  editTextMail = (EditText) findViewById(R.id.editTextMail);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonSignup = (Button) findViewById(R.id.buttonSignup);
        buttonSignup.setOnClickListener(new View.OnClickListener()

                                        {
                                            @Override
                                            public void onClick(View v) {
                                                registerUser();
                                            }
                                        });
        AlrRegister =(Button) findViewById(R.id.btn_signin);
        progressDialog = new ProgressDialog(this);
        /*save = (Button) findViewById(R.id.save);
       save.setOnClickListener(new View.OnClickListener() {

                                   @Override
                                   public void onClick(View v) {

                                       add();
                                   }
                               });
        //attaching listener to button
      //  buttonSignup.setOnClickListener(this);
      */  AlrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignIn.class));
            }
        });
    }
/*private void add()
{
    //getting the values to save
    String username = editTextName.getText().toString().trim();
    String mail = editTextMail.getText().toString().trim();

    //checking if the value is provided
    if (!TextUtils.isEmpty(username)) {

        //getting a unique id using push().getKey() method
        //it will create a unique id and we will use it as the Primary Key for our Artist
        String id = User.push().getKey();

        //creating an Artist Object
        UserInformation artist = new UserInformation(username, mail);

        //Saving the Artist
        User.child(id).setValue(artist);

        //setting edittext to blank again
        editTextName.setText("");

        //displaying a success toast
        Toast.makeText(this, "Artist added", Toast.LENGTH_LONG).show();
    } else+ {
        //if the value is not given displaying a toast
        Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
    }
}*/
    private void registerUser(){

        //getting email and password from edit texts
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();


        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here

                            Toast.makeText(LoginActivity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(LoginActivity.this, MapsActivity.class);
                            startActivity(i);


                        }else{
                            //display some message here
                            Toast.makeText(LoginActivity.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

    }


    @Override
    public void onClick(View v) {

    }
}

