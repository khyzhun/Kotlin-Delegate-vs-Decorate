package com.khyzhun.kotlindelegates

class Person {
	var firstName: String by RWFormatDelegate()
	var lastName: String by RWFormatDelegate()
	var updateCount = 0
}