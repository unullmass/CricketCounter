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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateScoreForTeam() {
        TextView t_a = findViewById(R.id.team_a_score);
        t_a.setText((score_A_runs + score_B_extras) + " / " + (score_A_wkts % 10));
        TextView t_b = findViewById(R.id.team_b_overs);
        t_b.setText(score_B_overs / 6 + "." + (score_B_overs % 6));

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
    
}
