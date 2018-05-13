package unullmass.net.cricketcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int score_A_runs = 0;
    private int score_A_wkts = 0;
    private int score_B_overs = 0;
    private int score_B_extras = 0;
    private double score_B_economy = 0.0;
    private int score_A_sr = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateScoreForTeam() {
        // set the runs
        TextView t_a = findViewById(R.id.team_a_score);
        t_a.setText((score_A_runs + score_B_extras) + " / " + (score_A_wkts % 10));

        // set the overs
        TextView t_b = findViewById(R.id.team_b_overs);
        t_b.setText(score_B_overs / 6 + "." + (score_B_overs % 6));

        // set the extras
        TextView t_extras = findViewById(R.id.team_a_extras);
        t_extras.setText("Extras: " + score_B_extras);

        // set the strike rate
        score_A_sr = (int) ((score_A_runs * 100) / (score_B_overs / 6.0));
        TextView t_strikerate = findViewById(R.id.team_a_strikerate);
        t_strikerate.setText("SR: " + String.format("%d", score_A_sr) + "%");

        // set the economy
        score_B_economy = (score_A_runs + score_B_extras) * 100.0 / (score_B_overs / 6.0);
        TextView t_eco = findViewById(R.id.team_b_economy);
        t_eco.setText("Eco: " + String.format("%.2f", score_B_economy));


    }

    public void updateDotBallBowled(View view) {
        score_B_overs++;
        updateScoreForTeam();
    }

    public void updateNoBallBowled(View view) {
        score_B_extras++;
        updateScoreForTeam();
    }

    public void updateWideBallBowled(View view) {
        score_B_extras++;
        updateScoreForTeam();
    }

    public void update1RunScored(View view) {
        score_A_runs++;
        score_B_overs++;
        updateScoreForTeam();
    }

    public void update2RunsScored(View view) {
        score_A_runs += 2;
        score_B_overs++;
        updateScoreForTeam();
    }

    public void update3RunsScored(View view) {
        score_A_runs += 3;
        score_B_overs++;
        updateScoreForTeam();
    }

    public void update4RunsScored(View view) {
        score_A_runs += 4;
        score_B_overs++;
        updateScoreForTeam();
    }

    public void update6RunsScored(View view) {
        score_A_runs += 6;
        score_B_overs++;
        updateScoreForTeam();
    }

    public void updateWicketTaken(View view) {
        if (score_A_wkts <= 9) {
            score_B_overs++;
            score_A_wkts++;
            updateScoreForTeam();
        }
    }

    public void resetTeamScores(View view) {
        score_A_runs = 0;
        score_A_wkts = 0;
        score_B_overs = 0;
        score_B_extras = 0;
        score_B_economy = 0.0;
        score_A_sr = 0;
        updateScoreForTeam();

    }

}
