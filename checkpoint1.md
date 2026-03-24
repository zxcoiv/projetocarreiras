# checkpoint1.md
Esse projeto é a implementação da navegação entre múltiplas telas em um aplicativo Android utilizando Jetpack Compose e Navigation Compose. 

## Objetivo da Avaliação
Essa avaliação tem como objetivo avaliar a capacidade do aluno de evoluir um projeto já iniciado, demonstrando como e por que a solução funciona.

## Explicação dos Commits
### `cc0ed74` - colocado passagem de parâmetros para tela de perfil
#### `MainActivity.kt`
Inserimos um parâmetro obrigatório, `nome`, para a tela de perfil.
Quando você navega para essa tela, o Compose armazena os dados em um "pacote".
Finalmente, pegamos o `nome` e enviamos para a função `PerfilScreen()`, quando usamos `!!` o compilador entende que esse nome _não_ é nulo. 

#### `MenuScreen.kt`
Quando o usuário clica no botão, o `navController.navigate("perfil/Fulano de Tal")` é executado. Ele navega a rota do perfil e pega o resto como um dado.

#### `PerfilScreen.kt`
O argumento é extraído e exibido como texto, ficando "PERFIL - Fulano de Tal".

### `a34362b` - colocado passagem de parâmetros opcionais na tela de pedidos
#### `MainActivity.kt`
Definimos um parâmetro opcional para a tela de pedidos, ficou algo parecido com uma URL do Google. `pedidos?cliente={cliente}`, o `?` indica que tudo o que vem depois dele é um parâmetro de consulta, ele entende que se quisermos apenas navegar para 'pedidos' o Compose não vai dar erro.

#### `PedidosScreen.kt`
Colocamos `String?` para sinalizar que a tela de pedidos pode receber `null`.
E exibimos a variável utilizando o `$`, ficando "PEDIDOS - Cliente Genérico" se não colocarmos nenhum dado na rota.

### `521eee7` - mockando dado ao parâmetro opcional na tela de pedidos
#### `MenuScreen.kt`
Simplesmente estamos simulando um caso para ver se a rota aceita um valor personalizado, no caso, "Cliente XPTO".

### `9f690e7` - adição de múltiplos parâmetros
#### `MainScreen.kt`
Implementamos a passagem de múltiplos parâmetros _obrigatórios_.
Como explicado anteriormente, utilizamos o `!!` para dizer que esse valor não é nulo.
Também definimos a tipagem de cada dado, pois por padrão tudo na URL é uma String. Quando definimos uma tipagem o Compose converte a String em um número real para usarmos.

#### `MenuScreen.kt`
Adicionamos uma idade no `navController.navigate("perfil/Fulano de Tal/27")`.

#### `PerfilScreen.kt`
Colocamos a variável no perfil, podendo ser extraída e exibida como "Perfil - Fulano de Tal tem 27 anos".
