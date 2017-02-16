package bsru.junpukdee.sutin.bsrufriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Explicit การประกาศตัวแปร
    private Button signInButton, signUpButton;
    private EditText userEditText, passEditText;
    private String userString, passString;
    private String[] loginStringsStrings;
    private static final String urlPHP = "http://swiftcodingthai.com/bsru/get_user_master.php"; //การประกาศตัวแปรค่าคงที่ที่ไม่สามารถเปลี่ยนแปลงค่าได้


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sind Widget คือ การ Inital Var กับ View บน XML
        signInButton = (Button) findViewById(R.id.button2);
        signUpButton = (Button) findViewById(R.id.button);
        userEditText = (EditText) findViewById(R.id.editText);
        passEditText = (EditText) findViewById(R.id.editText2);

        //Button Controller
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Check Space and get Value from Edit Text
                userString = userEditText.getText().toString().trim();
                passString = passEditText.getText().toString().trim();
                if (userString.equals("")  || passString.equals("")) {
                    //Have Space
                    MyAlert myAlert = new MyAlert(MainActivity.this);
                    myAlert.myDialog("มีช่องว่าง", "กรุณากรอกทุกช่อง");
                }   else {
                    //No Space
                    checkUserPass();

                }


            }   //onClick
        });



    } // Main Method

    private void checkUserPass() {

        try{

            GetUser getUser = new GetUser(MainActivity.this);
            getUser.execute(urlPHP);
            String strJSON = getUser.get();
            Log.d("16febV1", "strJSON ==> " + strJSON);


        } catch (Exception e) {
            Log.d("16febV1", "e checkUserPass ==> " + e.toString());
        }


    }   //checkUserPass

} // Main Class อันนี้หน้าหลักนะจ๊ะ
