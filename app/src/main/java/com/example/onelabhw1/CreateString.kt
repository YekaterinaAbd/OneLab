package com.example.onelabhw1

class CustomStringBuilder {

    val result = StringBuilder()

    fun append(text: String) {
        result.append(text)
    }

    fun appendLn(text: String) {
        result.append("\n$text")
    }
}

fun <T> T.createString(f: CustomStringBuilder.() -> Unit): String {
    val builder = CustomStringBuilder()
    val className = this!!::class.java.simpleName
    builder.f()
    return (className + builder.result.toString())
}
