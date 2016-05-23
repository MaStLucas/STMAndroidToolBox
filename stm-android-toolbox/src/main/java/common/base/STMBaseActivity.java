package common.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by StephenMa on 16/5/2.
 */
public abstract class STMBaseActivity extends AppCompatActivity implements IBaseView{

    private ProgressDialog mProgressDialog;

    protected abstract void initContentView();
    protected abstract void initPresenter();
    protected abstract void initView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initContentView();
        initPresenter();
        initView();
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void showProgress(boolean cancelable, String msg) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(cancelable);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setMessage(msg);
        }
        mProgressDialog.show();
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
        if (mProgressDialog == null) {
            return;
        }
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(int resId) {
        showToast(getString(resId));
    }

    @Override
    public void showToast(String msg) {
        if (!isFinishing()) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
