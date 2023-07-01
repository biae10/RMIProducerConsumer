import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry

fun main(){


    try {
        val buffer = Buffer()
        val registry: Registry = LocateRegistry.createRegistry(1010)
        registry.rebind("RemoteBuffer",buffer)
        println("O servidor foi iniciado!!!")

    }catch (e: InterruptedException){
        e.printStackTrace()
    }

}