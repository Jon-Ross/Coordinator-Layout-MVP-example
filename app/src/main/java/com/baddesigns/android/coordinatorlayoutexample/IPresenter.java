package com.baddesigns.android.coordinatorlayoutexample;

/**
 * Created by Jon-Ross on 30/11/2016.
 */

public interface IPresenter<V extends IView, M> {
    V getView();
    void setView(V view);
    M getModel();
    void setModel(M model);
}
