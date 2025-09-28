open class Coffee {
    open fun cost(): Int = 5
    open fun prepare() {
        println("Preparing Coffee")
    }
}

class Milk(private val coffee: Coffee) : Coffee() {
    override fun cost(): Int = coffee.cost() + 2
    override fun prepare() {
        coffee.prepare()
        println("Adding Milk")
    }
}

class Sugar(private val coffee: Coffee) : Coffee() {
    override fun cost(): Int = coffee.cost() + 1
    override fun prepare() {
        coffee.prepare()
        println("Adding Sugar")
    }
}

class Chocolate(private val coffee: Coffee) : Coffee() {
    override fun cost(): Int = coffee.cost() + 3
    override fun prepare() {
        coffee.prepare()
        println("Adding Chocolate")
    }
}

fun main() {
    // Example: Mocha (Coffee with Milk, Sugar, Chocolate)
    val mocha = Chocolate(Sugar(Milk(Coffee())))
    println("Total cost: ${mocha.cost()}")
    mocha.prepare()
}
