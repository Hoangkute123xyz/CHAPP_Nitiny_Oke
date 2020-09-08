package vn.chapp.nitiny.ui.auth;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import vn.chapp.nitiny.R;
import vn.chapp.nitiny.base.BaseFragment;
import vn.chapp.nitiny.di.component.ActivityComponent;

public class ChangePasswordFragment extends BaseFragment implements ChangePasswordFrMvpView {

    public static final String TAG = ChangePasswordFragment.class.getCanonicalName();

    @Inject
    ChangePasswordFrPresenter<ChangePasswordFrMvpView> presenter;
    @BindView(R.id.edtOldPassword)
    EditText edtOldPassword;
    @BindView(R.id.edtNewPassword)
    EditText edtNewPassword;
    @BindView(R.id.edtRePassword)
    EditText edtRePassword;


    public static ChangePasswordFragment newInstance() {
        ChangePasswordFragment fragment = new ChangePasswordFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int configView() {
        return R.layout.fragment_change_password;
    }

    @Override
    protected void init(View v) {

    }

    @Override
    protected void initCreatedView(View v) {
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnbinder(ButterKnife.bind(this, v));
            presenter.onAttach(this);

        }

    }

    @Override
    public void didChangePassword() {
        getActivity().finish();
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        presenter.doChangePassword(edtOldPassword.getText().toString(),edtNewPassword.getText().toString(),edtRePassword.getText().toString());
    }
}
