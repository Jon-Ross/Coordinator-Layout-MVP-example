package com.baddesigns.android.coordinatorlayoutexample;

/**
 * Created by Jon-Ross on 30/11/2016.
 */
public class Model {

    public static final int CL_COLLAPSED = 0;
    public static final int CL_EXPANDED = 1;
    public static final int CL_IDLE = 2;

    private int clState;

    // ************************** GETTERS AND SETTERS **************************

    public int getClState() {
        return clState;
    }

    public void setClState(int clState) {
        this.clState = clState;
    }
}
