package haiku.app.com;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.graphics.PorterDuff.Mode.SRC_ATOP;

public class EnglishActivity extends AppCompatActivity {

    @BindView(R.id.view_pager_dots)
    LinearLayout viewPagerDots;
    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.iv_left_circle)
    ImageView ivLeftCircle;
    @BindView(R.id.iv_right_circle)
    ImageView ivRightCircle;
    @BindView(R.id.iv_bottom_circle)
    ImageView ivBottomCircle;
    @BindView(R.id.rect_one)
    ImageView ivRectOne;
    @BindView(R.id.rect_two)
    ImageView ivRectTwo;
    @BindView(R.id.rect_three)
    ImageView ivRectThree;
    private TextView[] dots;
    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        ButterKnife.bind(this);

        addBottomDots(currentPage);
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
            dots[currentPage].setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    @OnClick(R.id.tv_next)
    public void onClickNext() {

        currentPage++;

        switch (currentPage) {
            case 1:
                tvText.setText(getString(R.string.text_two));
                addBottomDots(currentPage);
                slideToLeft(tvText, tvText, 500);
                slideToBottom(ivLeftCircle,500);
                ivRectOne.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.dark_red)));
                break;
            case 2:
                tvText.setText(getString(R.string.text_two));
                slideToLeft(tvText, tvText, 500);
                addBottomDots(currentPage);
                slideToBottomRight(ivRightCircle, 500);
                ivRectTwo.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.red)));
                break;
            case 3:
                tvText.setText(getString(R.string.text_three));
                slideToLeft(tvText, tvText, 500);
                addBottomDots(currentPage);
                slideToBottomRight(ivBottomCircle, 500);
                ivRectThree.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.yellow)));
                break;
            default:
                break;
        }
    }


    public void slideToLeft(View viewGone, View viewVisble, long duration) {

        TranslateAnimation animate = slideToLeftAnimation(viewGone, duration);
        Animation slideLeftFromRight = getSlideToLeftFromRight(duration);

        viewGone.startAnimation(animate);
        viewGone.setVisibility(View.GONE);

        viewVisble.setVisibility(View.VISIBLE);
        viewVisble.setAnimation(slideLeftFromRight);

    }

    public Animation getSlideToLeftFromRight(long duration) {
        Animation slideLeftFromRight = AnimationUtils.loadAnimation(this, R.anim.slide_left_right);
        slideLeftFromRight.setDuration(duration);

        return slideLeftFromRight;
    }

    public TranslateAnimation slideToLeftAnimation(View viewGone, long duration) {
        TranslateAnimation animate = new TranslateAnimation(0, -viewGone.getWidth(), 0, 0);
        animate.setDuration(duration);
        animate.setFillAfter(true);

        return animate;
    }


    public void slideToBottom(View viewGone, long duration) {
        Animation slideBottom = getSlideToBottom(duration);
        viewGone.startAnimation(slideBottom);
        viewGone.setVisibility(View.GONE);
    }


    public Animation getSlideToBottom(long duration) {
        Animation slideTop = AnimationUtils.loadAnimation(this, R.anim.slide_bottom);
        slideTop.setDuration(duration);

        return slideTop;
    }

    public void slideToBottomRight(View viewGone, long duration) {
        Animation slideBottom = getSlideToBottomRight(duration);
        viewGone.startAnimation(slideBottom);
        viewGone.setVisibility(View.GONE);
    }


    public Animation getSlideToBottomRight(long duration) {
        Animation slideTop = AnimationUtils.loadAnimation(this, R.anim.slide_bottom_right);
        slideTop.setDuration(duration);

        return slideTop;
    }

    public void slideToTop(View viewGone, long duration) {
        Animation slideBottom = getSlideToBottomRight(duration);
        viewGone.startAnimation(slideBottom);
        viewGone.setVisibility(View.GONE);
    }


    public Animation getSlideToTop(long duration) {
        Animation slideTop = AnimationUtils.loadAnimation(this, R.anim.slide_top);
        slideTop.setDuration(duration);

        return slideTop;
    }
}