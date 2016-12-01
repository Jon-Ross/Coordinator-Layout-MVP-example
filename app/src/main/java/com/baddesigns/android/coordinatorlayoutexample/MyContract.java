package com.baddesigns.android.coordinatorlayoutexample;

/**
 * Created by Jon-Ross on 30/11/2016.
 */

public interface MyContract {

    interface Presenter extends IPresenter<View, Model> {
        void onCoordinatorCollapsed();
        void onCoordinatorExpanded();
        void onCoordinatorIdle();
        void onButtonPressed();
        void onResume();
    }

    interface View extends IView<Presenter> {
        void showCollapsedNotification();
        void showExpandedNotification();
        void expand();
        void collapse();
        void setTextViewState(boolean collapsed);
    }
}
