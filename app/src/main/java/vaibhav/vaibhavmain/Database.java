package vaibhav.vaibhavmain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



/**
 * Created by simpl on 15-04-2017.
 */


public class Database extends AppCompatActivity implements  View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private EditText editTextMail;
    private EditText editTextName;
    private Integer count;
    DatabaseReference User;
    Button save;
    Button btn1;
    int counter = 0;
    EditText scoreText;
    private EditText id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user);
        firebaseAuth = FirebaseAuth.getInstance();


        User = FirebaseDatabase.getInstance().getReference("artists");
        btn1 = (Button)findViewById(R.id.counter);
        editTextName = (EditText) findViewById(R.id.editTextName);
         editTextMail = (EditText) findViewById(R.id.editTextMail);
        id=(EditText) findViewById(R.id.id);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v) {
                add();


            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v == btn1){
                    counter++;


                }

            }
        });

    }

    private void add() {
        //getting the values to save
        String username = editTextName.getText().toString().trim();
        String mail = editTextMail.getText().toString().trim();
String id=editTextMail.getText().toString().trim();
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v == btn1){
                    counter++;


                }

            }
        });
        Integer count=counter;
        //checking if the value is provided
        if (!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(id)&&!TextUtils.isEmpty(mail)) {

            //getting a unique id using push().getKey() method

            //it will create a unique id and we will use it as the Primary Key for our Artist


            //creating an Artist Object
            UserInformation artist = new UserInformation(username, mail,count);

            //Saving the Artist
            User.child(id).setValue(artist);

            //setting edit text to blank again
            editTextName.setText("");

            //displaying a success toast
            Toast.makeText(this, "Data added", Toast.LENGTH_LONG).show();
            Intent i= new Intent(this,LoginActivity.class);
            startActivity(i);
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public void onClick(View v) {

    }

}
