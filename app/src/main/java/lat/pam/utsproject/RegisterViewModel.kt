package lat.pam.utsproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    fun registerUser(username: String, password: String) {
        viewModelScope.launch {

        }
    }
}
