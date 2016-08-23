package application;

import viewModels.viewModelBase.IPresenter;

public interface IViewModelFactory<T extends IPresenter> {
    T create();
}
