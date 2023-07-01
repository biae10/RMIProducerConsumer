import java.rmi.Remote
import java.rmi.RemoteException

interface RemoteBuffer: Remote {

    @Throws(RemoteException::class)
    fun produce()

    @Throws(RemoteException::class)
    fun consume()

}