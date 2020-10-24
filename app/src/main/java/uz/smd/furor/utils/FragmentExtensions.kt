package uz.smd.furor.utils

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.putArguments(block: Bundle.() -> Unit): Fragment {
    val bundle = arguments ?: Bundle()
    block(bundle)
    arguments = bundle
    return this
}
fun Fragment.showToast(toast:String){
    Toast.makeText(requireContext(),toast, Toast.LENGTH_SHORT).show()
}