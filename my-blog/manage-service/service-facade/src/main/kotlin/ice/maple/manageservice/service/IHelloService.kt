package ice.maple.manageservice.service


interface IHelloService {
    fun hello(): String

    fun hello(text: String): String
}