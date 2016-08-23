package framework.interfaces;

public interface IViewModelFactory<T extends IPresenter> {
    T create();
}
