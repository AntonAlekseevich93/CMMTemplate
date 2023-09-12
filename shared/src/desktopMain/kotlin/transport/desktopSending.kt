package transport

import java.util.Calendar

actual fun getTimeNow(): String = Calendar.getInstance().time.toString()

actual val localHost: String = "0.0.0.0"

