import Example.test_sol
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
  println(middleName.getOrElse("").length) // to get the value out of a option and get its length
  println(upper_middle_name)
  println(Example.mulan.name)
  println(Example.mulan.rating)
  println(Example.mulan.rating.map(rating => rating.googleRating))
  println(Example.mulan.rating.map(rating => rating.googleRating).flatten)
  println(Example.mulan.rating.flatMap(rating => rating.googleRating))
  println(test_sol.map(n => n*2))
  println(numbers.map(n => n * 2))
  println(names.map(name => name.toUpperCase))
  println(numbers.map(ns => List(ns, ns*2)).flatten)
  println(numbers.flatMap(ns => List(ns, ns*2)))
  println(list_eg.head)
  println(list_eg.tail)
  println(list_eg.distinct)
  println(list_eg.take(3))
  println(list_eg.length)
  println(list_eg.map(n => n * n))
  println(list_eg.flatMap(n => List.fill(3)(n)))
  println(nearby_trips(destination_list))

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

// Options --> can have 2 possible values None/ Some
//val middleName: Option[String] = None

val middleName: Option[String] = Some("Jasmine")


// map function
val upper_middle_name = middleName.map(word => word.toUpperCase)

// flatmap
object Example {
  case class Rating(googleRating: Option[Int], netflixRating: Option[Int])

  case class Film(name: String, rating: Option[Rating])

  val mulan = Film("Mulan", Some(Rating(Some(5), Some(4))))

  // for comprehensions
  val avg_rating = for {
    rating <- mulan.rating
    googleRating <- rating.googleRating
    netflixRating <- rating.netflixRating
    avg_rating = (googleRating + netflixRating)/2
  } yield avg_rating

  val test_sol: Option[Int] = Some(5)

//  test_sol.map(n => n*2)

  // challenge: case class
  case class TicketPrice(standardTicketPrice: Int, firstClassTicketPrice: Option[Int])

  def getFirstClassTicketPrice(ticketPrice: Option[TicketPrice]): Option[Int] =
    ticketPrice.flatMap(_.firstClassTicketPrice)
}

val numbers = List(1,2,3,4,5)
val names = List("Moana", "Jasmine")

val list_eg: List[Int] = List(1,1,2,2,3,3,4)

case class Destination(city: String, journeyTime: Int)

val destination_list = List(
    Destination("Malaysia", 30),
    Destination("Singapore", 50),
    Destination("Canada", 80),
    Destination("UK", 70),
    Destination("Ireland", 40),
    Destination("Australia", 35)
  )

def nearby_trips(destinations: List[Destination]): List[String] =
  for
    destination <- destinations
    if destination.journeyTime < 60
  yield destination.city
end nearby_trips


