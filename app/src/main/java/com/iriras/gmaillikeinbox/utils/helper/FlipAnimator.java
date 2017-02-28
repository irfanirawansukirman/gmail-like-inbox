package com.iriras.gmaillikeinbox.utils.helper;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;

import com.iriras.gmaillikeinbox.R;

/**
 * Created by irfan on 28/02/17.
 */

public class FlipAnimator {
    private static String TAG = FlipAnimator.class.getSimpleName();
    private static AnimatorSet leftIn, rightOut, leftOut, rightIn;

    public static void flipView(Context context, final View back, final View front, boolean showFront) {
        leftIn = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.card_flip_left_in);
        rightOut = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.card_flip_right_out);
        leftOut = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.card_flip_left_out);
        rightIn = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.card_flip_right_in);

        final AnimatorSet showFrontAnim = new AnimatorSet();
        final AnimatorSet showBackAnim = new AnimatorSet();

        leftIn.setTarget(back);
        rightOut.setTarget(front);
        showFrontAnim.playTogether(leftIn, rightOut);

        leftOut.setTarget(back);
        rightIn.setTarget(front);
        showBackAnim.playTogether(rightIn, leftOut);

        if (showFront) {
            showFrontAnim.start();
        } else {
            showBackAnim.start();
        }
    }
}