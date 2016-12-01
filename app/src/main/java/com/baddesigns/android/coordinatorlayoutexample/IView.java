package com.baddesigns.android.coordinatorlayoutexample;

/**
 * Created by Jon-Ross on 30/11/2016.
 */

public interface IView<P extends IPresenter> {
    P getPresenter();
    void setPresenter(P presenter);
}
