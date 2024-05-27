package utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import org.koin.compose.currentKoinScope
import kotlin.math.abs

@Composable
inline fun <reified T : ViewModel> koinInjectViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}

fun String.toFormattedDate(): String {
    val days = Clock.System.todayIn(TimeZone.currentSystemDefault()).daysUntil(
        Instant.parse(this).toLocalDateTime(TimeZone.currentSystemDefault()).date
    )
    return when {
        abs(days) > 1 -> "${abs(days)} days ago"
        abs(days) == 1 -> "Yesterday"
        else -> "Today"
    }
}
