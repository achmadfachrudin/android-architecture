package com.project.app.feature.multiplication.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.project.app.R
import com.project.app.databinding.ActivityMultiplicationBinding
import com.project.framework.core.BaseActivity
import com.project.framework.core.owner.ViewDataBindingOwner
import com.project.framework.core.owner.ViewModelOwner
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by achmad.fachrudin on 7-Jun-19
 */
class MultiplicationActivity : BaseActivity(),
    MultiplicationView,
    ViewModelOwner<MultiplicationViewModel>,
    ViewDataBindingOwner<ActivityMultiplicationBinding> {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, MultiplicationActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getViewLayoutResId(): Int {
        return R.layout.activity_multiplication
    }

    override lateinit var binding: ActivityMultiplicationBinding
    override val viewModel: MultiplicationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()
    }

    private fun initUI() {
        title = getString(R.string.msg_multiplication_title)
    }

    private fun calculate() {
        // clear result
        viewModel.bTextResult.set(null)

        // set result
        viewModel.bTextResult.set(
            resultMultiplication(
                viewModel.valueA,
                viewModel.valueB
            ).toString()
        )
    }

    /**
     * Method for calculate multiplication
     * @param valueA Int
     * @param valueB Int
     * @return Int
     */
    fun resultMultiplication(valueA: Int, valueB: Int): Int {
        return valueA * valueB
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
                        viewModel.valueA = originalString.toInt()
                        viewModel.isShowButton.set(viewModel.bTextB.get()?.isNotEmpty())
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

    override var textWatcherB: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            binding.edtB.removeTextChangedListener(this)

            try {
                val originalString = s.toString()

                if (originalString.isNotEmpty()) {
                    if (originalString[0] == '0') {
                        viewModel.bTextB.set(null)
                    } else {
                        viewModel.valueB = originalString.toInt()
                        viewModel.isShowButton.set(viewModel.bTextA.get()?.isNotEmpty())
                    }
                } else {
                    viewModel.isShowButton.set(false)
                }
            } catch (e: Exception) {
                if (s.isNullOrEmpty()) {
                    viewModel.bTextB.set(null)
                }
            }

            binding.edtB.addTextChangedListener(this)
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