import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

fun hideKeyboard(activity: Activity){
    val inputMethodManager  = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val currentFocusVIew = activity.currentFocus
    currentFocusVIew?.let {
        inputMethodManager.hideSoftInputFromWindow(
            currentFocusVIew.windowToken,InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}