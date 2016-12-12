package com.eaccid.hocreader.presentation.fragment.book;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.eaccid.hocreader.exception.NotImplementedException;
import com.eaccid.hocreader.provider.wordgetter.WordFromText;
import com.eaccid.hocreader.provider.wordgetter.WordOnTextViewFinder;

public class OnWordFromPageViewTouchListener implements View.OnTouchListener{

    private int pageNumber;

    public interface OnWordFromTextClickListener {
        void OnWordClicked(WordFromText wordFromText);
    }

    public OnWordFromPageViewTouchListener(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.AXIS_Y:
                TextView tv = (TextView) view;
                WordFromText wordFromText = WordOnTextViewFinder.getWordByMotionEvent(tv, motionEvent);
                wordFromText.setPageNumber(pageNumber);
                if (!wordFromText.getText().isEmpty()) {
                    try {
                        ((OnWordFromTextClickListener) view.getContext()).OnWordClicked(wordFromText);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new NotImplementedException("'interface " +
                                "OnWordFromPageViewTouchListener.OnWordFromTextClickListener: ' " +
                                "method is not implemented in " + "'" +
                                view.getContext().getPackageName() + "." +
                                view.getContext().getClass().getName() + "'");
                    }
                }
        }
        return true;
    }

}
