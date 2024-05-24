import androidx.lifecycle.ViewModel

class BaseViewModel(private val mString: String) : ViewModel() {

    fun callFromVM() = mString

    override fun onCleared() {
        super.onCleared()
    }
}