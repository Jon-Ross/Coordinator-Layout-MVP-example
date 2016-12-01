package com.baddesigns.android.coordinatorlayoutexample;

/**
 * Created by Jon-Ross on 30/11/2016.
 */
public class MyPresenter implements MyContract.Presenter {

    MyContract.View mView;
    Model mModel;

    public MyPresenter() {
        mModel = new Model();
    }

    @Override
    public void onCoordinatorCollapsed() {
        mModel.setClState(Model.CL_COLLAPSED);
        mView.showCollapsedNotification();
        mView.setTextViewState(clIsCollapsed());
    }

    @Override
    public void onCoordinatorExpanded() {
        mModel.setClState(Model.CL_EXPANDED);
        mView.showExpandedNotification();
        mView.setTextViewState(clIsCollapsed());
    }

    @Override
    public void onCoordinatorIdle() {
        mModel.setClState(Model.CL_IDLE);
        mView.setTextViewState(clIsCollapsed());
    }

    @Override
    public void onButtonPressed() {
        boolean collapsed = clIsCollapsed();
        if(collapsed) {
            mView.expand();
        } else {
            mView.collapse();
        }
    }

    @Override
    public void onResume() {
        boolean collapsed = clIsCollapsed();
        mView.setTextViewState(collapsed);
    }

    private boolean clIsCollapsed() {
        int clState = mModel.getClState();
        return clState == Model.CL_COLLAPSED || clState == Model.CL_IDLE;
    }

    // ************************** GETTERS AND SETTERS **************************

    @Override
    public MyContract.View getView() {
        return mView;
    }

    @Override
    public void setView(MyContract.View view) {
        mView = view;
    }

    @Override
    public Model getModel() {
        return mModel;
    }

    @Override
    public void setModel(Model model) {
        mModel = model;
    }
}
