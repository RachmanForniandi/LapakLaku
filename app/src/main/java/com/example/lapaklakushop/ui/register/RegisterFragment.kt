package com.example.lapaklakushop.ui.register

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.lapaklakushop.R
import com.example.lapaklakushop.ui.LoginActivity
import com.example.lapaklakushop.ui.register.model.RegisterResponse
import kotlinx.android.synthetic.main.register_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        // TODO: Use the ViewModel

        btnRegister.onClick {
            viewModel.register(txtRegisterName.text.toString(),
                txtRegisterEmail.text.toString(),
                txtRegisterPassword.text.toString(),
                txtRegisterPhone.text.toString())
        }

        attachObserve()
    }

    private fun attachObserve() {
        viewModel.isLoading.observe(this, Observer { it ->showProgress(it) })
        viewModel.apiError.observe(this, Observer { showError(it) })
        viewModel.responseRegister.observe(this, Observer { showResponse(it) })
        viewModel.isEmpty.observe(this, Observer { showIsEmpty(it) })
    }

    private fun showIsEmpty(it: Boolean) {
        if (it)toast("Form tidak boleh kosong.Mohon Diisi.")
    }

    private fun showResponse(it: RegisterResponse?) {


        if (it?.status ==200)activity?.startActivity<LoginActivity>()
        else activity?.toast(it?.message ?:"")

    }

    private fun showError(it: Throwable?) {
        activity?.toast(it?.message ?:"")
    }

    private fun showProgress(it: Boolean?) {
        if (it != false){
            progressSign.visibility = View.VISIBLE
        }else{
            progressSign.visibility = View.GONE
        }
    }

}
