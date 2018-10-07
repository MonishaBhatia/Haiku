package haiku.app.com;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;

public class EnglishActivity extends AppCompatActivity {

    @BindView(R.id.view_pager_dots)
    LinearLayout viewPagerDots;
    private TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[4];

        viewPagerDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            dots[i].setTextColor(Color.parseColor("#d8d8d8"));
            viewPagerDots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[currentPage].setTextColor(Color.parseColor("#000000"));
        }
    }

}
