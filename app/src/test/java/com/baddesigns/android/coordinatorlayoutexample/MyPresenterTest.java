package com.baddesigns.android.coordinatorlayoutexample;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by Jon-Ross on 30/11/2016.
 */
public class MyPresenterTest {

    @Mock MyContract.View mView;
    @Mock Model mModel;

    MyPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        mPresenter = new MyPresenter();
        mPresenter.setView(mView);
        mPresenter.mModel = mModel;
    }

    @Test
    public void onCoordinatorCollapsed() throws Exception {
        when(mModel.getClState()).thenReturn(Model.CL_COLLAPSED);

        mPresenter.onCoordinatorCollapsed();

        verify(mModel).setClState(Model.CL_COLLAPSED);
        verify(mView).showCollapsedNotification();
        verify(mView).setTextViewState(true);
    }

    @Test
    public void onCoordinatorExpanded() throws Exception {
        when(mModel.getClState()).thenReturn(Model.CL_EXPANDED);

        mPresenter.onCoordinatorExpanded();

        verify(mModel).setClState(Model.CL_EXPANDED);
        verify(mView).showExpandedNotification();
        verify(mView).setTextViewState(false);
    }

    @Test
    public void onCoordinatorIdle() throws Exception {
        when(mModel.getClState()).thenReturn(Model.CL_IDLE);

        mPresenter.onCoordinatorIdle();

        verify(mModel).setClState(Model.CL_IDLE);
        verify(mView).setTextViewState(true);
    }

    @Test
    public void onButtonPressed_wasCollapsed() throws Exception {
        when(mModel.getClState()).thenReturn(Model.CL_COLLAPSED);

        mPresenter.onButtonPressed();

        verify(mView).expand();
    }

    @Test
    public void onButtonPressed_wasExpanded() throws Exception {
        when(mModel.getClState()).thenReturn(Model.CL_EXPANDED);

        mPresenter.onButtonPressed();

        verify(mView).collapse();
    }

    @Test
    public void onButtonPressed_wasIdle() throws Exception {
        when(mModel.getClState()).thenReturn(Model.CL_IDLE);

        mPresenter.onButtonPressed();

        verify(mView).expand();
    }

    @Test
    public void onResume_isCollapsed() throws Exception {
        when(mModel.getClState()).thenReturn(Model.CL_COLLAPSED);

        mPresenter.onResume();

        verify(mView).setTextViewState(true);
    }

    @Test
    public void onResume_isExpanded() throws Exception {
        when(mModel.getClState()).thenReturn(Model.CL_EXPANDED);

        mPresenter.onResume();

        verify(mView).setTextViewState(false);
    }

    @Test
    public void getModel() throws Exception {
        Model model = mPresenter.getModel();

        assertEquals(mModel, model);
    }

    @Test
    public void setModel() throws Exception {
        mPresenter.setModel(mModel);

        assertEquals(mModel, mPresenter.getModel());
    }

    @Test
    public void getView() throws Exception {
        MyContract.View view = mPresenter.getView();

        assertEquals(mView, view);
    }

    @Test
    public void setView() throws Exception {
        mPresenter.setView(mView);

        assertEquals(mView, mPresenter.getView());
    }

}