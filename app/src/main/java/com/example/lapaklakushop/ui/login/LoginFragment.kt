package com.example.lapaklakushop.ui.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.lapaklakushop.MainActivity
import com.example.lapaklakushop.R
import com.example.lapaklakushop.RegisterActivity
import com.example.lapaklakushop.ui.LoginActivity
import com.example.lapaklakushop.ui.login.model.LoginResponse
import com.example.lapaklakushop.ui.register.RegisterFragment
import com.example.lapaklakushop.ui.register.model.RegisterResponse
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.register_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel

        btnLogin.onClick {
            viewModel.login(txtLoginEmail.text.toString(),
                txtLoginPassword.text.toString())
        }

        signInLinkregister.onClick {
            activity?.startActivity<RegisterActivity>()
        }

        attachObserveLogin()
    }

    private fun attachObserveLogin() {
        viewModel.isLoading.observe(this, Observer { it ->showProgress(it)
        })

        viewModel.apiError.observe(this, Observer { showError(it) })

        viewModel.responseLogin.observe(this, Observer { showResponse(it) })
        viewModel.isEmpty.observe(this, Observer { showIsEmpty(it) })
    }

    private fun showIsEmpty(it: Boolean) {
        if (it)toast("Email/Password tidak boleh kosong")
    }


    private fun showProgress(it: Boolean?) {
        if (it != false){
            progressBarLogin.visibility = View.VISIBLE
        }else{
            progressBarLogin.visibility = View.GONE
        }
    }

    private fun showResponse(it: LoginResponse?) {
        if (it?.status ==200)activity?.startActivity<MainActivity>()
        else activity?.toast(it?.message ?:"")
    }

    private fun showError(it: Throwable?) {
        activity?.toast(it?.message ?:"")
    }

}
