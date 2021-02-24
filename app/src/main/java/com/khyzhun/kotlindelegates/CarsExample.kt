package com.khyzhun.kotlindelegates

enum class Direction {
	LEFT, RIGHT
}

interface Car {
	fun move()
	fun stop()
	fun turn(direction: Direction)
}

class DreamCar : Car {
	var isMoving = false
		private set(value) {
			field = value
			println("is moving = $field")
		}

	override fun move() { isMoving = true }
	override fun stop() { isMoving = false }
	override fun turn(direction: Direction) = if (direction == Direction.LEFT) turnLeft() else turnRight()

	private fun turnLeft() = println("turned left")
	private fun turnRight() = println("turned right")
}

class SubaruCar : Car {
	/**
	 * This is the Decorator
	 *
	 * We decorate all functions and call its interface realization.
	 * This is okay, it's working and everything is fine.
	 */
	private val car = DreamCar()
	override fun move() = car.move()
	override fun stop() = car.stop()
	override fun turn(direction: Direction) {
		when (car.isMoving) {
			true -> car.turn(direction)
			false -> println("Subaru | car is stopped")
		}
	}
}

class ToyotaCar(private val car: DreamCar = DreamCar()) : Car by car {
	/**
	 * This is Delegation.
	 *
	 * We don't override functions 'move' and 'stop' if we are satisfied with the car's realization.
	 * -- this is called delegation.
	 * We delegate this realization to the original file 'DreamCar'.
	 *
	 * Otherwise, we have to override a needed method and do whatever we want.
	 * Like with the 'turn' method.
	 */
	override fun turn(direction: Direction) {
		when (car.isMoving) {
			true -> car.turn(direction)
			false -> println("Toyota | car is stopped")
		}
	}
}

fun main() {
	val car = DreamCar()
	car.move()
	car.stop()
	car.turn(Direction.LEFT)

	println()

	val subaru = SubaruCar()
	subaru.move()
	subaru.stop()
	subaru.turn(Direction.LEFT)

	println()

	val toyota = ToyotaCar()
	toyota.move()
	toyota.stop()
	toyota.turn(Direction.LEFT)
}
