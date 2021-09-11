// simple function to show different match types in when
fun whatToDo(dayOfWeek: Any): String = when (dayOfWeek) {
  "Saturday", "Sunday" -> "Relax" // comma separated list
  in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> "Work hard" // list check
  in 2..4 -> "Work hard" // range check
  "Friday" -> "Party" // simple match
  is String -> "What?" // type check
  else -> "No clue" // the default if no match
}

// when with local scope variable
fun systemInfo(): String = when (val coreCount = Runtime.getRuntime().availableProcessors()) {
  1 -> "1 core"
  in 2..4 -> "desktop with $coreCount cores"
  else -> "server with $coreCount cores"
}
