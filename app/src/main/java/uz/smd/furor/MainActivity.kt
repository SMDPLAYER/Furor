package uz.smd.furor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import uz.smd.furor.app.App
import uz.smd.furor.data.local.AppDatabase
import uz.smd.furor.data.local.LocalStorage
import uz.smd.furor.data.retrofit.OverviewViewModel
import uz.smd.furor.data.retrofit.extensions.showDialog
import uz.smd.furor.data.retrofit.extensions.showMessage
import uz.smd.furor.ui.MainFragament
import uz.smd.furor.utils.gone
import uz.smd.furor.utils.runOnWorkerThread
import uz.smd.furor.utils.visible

class MainActivity : AppCompatActivity() {

        val appDataBase = AppDatabase.getDatabase(App.instance)

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProviders.of(this).get(OverviewViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        noInternet.gone()
        if ( LocalStorage.instance.isFirst==12){
            try {
                startFragment()
            }catch (e:IndexOutOfBoundsException){
                loadFromServer()
            }catch (exception : Exception  ) {
                // Output unexpected Exceptions/Errors.
                loadFromServer()
            }
        }
        else
loadFromServer()
        noInternet.setOnClickListener {
            loadFromServer()
        }
    }

     fun loadFromServer() {
        loader_progress.visible()
         viewModel.tasks  {
            loader_progress.gone()

            it.onData {
                if (it.rows.isNullOrEmpty()){
                    showDialog("Empty Data")
                }else
                    runOnWorkerThread {
                        appDataBase.taskDao().clearDB()
                        appDataBase.taskDao().insertAll(it.rows)
                        runOnUiThread {  startFragment() }
                        LocalStorage.instance.isFirst=12
                    }

            }.onMessageData{
                showMessage(it)
                if ( LocalStorage.instance.isFirst==12)
                runOnUiThread {  startFragment() }
            else
                    noInternet.visible()}
        }
    }

    private fun startFragment() {
        noInternet.gone()
        val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.layoutFragment, MainFragament().apply {
                this.loadView()
            }).commit ()


    }
}