package Empresa

fun main() {
    // get user input
    val option = getUserInput()
    // check if the type exists and get type
    val emp = getEmployee(option)
    val salary = emp?.calcTotalSalary()?: 0.0
    // get name
    val name = getEmployeeName(option)
    println("El salario del ${name.lowercase()} es de $$salary")
}

fun getUserInput(): Int {
    // read user input
    println("¿Que salario desea calcular? \n 1. Gerente \n 2. Operador 3. Contador: ")
    return readLine()!!.toInt()
}

fun getEmployee(option: Int): EmployeeSalary?{
    return when (option) {
        EmployeeType.GERENTE.empType ->  Manager()
        EmployeeType.OPERADOR.empType ->  Operator(true)
        EmployeeType.CONTADOR.empType ->   Account()
        else -> {
            println( "Has ingresado una opcion incorrecta" )
            return null
        }
    }
}


fun getEmployeeName (option: Int): String{
    return when (option){
        EmployeeType.GERENTE.empType ->  EmployeeType.GERENTE.name
        EmployeeType.OPERADOR.empType ->  EmployeeType.OPERADOR.name
        EmployeeType.CONTADOR.empType ->   EmployeeType.CONTADOR.name
        else -> ""
    }
}