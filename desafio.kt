// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, var duracao: Int, val nivel: Nivel, val xp: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    var formacaoXP: Int = 0
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) = inscritos.add(usuario)

    fun calculaXP(){
        for (c in conteudos){
            formacaoXP += c.xp
        }
    }

}

fun main() {
    val usuario0 = Usuario("Douglas C. Santos")
    val usuario1 = Usuario("José Escamado")
    val usuario2 = Usuario("Cristo Redentor")

    val conteudos = mutableListOf(
        ConteudoEducacional("Kotlin Básico", 30,Nivel.BASICO,90),
        ConteudoEducacional("Kotlin Intermediário", 60,Nivel.INTERMEDIARIO,120),
        ConteudoEducacional("Kotlin Avançado", 90,Nivel.AVANCADO,140),
    )

    val formacao = Formacao("Formação Kotlin", conteudos, Nivel.AVANCADO)

    //FAZENDO AS MATRICULAS
    formacao.matricular(usuario0)
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    //CALCULANDO A XP DA FORMAÇÃO
    formacao.calculaXP()

    println(formacao.inscritos)
    println(formacao.conteudos)
    println(formacao.formacaoXP)
}
