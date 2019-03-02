package com.example.akash.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    static int winstate=0;
    boolean instruct=true;
    int coinTurn=1;
    //1 for yellow, 0 for red, 2 for empty
    int[] gameState={2,2,2,2,2,2,2,2,2};
    //for each imageView here we are setting empty by setting 2 in each.
    int[][] winningPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    //set of position where if all the position match with same coin then that coin's player wins.
    static int tappedCunt=0;
    public void instructionOn(View view)
    {

        TextView instructionText=(TextView)findViewById(R.id.textView1);
        Button instructionButton=(Button)findViewById(R.id.instructionon);
        if (instruct) {
            instructionText.setText("->2 Player Game\n->choose between red and yellow coins\n->Manage 3 consecutive coins\nto win");
            instructionText.setVisibility(View.VISIBLE);
            instructionButton.setText("Instruction Off");
            instruct=false;
        }
        else
        {
            instruct=true;
            instructionText.setVisibility(View.INVISIBLE);
            instructionButton.setText("Instruction On");

        }


    }

    public void restart(View view)
    {
        Button restartButton=(Button)findViewById(R.id.playButton);

        TextView text=(TextView)findViewById(R.id.winText);
        restartButton.setVisibility(view.INVISIBLE);
        text.setVisibility(view.INVISIBLE);
        setContentView(R.layout.activity_main);
        for(int i=0;i<9;i++)
        {
            gameState[i]=2;
        }
        coinTurn=1;
        winstate=0;
        tappedCunt=0;
    }
    public void dropIn(View view)
    {
        String message="";
         //winstate=0;
        if(winstate==0) {
            ImageView counter = (ImageView) view;


            Log.i("tapped imageview of tag", counter.getTag().toString());
            int tappedImageView = Integer.parseInt(counter.getTag().toString());
            if (gameState[tappedImageView] == 2) {
                gameState[tappedImageView] = coinTurn;

                counter.setTranslationY(-1000);
                if (coinTurn == 1) {

                    coinTurn = 0;
                    counter.setImageResource(R.drawable.yellow);
                    tappedCunt++;
                } else {
                    coinTurn = 1;
                    counter.setImageResource(R.drawable.red);
                    tappedCunt++;
                }
                counter.animate().translationY(10).rotation(72000).setDuration(1000);
                for (int[] winningPostion : winningPosition) {
                    if (gameState[winningPostion[0]] == gameState[winningPostion[1]] && gameState[winningPostion[1]] == gameState[winningPostion[2]] && gameState[winningPostion[0]] != 2) {
                        winstate=1;
                        Button restartButton=(Button)findViewById(R.id.playButton);
                        restartButton.setVisibility(View.VISIBLE);
                        TextView text=(TextView)findViewById(R.id.winText);
                        if (gameState[winningPostion[0]] == 1) {
                            message = "Person with Yellow coin has won!";
                        } else if (gameState[winningPostion[0]] == 0) {
                            message = "Person with Red coin has won!";
                            //text.setTextColor(241);
                        }
                        text.setVisibility(View.VISIBLE);
                        text.setText(message);

                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                    }



                }

                ///CHECK ON FOLLOWING WHERE DID I GO WRONG.
        /*int i;
        for(i=0;i<9;i++)
        {
            int j=0;
            if(gameState[winningPosition[i][0]]==gameState[winningPosition[i][1]]&&gameState[winningPosition[i][1]]==gameState[winningPosition[i][2]]&&gameState[winningPosition[i][0]]!=0)
            {
                Toast.makeText(this,"someone has won",Toast.LENGTH_LONG).show();
            }
        }*/
            }
            if (tappedCunt == 9) {
                message = "GameOver!";
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                Button restartButton=(Button)findViewById(R.id.playButton);
                restartButton.setVisibility(View.VISIBLE);
            }
        }
        else
        {
            message="Game is already over!";
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
