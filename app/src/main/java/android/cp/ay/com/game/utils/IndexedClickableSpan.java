package android.cp.ay.com.game.utils;

import android.content.Context;
import android.cp.ay.com.game.listener.WordClickListener;
import android.text.style.ClickableSpan;
import android.view.View;

/**
 * Created by ayesh on 9/10/15.
 */
public class IndexedClickableSpan extends ClickableSpan {

    int startIndex, endIndex;
    private Context context;
    private String text;
    private WordClickListener listener;

    public IndexedClickableSpan(int startIndex, int endIndex, Context context, String text,WordClickListener listener) {
        this.startIndex  = startIndex;
        this.endIndex    = endIndex;
        this.context     = context;
        this.text        = text;
        this.listener    = listener;
    }

    @Override
    public void onClick(View widget) {
        String word = text.substring(startIndex, endIndex);


        listener.onWordClick(word);

    }
}