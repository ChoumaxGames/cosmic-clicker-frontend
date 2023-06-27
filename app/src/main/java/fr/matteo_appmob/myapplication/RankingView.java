package fr.matteo_appmob.myapplication;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class RankingView extends ConstraintLayout {


    public RankingView(Context context, String name, int position, int score) {
        super(context);

        ConstraintLayout layout = (ConstraintLayout) inflate(context, R.layout.template_user_ranking, null);
        ((ImageView) layout.findViewById(R.id.user_ranking_image)).setImageResource(R.drawable.user_ranking);

        switch (position) {
            case 1:
                ((ImageView) layout.findViewById(R.id.user_ranking_medal)).setImageResource(R.drawable.ranking_medaile_1);
                break;
            case 2:
                ((ImageView) layout.findViewById(R.id.user_ranking_medal)).setImageResource(R.drawable.ranking_medaile_2);
                break;
            case 3:
                ((ImageView) layout.findViewById(R.id.user_ranking_medal)).setImageResource(R.drawable.ranking_medaile_3);
                break;
            default:
                ((ImageView) layout.findViewById(R.id.user_ranking_medal)).setVisibility(INVISIBLE);
                break;
        }

        ((TextView) layout.findViewById(R.id.user_ranking_name)).setText(name);
        ((TextView) layout.findViewById(R.id.user_ranking_rank)).setText(String.valueOf(position));
        ((TextView) layout.findViewById(R.id.user_ranking_score)).setText(String.valueOf(score));

        this.addView(layout);
    }
}