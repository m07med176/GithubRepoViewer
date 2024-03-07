package tech.vodafone.githuprepoviewer.presentation.composable

import android.net.ParseException
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.google.gson.stream.MalformedJsonException
import okio.IOException
import org.json.JSONException
import tech.vodafone.githuprepoviewer.R
import tech.vodafone.githuprepoviewer.domain.utils.NetworkException
import java.lang.Exception

@Composable
fun handleExceptionToString(exception: Throwable):String {
    exception.printStackTrace()
    return when(exception){
        is NetworkException-> exception.message?:stringResource(id = R.string.error_happend)
        is MalformedJsonException-> stringResource(id = R.string.error_happend)
        is ParseException-> stringResource(id = R.string.error_happend)
        is JSONException-> stringResource(id = R.string.error_happend)
        is IOException-> stringResource(id = R.string.error_happend)
        else -> stringResource(id = R.string.error_happend)
    }
}