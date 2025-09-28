
 class Coffe(private val extra: ArrayList<Extra>,private val name: String){
    private val coffeCost = 5

    fun cost()  {
       var totalCost = 0
     extra.forEach {totalCost += it.cost }

       println(" ${totalCost +coffeCost}")


    }
     fun prepare(){
       println("Preparing Coffee ($name)")
       for (ex in extra) {
           ex.execute()
       }
    }


    internal class Builder{
         private val extras = ArrayList<Extra>()
         private var name = "Coffe"
         fun addExtra(extra: Extra) : Builder {
             extras.add(extra)
             return this
         }
        fun name (name:String) : Builder {

            this.name = name
             return this
         }

         fun build() : Coffe {
             return Coffe(extras,name)
         }
     }
}

 data class Extra(val cost :Int,val prepare:String){

     fun execute(){
         println(prepare)
     }
 }


fun main() {
    val mcoha = Coffe.Builder()
        .addExtra(Extra(2,"Adding Milk"))
        .addExtra(Extra(1,"Adding Sugar"))
        .addExtra(Extra(3,"Adding Chocolate"))
        .name("Mocha")
        .build()


    mcoha.cost()
    mcoha.prepare()

}




