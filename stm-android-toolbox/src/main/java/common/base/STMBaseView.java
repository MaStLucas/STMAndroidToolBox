package common.base;

import android.content.Context;

/**
 * Created by shengtaoma on 5/30/16.
 */
public interface STMBaseView<T> {

    void setPresenter(T presenter);

    Context getViewContext();
}
