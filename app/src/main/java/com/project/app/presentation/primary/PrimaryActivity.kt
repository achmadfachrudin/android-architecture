package com.project.app.presentation.primary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.project.app.R
import com.project.app.databinding.ActivityPrimaryBinding
import com.project.framework.core.BaseActivity
import com.project.framework.core.owner.ViewDataBindingOwner
import com.project.framework.core.owner.ViewModelOwner
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by achmad.fachrudin on 9-Jun-19
 */
class PrimaryActivity : BaseActivity(),
    PrimaryView,
    ViewModelOwner<PrimaryViewModel>,
    ViewDataBindingOwner<ActivityPrimaryBinding> {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, PrimaryActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getViewLayoutResId(): Int {
        return R.layout.activity_primary
    }

    override lateinit var binding: ActivityPrimaryBinding
    override val viewModel: PrimaryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()
    }

    private fun initUI() {
        title = getString(R.string.msg_primary_title)
    }

    private fun calculate() {
        // clear result
        viewModel.bTextResult.set(null)

        viewModel.bTextA.get().let {
            // set result
            viewModel.bTextResult.set(listPrimaryNumber(it!!.toInt()))
        }
    }

    /**
     * Method for create primary list
     * @param count Int
     * @return String
     */
    fun listPrimaryNumber(count: Int): String {
        val result = StringBuilder()
        var number = 2
        var primeCount = 0

        while (primeCount < count) {
            if (isPrimaryNumber(number)) {
                result.append("$number, ")
                primeCount++
            }
            number++
        }

        return result.toString().dropLast(2)
    }

    /**
     * Method for checking is primary number
     * @param number Int
     * @return Boolean
     */
    fun isPrimaryNumber(number: Int): Boolean {
        var result = true

        for (i in 2 until number) {
            if (number % i == 0) {
                result = false
                break
            }
        }

        return result
    }

    override var textWatcherA: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            binding.edtA.removeTextChangedListener(this)

            try {
                val originalString = s.toString()

                if (originalString.isNotEmpty()) {
                    if (originalString[0] == '0') {
                        viewModel.bTextA.set(null)
                    } else {
                        viewModel.isShowButton.set(true)
                    }
                } else {
                    viewModel.isShowButton.set(false)
                }
            } catch (e: Exception) {
                if (s.isNullOrEmpty()) {
                    viewModel.bTextA.set(null)
                }
            }

            binding.edtA.addTextChangedListener(this)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // ignore
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // ignore
        }
    }

    override fun onClickCalculate(view: View) {
        calculate()
    }
}