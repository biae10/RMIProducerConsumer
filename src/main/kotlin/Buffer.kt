import java.rmi.RemoteException
import java.rmi.server.UnicastRemoteObject
import java.util.*


class Buffer : UnicastRemoteObject(), RemoteBuffer {

    val numeros: MutableList<Int> = mutableListOf(5)
    var disponivel: Boolean = true
    var limiteDeProdutos: Int = 0


    @Synchronized
    @Throws(RemoteException::class)
    override fun produce() {
        val random = Random()
        limiteDeProdutos = random.nextInt(1,10)
        println("-----------------------------------------")
        while (disponivel){
            try {
                val numero = random.nextInt(1, 101)
                println("Produzindo o número: $numero")
                numeros.add(numero)
                Thread.sleep(300)
                if (numeros.size > limiteDeProdutos)
                    break
            }catch (e: InterruptedException){
                e.printStackTrace()
            }
        }
        disponivel = false
    }

    @Synchronized
    @Throws(RemoteException::class)
    override fun consume() {
        println("-----------------------------------------")
        while (!disponivel){
            try{
                if (numeros.isEmpty()){
                    println("A lista de produtos esvaziou!")
                    break
                }
                println("Consumindo o núemro: ${numeros.first()}")
                numeros.removeFirst()
                Thread.sleep(300)
            }catch (e: InterruptedException){
                e.printStackTrace()
            }
        }
        disponivel = true

    }


}