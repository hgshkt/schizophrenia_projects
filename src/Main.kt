var field = arrayOf(arrayOf('_', '_', '_'),
                    arrayOf('_', '_', '_'),
                    arrayOf('_', '_', '_'))

var gameRun = true
var x = true

fun main() {
    print("""
            ${field[0][0]}|${field[0][1]}|${field[0][2]}
            ${field[1][0]}|${field[1][1]}|${field[1][2]}
            ${field[2][0]}|${field[2][1]}|${field[2][2]}
            
        """.trimIndent())

    while(gameRun) {
        var stringNum = readLine()
        val intNum = stringNum!!.toInt() - 1    // get number

        if (field[intNum/3][intNum%3] == '_' && x) {        //
            field[intNum/3][intNum%3] = 'X'                 // put X
            x = false                                       //
        }
        else if (field[intNum/3][intNum%3] == '_' && !x){   //
            field[intNum/3][intNum%3] = 'O'                 // put O
            x = true                                        //
        }

        if (field[0].all { it == 'X'} || field[0].all { it == 'O'} ||                               //
            field[1].all { it == 'X'} || field[1].all { it == 'O'} ||                               //
            field[2].all { it == 'X'} || field[2].all { it == 'O'} ||                               // check
            field[0][0] == field[1][0] && field[1][0] == field[2][0] && field[0][0] != '_' ||       // for
            field[0][1] == field[1][1] && field[1][1] == field[2][1] && field[0][1] != '_' ||       // someone
            field[0][2] == field[1][2] && field[1][2] == field[2][2] && field[0][2] != '_' ||       // victory
            field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[0][0] != '_' ||       // or
            field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[0][2] != '_' ||       // tie
            field.all { !it.contains('_')})                                                         //
            gameRun = false                                                                         //

        print("""
            -----
            ${field[0][0]}|${field[0][1]}|${field[0][2]}
            ${field[1][0]}|${field[1][1]}|${field[1][2]}            
            ${field[2][0]}|${field[2][1]}|${field[2][2]}            
          
        """.trimIndent())                                           // print field
    }
}