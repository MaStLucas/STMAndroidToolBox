package common.base;

/**
 * Created by StephenMa on 16/5/2.
 */
public interface IBaseView {

    void showProgress(boolean cancelable, String msg);
    void showProgress(boolean cancelable, int resId);
    void showProgress(boolean cancelable);
    void showProgress(int resId);
    void showProgress();

    void hideProgress();

    void showToast(int resId);
    void showToast(String msg);

}
