package framework.interfaces;

public interface IPresenter {
    void onViewAttached();

    void onViewDetached();

    void onDestroyed();
}
