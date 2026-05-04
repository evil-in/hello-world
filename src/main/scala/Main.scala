import UnitedKingdom.*

@main def hello(): Unit =
  println("Hello world!")
  println(msg)
  println(sum(2,2))
  println(lightSwitch(true))
  println(lightSwitch(false))
  println(product(4,6))
  println(greeting())
  println(greeting("Preethi"))
  println(partyAtHome(10))
  println(partyAtHome(20))
  println(weather(false))
  println(greeting_friend("Preethi"))
  println(greeting_friend("Ada"))
  println(competition(1))
  println(anne.name)
  println(greeting_person(preethi))
  println(population(india))
  if country == Scotland then println("We're in Scotland") else println("we're in UK")
  println(whereAmI(Scotland))


def msg = "I was compiled by Scala 3. :)"

// functions
def sum(n1:Int, n2: Int): Int = n1 + n2

def lightSwitch(switchOn: Boolean = false): String = if switchOn then "light on!" else "light off"

def product(n1:Int, n2: Int):Int = n1 * n2

def greeting(name: String = "Everyone"): String = s"Hi $name"

def partyAtHome(guests: Int): Boolean = if guests <=15 then true else false

def weather(sunny: Boolean): String = sunny match
  case true => "yay where are my sunglasses"
  case false => "oh where is my raincoat?"

def greeting_friend(friend_name: String): String = friend_name match {
  case "Ada" => "Hi Ada"
  case "Charles" => "Hi Charles"
  case _ => "Hi, what's your name?"
}

def competition(result: Int): String = result match
  case 1 => "gold"
  case 2 => "silver"
  case 3 => "bronze"
  case _ => "well done!"

case class Person(name: String, age: Int)

val anne = Person("anne", 27)

def greeting_person(person: Person): String = s" Hi ${person.name}"

val preethi = Person("preethi", 26)

// case classes
case class Country(country_name: String, country_population: Int)

def population(country: Country): Int = country.country_population

val india = Country("India", 600000)
val country = England

// enums
enum UnitedKingdom:
  case England, NorthernIreland, Scotland, Wales

def whereAmI(country: UnitedKingdom): String = country match
  case England => "UK"
  case NorthernIreland => "Ireland"
  case Scotland => "Scotland"
  case Wales => "Wales"

