package com.project.app.feature.fibonacci.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.project.app.R
import com.project.app.databinding.ActivityFibonacciBinding
import com.project.framework.core.BaseActivity
import com.project.framework.core.owner.ViewDataBindingOwner
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by achmad.fachrudin on 11-Jun-19
 */
class FibonacciActivity : BaseActivity<FibonacciViewModel>(),
    FibonacciView,
    ViewDataBindingOwner<ActivityFibonacciBinding> {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, FibonacciActivity::class.java)
            context.startActivity(intent)
        }
    }

    override val layoutResourceId = R.layout.activity_fibonacci
    override lateinit var binding: ActivityFibonacciBinding
    override val viewModel: FibonacciViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()
    }

    private fun initUI() {
        title = getString(R.string.msg_fibonacci_title)
    }

    private fun calculate() {
        // clear result
        viewModel.bTextResult.set(null)

        val input = viewModel.bTextA.get()!!.toInt()

        // set result
//        viewModel.bTextResult.set(listFibonacciWithSequence().take(input).toList().toString())
        viewModel.bTextResult.set(listFibonacci(input))
    }

    /**
     * Method for create fibonacci list
     * @param count Int
     * @return String
     */
    fun listFibonacci(count: Int): String {
        val result = StringBuilder()
        var pass = 0
        var current = 1
        var fibonacci: Int

        result.append("$pass, $current, ")

        for (i in 0 until count - 2) {
            fibonacci = current + pass
            pass = current
            current = fibonacci

            result.append("$fibonacci, ")
        }

        return result.toString().dropLast(2)
    }

    /**
     * Method for generate fibonacci list
     * @return Int
     */
    private fun listFibonacciWithSequence(): Sequence<Int> {
        return generateSequence(
            Pair(0, 1),
            { Pair(it.second, it.first + it.second) }
        ).map { it.first }
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