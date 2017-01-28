package com.ostap_kozak.scorekeeper;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int teamAScore = 0;
    private int teamBScore = 0;

    private TextView teamAName;
    private TextView teamBName;
    private TextView teamAScoreTextView;
    private TextView teamBScoreTextView;

    private ArrayList<String> scoreHistory = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamAName = (TextView) findViewById(R.id.teamAName);
        teamBName = (TextView) findViewById(R.id.teamBName);

        teamAScoreTextView = (TextView) findViewById(R.id.scoreTeamA);
        teamBScoreTextView = (TextView) findViewById(R.id.scoreTeamB);

    }


    public void add3PointsA(View view) {
        teamAScore += 3;
        updateScore(teamAScore, teamAScoreTextView);
        scoreHistory.add(teamAName.getText().toString() + " +3");
    }

    public void add2PointsA(View view) {
        teamAScore += 2;
        updateScore(teamAScore, teamAScoreTextView);
        scoreHistory.add(teamAName.getText().toString() + " +2");
    }

    public void add1PointsA(View view) {
        updateScore(++teamAScore, teamAScoreTextView);
        scoreHistory.add(teamAName.getText().toString() + " +1");
    }


    public void add3PointsB(View view) {
        teamBScore += 3;
        updateScore(teamBScore, teamBScoreTextView);
        scoreHistory.add(teamBName.getText().toString() + " +3");
    }

    public void add2PointsB(View view) {
        teamBScore += 2;
        updateScore(teamBScore, teamBScoreTextView);
        scoreHistory.add(teamBName.getText().toString() + " +2");
    }

    public void add1PointsB(View view) {
        updateScore(++teamBScore, teamBScoreTextView);
        scoreHistory.add(teamBName.getText().toString() + " +1");
    }


    public void showHistory(View view) {
        // Creates custom TextView that will contain history data inside AlertDialog
        TextView textView = new TextView(this);
        textView.setPadding(16,16,16,16);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        textView.setGravity(Gravity.CENTER);
        textView.setMovementMethod(new ScrollingMovementMethod()); // Makes textView scrollable

        StringBuilder historyLOG = new StringBuilder();

        for (String item: scoreHistory) {
            historyLOG.append(item + "\n");
        }

        textView.setText(historyLOG);
        new AlertDialog.Builder(this)
                .setTitle("Game History")
                .setView(textView)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

    }

    public void undoScore(View view) {
        if (!scoreHistory.isEmpty()) {
            String removedElement = scoreHistory.remove(scoreHistory.size()-1);
            int value = Integer.parseInt(removedElement.replaceAll("[^0-9]", ""));
            if (removedElement.contains(teamAName.getText().toString())) {
                teamAScore -= value;
                updateScore(teamAScore, teamAScoreTextView);
            } else {
                teamBScore -= value;
                updateScore(teamBScore, teamBScoreTextView);
            }
        }
    }

    public void resetScore(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Reset Score")
                .setMessage("Are you sure?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        teamAScore = 0;
                        teamBScore = 0;
                        updateScore(teamAScore, teamAScoreTextView);
                        updateScore(teamBScore, teamBScoreTextView);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                }).show();
        scoreHistory.clear(); // Clears History log
    }

    public void updateScore(int score, TextView scoreView) {
        scoreView.setText(Integer.toString(score));
    }

    public void changeTeamAName(View view) {
        final EditText teamNameEditText = new EditText(this);
        teamNameEditText.setHint("Team Name");
        new AlertDialog.Builder(this)
                .setTitle("Name for Team A")
                .setView(teamNameEditText)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (!teamNameEditText.getText().toString().isEmpty())
                            teamAName.setText(teamNameEditText.getText().toString());
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                }).show();
    }


    public void changeTeamBName(View view) {
        final EditText teamNameEditText = new EditText(this);
        teamNameEditText.setHint("Team Name");
        new AlertDialog.Builder(this)
                .setTitle("Name for Team B")
                .setView(teamNameEditText)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (!teamNameEditText.getText().toString().isEmpty())
                            teamBName.setText(teamNameEditText.getText().toString());
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                }).show();
    }

}
