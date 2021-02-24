package com.khyzhun.kotlindelegates

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class RWFormatDelegate : ReadWriteProperty<Any?, String> {

	private var formattedString: String = ""

	override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
		formattedString = value.toLowerCase().capitalize()

		if (thisRef is Person && property.equals(formattedString).not()) {
			thisRef.updateCount++
		}
	}

	override fun getValue(thisRef: Any?, property: KProperty<*>): String {
		return formattedString
	}
}
