package com.binary01.chat;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
//import androidx.appcompat.widget.AppCompatTextView;
import android.widget.TextView;
import io.noties.markwon.Markwon;

public class MarkdownTextView extends TextView {

    private Markwon markwon;
    private int linkColor; // Link color variable

    public MarkdownTextView(Context context) {
        super(context);
        initialize();
    }

    public MarkdownTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public MarkdownTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        markwon = Markwon.create(getContext());
        setMovementMethod(LinkMovementMethod.getInstance()); // Enable link clicks
        setClickable(true);
        setFocusable(true);
        setLongClickable(true);
    }


    public void setMarkdown(String markdown) {
        CharSequence formatted = markwon.toMarkdown(markdown);
        setText(formatted);
    }
}
