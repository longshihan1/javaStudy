package class01

interface InputDevice {
    fun input(event: Any)
}

interface USBInputDevice : InputDevice

interface BLEInputDevice : InputDevice

class Computer {
    fun addUSBInputDevice(inputDevice: USBInputDevice) {
        println("add input usbdevice:$inputDevice")
    }

    fun addBLEInputDevice(inputDevice: BLEInputDevice) {
        println("add input bledevice:$inputDevice")
    }

    fun addInputDevice(inputDevice: InputDevice) {
        when (inputDevice) {
            is BLEInputDevice -> {
                addBLEInputDevice(inputDevice)
            }
            is USBInputDevice -> {
                addUSBInputDevice(inputDevice)
            }
            else ->{
                throw IllegalAccessException("输入设备类型不支持")
            }
        }
    }
}

