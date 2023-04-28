import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val calculadora = Calculadora()

    println("Digite o primeiro número:")
    val numero1 = scanner.nextDouble()
    calculadora.definirNumero1(numero1)

    println("Digite o segundo número:")
    val numero2 = scanner.nextDouble()
    calculadora.definirNumero2(numero2)

    println("Digite a operação (+, -, *, /):")
    val operacao = scanner.next()
    calculadora.definirOperacao(operacao)

    val resultado = calculadora.calcularResultado()

    println("O resultado é: $resultado")
}

class Calculadora {
    private var numero1: Double = 0.0
    private var numero2: Double = 0.0
    private lateinit var operacao: Operacao

    fun definirNumero1(numero: Double) {
        this.numero1 = numero
    }

    fun definirNumero2(numero: Double) {
        this.numero2 = numero
    }

    fun definirOperacao(operacao: String) {
        this.operacao = when (operacao) {
            "+" -> OperacaoSoma()
            "-" -> OperacaoSubtracao()
            "*" -> OperacaoMultiplicacao()
            "/" -> OperacaoDivisao()
            else -> throw IllegalArgumentException("Operação inválida: $operacao")
        }
    }

    fun calcularResultado(): Double {
        return operacao.executar(numero1, numero2)
    }
}

interface Operacao {
    fun executar(numero1: Double, numero2: Double): Double
}

class OperacaoSoma : Operacao {
    override fun executar(numero1: Double, numero2: Double): Double {
        return numero1 + numero2
    }
}

class OperacaoSubtracao : Operacao {
    override fun executar(numero1: Double, numero2: Double): Double {
        return numero1 - numero2
    }
}

class OperacaoMultiplicacao : Operacao {
    override fun executar(numero1: Double, numero2: Double): Double {
        return numero1 * numero2
    }
}

class OperacaoDivisao : Operacao {
    override fun executar(numero1: Double, numero2: Double): Double {
        if (numero2 == 0.0) {
            throw IllegalArgumentException("Não é possível dividir por zero")
        }
        return numero1 / numero2
    }
}