## **PROGRAMACIÓN. UNIDAD 2**

*2.- Indica si los siguientes identificadores de variables en Java serían válidos. Justifica tu respuesta.*

1. double: **No es válido** porque double es una palabra reservada utilizada para crear variables del tipo primitivo double.
1. /horaactual: **No es válido** porque el identificador debe comenzar por una letra o los símbolos **\_** y **$**.
1. $hora: **Es válido** pero por convenio no se suele utilizar el símbolo $ para comenzar un identificador de variable.
1. MiHora: Es válido aunque lo normal es empezar el nombre de una variable en letra minúscula ya que las clases suelen comenzar en mayúscula.
1. \_hora: **Es válido** pero por convenio no se suele utilizar el símbolo \_ para comenzar un identificador de variable.
1. 5hora: **No es válido**, no puede comenzar por un número.
1. char: **No es válido** porque char es una palabra reservada para declarar variables tipo char.

<a name="yui_3_17_2_1_1636306423330_56"></a>*3.- Teniendo en cuenta que var1, var2 y var3 son variables de tipoboolean y están inicializadas a los siguientes valores: var1=true, var2=true y var3=false y que las variables X, Y y Z son variables enteras con valores: X=5, Y=-8 y Z=10, indica si las siguientes operaciones se evaluan a true o false.:*

1. **var1 || var2 && var3**

**TRUE**, en este caso con que uno de los dos bloques sea cierto devolverá TRUE, var1 cumple esa condición y por eso obtendremos TRUE.

2. **(var1 || var3) && (var2 && !var1)**

**FALSE**, para que sea cierta var1 o var3 deben ser TRUE y además var2 y la negación de var1 deben ser TRUE. Al negar var1 convertimos en FALSE dicho valor, por lo que ya no se cumplen las 2 condiciones.

3. **(var2 || !var1 || !var3) && var1**

**TRUE**, sólo necesitamos un valor TRUE en el primer bloque, y el segundo bloque (var1) es también TRUE, por lo que se cumple la condición.

4. **(X > 3 || Y > 3) && Z < -3**

**FALSE**, X>3 es cierto pero Z no es menor que -3.

5. **(X+Z == 15) && (Y != 2)**

**TRUE**, 5+10=15 (TRUE), Y=8 por lo que es distinto de 2 (TRUE).
