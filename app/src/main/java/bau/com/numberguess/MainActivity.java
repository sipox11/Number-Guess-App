package bau.com.numberguess;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private EditText etName;
    private String userName;
    private EditText etNum;
    private int userNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initApp();
    }

    /***********************************************************************************************
     * Method to init the app
     **********************************************************************************************/
    private void initApp(){
        mContext = this;
        etName = (EditText) findViewById(R.id.et_user_name);
        etNum = (EditText) findViewById(R.id.et_user_num);

    }

    /***********************************************************************************************
     * Method to handle button click
     * @param view the view that was click
     **********************************************************************************************/
    public void handleButtonClick(View view){
        switch (view.getId()){
            case R.id.btn_play:
                userName = etName.getText().toString();
                if (userName.matches("")) {
                    etName.setError(getString(R.string.error_not_name));
                }else if(etNum.getText().toString().matches("0")){
                    etNum.setError(getString(R.string.error_not_main_number));

                }else if(etNum.getText().toString().matches("")){
                    etNum.setError(getString(R.string.error_not_main_number));

                }else {
                    userNumber = Integer.parseInt(etNum.getText().toString());
                    startGame();
                }
                break;
            default:
                break;
        }
    }

    /***********************************************************************************************
     * Method to bring to the Game activity
     **********************************************************************************************/
    private void startGame(){
        Intent i = new Intent(mContext, GameActivity.class);
        String tag = "name";
        i.putExtra(tag, userName );
        String tagNum = "num";
        i.putExtra(tagNum, userNumber);
        startActivity(i);
    }

    /***********************************************************************************************
     * Method to go to the leaderboard Activity
     * @param view
     **********************************************************************************************/
    public void leaderBoard(View view ){
        Intent ii = new Intent(mContext, LeaderboardActivity.class);
        startActivity(ii);
    }

}

