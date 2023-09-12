import di.PlatformSDK
import org.jetbrains.skiko.wasm.onWasmReady
import platform.PlatformConfiguration


fun main() {
    onWasmReady {
        BrowserViewportWindow("CMMTemplate") {
            PlatformSDK.init(PlatformConfiguration())
            Application(){

            }
        }
    }
}

