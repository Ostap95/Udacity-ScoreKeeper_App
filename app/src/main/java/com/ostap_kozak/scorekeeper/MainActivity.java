package com.ostap_kozak.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int teamAScore = 0;
    private int teamBScore = 0;

    private TextView teamAName;
    private TextView teamBName;
    private TextView teamAScoreTextView;
    private TextView teamBScoreTextView;

    private Button plus3PointButtonA;
    private Button plus2PointButtonA;
    private Button plus1PointButtonA;

    private Button plus3PointButtonB;
    private Button plus2PointButtonB;
    private Button plus1PointButtonB;

    private Button undoButton;
    private Button viewHistoryButton;
    private Button resetScoreButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamAName = (TextView) findViewById(R.id.teamAName);
        teamBName = (TextView) findViewById(R.id.teamBName);

        teamAScoreTextView = (TextView) findViewById(R.id.scoreTeamA);
        teamBScoreTextView = (TextView) findViewById(R.id.scoreTeamB);

        plus1PointButtonA = (Button) findViewById(R.id.plus1PointA);
        plus2PointButtonA = (Button) findViewById(R.id.plus2PointA);
        plus3PointButtonA = (Button) findViewById(R.id.plus3PointA);

        plus1PointButtonB = (Button) findViewById(R.id.plus1PointB);
        plus2PointButtonB = (Button) findViewById(R.id.plus2PointB);
        plus3PointButtonB = (Button) findViewById(R.id.plus2PointB);

        undoButton = (Button) findViewById(R.id.undoButton);
        viewHistoryButton = (Button) findViewById(R.id.historyButton);
        resetScoreButton = (Button) findViewById(R.id.resetButton);
    }


    public void add3PointsA(View view) {

    }

    public void add2PointsA(View view) {

    }

    public void add1PointsA(View view) {

    }


    public void add3PointsB(View view) {

    }

    public void add2PointsB(View view) {

    }

    public void add1PointsB(View view) {

    }


    public void showHistory(View view) {

    }

    public void undoButton(View view) {

    }

    public void resetScore(View view) {

    }

}
