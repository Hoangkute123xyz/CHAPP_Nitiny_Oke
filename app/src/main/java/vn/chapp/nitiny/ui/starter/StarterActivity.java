package vn.chapp.nitiny.ui.starter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import vn.chapp.nitiny.R;
import vn.chapp.nitiny.base.BaseActivity;
import vn.chapp.nitiny.ui.auth.AuthActivity;

public class StarterActivity extends BaseActivity implements StarterMvpView {

    @Inject
    StarterMvpPresenter<StarterMvpView> presenter;

    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, StarterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    protected void onBeforeConfigView() {

    }

    @Override
    protected int configView() {
        return R.layout.activity_starter;
    }

    @Override
    protected void init() {
        getActivityComponent().inject(this);
        setUnbinder(ButterKnife.bind(this));
        presenter.onAttach(this);

    }

    @OnClick(R.id.btnStart)
    public void onStartClick(View v) {
        startActivity(AuthActivity.newInstance(this));
    }
}
