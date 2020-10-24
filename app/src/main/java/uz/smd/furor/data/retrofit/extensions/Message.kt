package uz.smd.furor.data.retrofit.extensions

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.fragment.app.Fragment
import retrofit2.HttpException
import uz.smd.furor.MainActivity


fun Fragment.showMessage(message: MessageData) {
    var text: String = ""
    message.onMessage {
        text = it
    }.onResource {
        text = getString(it)
    }.onFailure {
        text = when (it) {
            is HttpException -> "Internetga ulanishda xatolik!"
            else -> "Aniqlanmagan xatolik. Iltimos qayta urinib ko'ring."
        }
    }
//    showDialog(text)
   showDialog(text)

}
fun Fragment.showDialog(text:String){
    val dialog = AlertDialog.Builder(context)
        .setTitle("Info!")
        .setMessage(text)
        .setPositiveButton("OK") { _, _ -> }
        .create()
    dialog.show()
}
fun Activity.showMessage(message: MessageData) {
    var text: String = ""
    message.onMessage {
        text = it
    }.onResource {
        text = getString(it)
    }.onFailure {
        text = when (it) {
            is HttpException -> "Internetga ulanishda xatolik!"
            else -> "Aniqlanmagan xatolik. Iltimos Internetga ulanib ko'ring."
        }
    }
//    showDialog(text)
    showDialog(text)

}
fun Activity.showDialog(text:String){
    val dialog = AlertDialog.Builder(this)
        .setTitle("Info!")
        .setMessage(text)
        .setPositiveButton("Try again") { _, _ ->
           startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        .setNegativeButton("Cancel"){ _,_ ->


        }
        .create()
    dialog.show()
}

fun saveData(it: String) {

//    startActivity(Intent(this, ContactActivity::class.java))
//    finish()
}