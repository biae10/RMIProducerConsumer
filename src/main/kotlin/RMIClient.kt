import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry

fun main(){

    try {
        val registry: Registry = LocateRegistry.getRegistry("localhost", 1010)
        val buffer: RemoteBuffer = registry.lookup("RemoteBuffer") as RemoteBuffer

        while (true){
            buffer.produce()
            buffer.consume()
        }

    }catch (e: InterruptedException){

        e.printStackTrace()
    }
}