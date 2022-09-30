fun sort(arr: Array<Int>) : Array<Int>{
    for(i in arr.indices){
        val key = arr[i]
        var j = i - 1

        while (j >= 0 && arr[j] > key){
            arr[j + 1] = arr[j]
            j -= 1
        }

        arr[j + 1] = key
    }
    return arr
}

fun main(){
    val data = arrayOf(1, 4, 3, 5, 6, 2)
    val result = sort(data)
    print(result.joinToString(" "))
}