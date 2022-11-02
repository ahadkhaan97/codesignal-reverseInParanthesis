import java.util.*

fun main() {
    print(solution("foo(bar(baz))blim"))
}


@Suppress("NAME_SHADOWING")
fun solution(inputString: String): String {
    var inputString = inputString
    val stack = Stack<Int>()
    for (i in inputString.indices) {
        if (inputString[i] == '(')
            stack.push(i)
        else if (inputString[i] == ')') {
            val subString = inputString.substring(stack.peek() + 1, i)
            inputString = inputString.replace(subString, subString.reversed())
            stack.pop()
        }
    }
    inputString = inputString.replace("(", "")
    inputString = inputString.replace(")", "")
    return inputString
}