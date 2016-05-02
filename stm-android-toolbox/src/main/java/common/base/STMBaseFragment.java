package common.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by StephenMa on 16/5/2.
 */
public abstract class STMBaseFragment extends Fragment implements IBaseView{

    private STMBaseActivity mActivity;
    private View mLayoutView;

    protected abstract int getLayoutResId();
    protected abstract void initView();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLayoutView = getLayoutView(inflater, container);
        initView();
        return mLayoutView;
    }

    private View getLayoutView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(getLayoutResId(), container, false);
    }

    private boolean getStatus(){
        return isAdded() && !isRemoving();
    }

    private STMBaseActivity getBaseActivity(){
        if (mActivity == null){
            mActivity = (STMBaseActivity)getActivity();
        }
        return mActivity;
    }

    @Override
    public void showProgress(boolean cancelable, String msg) {
        if (getStatus()){
            STMBaseActivity activity = getBaseActivity();
            if (activity != null){
                activity.showProgress(cancelable, msg);
            }
        }
    }

    @Override
    public void showProgress(boolean cancelable, int resId) {
        showProgress(cancelable, getString(resId));
    }

    @Override
    public void showProgress(boolean cancelable) {
        showProgress(cancelable, "");
    }

    @Override
    public void showProgress(int resId) {
        showProgress(true, getString(resId));
    }

    @Override
    public void showProgress() {
        showProgress(true, "");
    }

    @Override
    public void hideProgress() {
        if (getStatus()){
            STMBaseActivity activity = getBaseActivity();
            if (activity != null){
                activity.hideProgress();
            }
        }
    }

    @Override
    public void showToast(int resId) {
        showToast(getString(resId));
    }

    @Override
    public void showToast(String msg) {
        if (getStatus()) {
            STMBaseActivity activity = getBaseActivity();
            if (activity != null) {
                activity.showToast(msg);
            }
        }
    }
}
