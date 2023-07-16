# Manual de Uso

Por favor, caro rebelde, use este programa com sabedoria. Pois ele ainda está em construção e a procura de melhorias.

Por favor, leia este manual antes de começar a usar para evitar dificuldades e erros.

Sentimos muito pela falta de acessibilidade temporária para nossos RcD (Rebeldes com Deficiência).

## Instruções de uso:

### Cadastrar Rebelde:

Essa opção permite cadastrar um novo rebelde. (Todo cadastro novo é automaticamente salvo como Rebelde)

No novo cadastro você precisa inserir os seguintes dados:

- Nome (sem aspas. Ou seja se o nome for: D'agua; ele deverá ser escrito como: Dagua);
- Idade (apenas números);
- Gênero (sinta-se livre para escrever desde que siga a mesma instrução de nome e não possua espaços);
- Localização (local atual em que se encontra. Esse dado poderá ser alterado posteriormente).

### Remover Cadastro:

Aqui você pode remover um cadastro que foi feito incorretamente.

Para que a remoção seja liberada você deve primeiro fornecer um ID válido.

ID válido corresponde a um ID que possua um cadastro de alguém com o status de Rebelde.

Se o ID fornecido for válido será liberada a função para a remoção de outro ID (seja Rebelde ou Traidor).

Por favor, preste muita atenção, pois essa ação não poderá ser desfeita.

### Reportar Traidor:

Aqui você pode reportar alguém como Traidor.

É necessário ter um ID válido para poder reportar outro ID como traidor.

Se um ID receber 3 reportes ele terá seu status alterado de Rebelde para Traidor.

### Ver Relatório:

Aqui você pode ver a porcentagem de Rebeldes e Traidores cadastrados.

### Ver Cadastros:

Aqui você pode ver os seguintes dados (lista completa de todos os cadastros existentes):

- ID;
- Nome;
- Idade;
- Gênero;
- Localização;
- Status (Rebelde ou Traidor);
- Números de reportes recebidos.

### Ver inventário:

Aqui você pode ver o inventário de um ID específico.

### Adquirir créditos:

Quando um novo cadastro é feito é altamente recomendável que coloque o ID aqui para receber 500 créditos e liberar o uso da Base de Compras.

Cadastros com status Traidores não podem adquirir créditos.

Só é possível usar essa função 1 vez.

### Ver Base de Compras: 

Aqui você pode ver os itens disponíveis para comprar e seus preços.

### Comprar na Base de Compras:

Aqui você pode comprar itens.

Somente IDs válidos e que adquiriram créditos podem fazer compras.

É permitido apenas 1 item por compra.

### Alterar Localização:

Aqui você pode alterar sua localização atual.

Essa ação não pode ser desfeita, porém você pode realiza-la quantas vezes precisar.

### Menu Extra:

Esse menu possui algumas funções pedidas por ordens superiores, estão separadas por motivos de análise, porém podem ser incluídas no menu principal futuramente.

#### INNER-JOIN

Aqui você pode conferir todos os cadastros que possuem um inventário.

#### LEFT-JOIN

Aqui você pode conferir todos os cadastros. Com ou sem inventário.

Se o ID do inventário for igual a 0 é porque aquele cadastro não possui um inventário.

#### RIGHT-JOIN

Aqui você pode conferir todos os inventários. Com ou sem cadastros.

Se o ID constar como 0 e o nome como null é porque aquele inventário não possui um cadastro vinculado.

#### FULL-JOIN

Aqui você pode conferir a lista completa de cadastros (com ou sem inventário) e inventarios (com ou sem cadastro).

As regras para saber se um inventário possui um cadastro é a mesma do RIGHT-JOIN.

Cadastros com créditos e item em 0 são cadastros sem inventários.

Aqui é possível ver a quantidade de itens e créditos em cada inventário.

## Informações técnicas:

- Existem comentários nos códigos indicando o que cada pedaço faz;
- Alguns problemas surgiram durante a produção, também há comentários ao lado;
- Alguns nomes aleatórios foram adicionados por motivos de testes. São os com nomes estrangeiros e localizações cômicas.