package empresa
/************* Constants **************/
const val BONUS_HOURS = 10

/************* Abstractions **************/
abstract class Employee: EmployeeSalary{
    abstract val type: EmployeeType
    internal abstract val hourCost: Double
    internal abstract val workedHours: Double
    abstract val hasBonus: Boolean
    abstract val salary: Double
}

interface EmployeeSalary {
    fun calcTotalSalary(): Double
}

/************* Classes **************/
class Manager(override val hasBonus: Boolean = false): Employee() {
    override val type = EmployeeType.GERENTE
    override val hourCost = EmployeeHourCost.GERENTE.cost
    override val workedHours: Double = EmployeeMonthlyHours.GERENTE.hours
    override val salary: Double
        get() = hourCost * workedHours

    override fun calcTotalSalary():Double  {
        return salary + calcBonus(hourCost, hasBonus)
    }
}

class Operator(override val hasBonus: Boolean = false): Employee() {
    override val type: EmployeeType = EmployeeType.OPERADOR
    override val hourCost = EmployeeHourCost.OPERADOR.cost
    override val workedHours: Double = EmployeeMonthlyHours.OPERADOR.hours
    override val salary: Double
        get() = hourCost * workedHours

    override fun calcTotalSalary():Double  {
        return salary + calcBonus(hourCost, hasBonus)
    }
}

class Account(override val hasBonus: Boolean = false): Employee() {
    override val type: EmployeeType = EmployeeType.CONTADOR
    override val hourCost = EmployeeHourCost.CONTADOR.cost
    override val workedHours: Double = EmployeeMonthlyHours.CONTADOR.hours
    override val salary: Double
        get() = hourCost * workedHours

    override fun calcTotalSalary():Double  {
        return salary + calcBonus(hourCost, hasBonus)
    }
}

/************* Enums **************/
enum class EmployeeType(val empType: Int){
    GERENTE(1), OPERADOR(2), CONTADOR(3)
}

internal enum class EmployeeHourCost(val cost: Double) {
    GERENTE(200.00), OPERADOR(10.00), CONTADOR(50.00)
}

internal enum class EmployeeMonthlyHours(val hours: Double){
    GERENTE(200.00), OPERADOR(230.00), CONTADOR(200.00)
}

/************* functions **************/
fun calcBonus(salary: Double, hasBonus: Boolean): Double {
    return when {
        hasBonus -> salary * BONUS_HOURS
        else -> 0.0
    }
}