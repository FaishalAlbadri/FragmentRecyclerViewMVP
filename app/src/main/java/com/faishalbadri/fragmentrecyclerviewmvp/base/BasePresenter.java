package com.faishalbadri.fragmentrecyclerviewmvp.base;

/**
 * Created by faishal on 9/28/17.
 */

public interface BasePresenter<T> {
    void onAttachView(T view);
    void onDettachView();
}
