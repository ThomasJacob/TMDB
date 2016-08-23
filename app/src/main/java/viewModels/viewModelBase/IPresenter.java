package viewModels.viewModelBase;

public interface IPresenter<V>{
    void onViewAttached(V view);
    void onViewDetached();
    void onDestroyed();
}
