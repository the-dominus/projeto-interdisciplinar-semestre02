
## Gerar clientes

```java
  for (int i = 0; i < 3; i++) {
      int id = i + 1;
      Cliente cliente = new Cliente("cliente " + id, "cliente" + id + "@gmail.com", "123456789");
      cliente.setId(id);
      clientes.add(cliente);
  }
```

## Gerar veículos

```java
  for (int i = 0; i < 3; i++) {
      int id = i + 1;
      Veiculo veiculo = new Veiculo(000 + id, (double) 0.0 + id, "Marca" + id, "Modelo" + id, "Cor" + id);
      veiculo.setId(id);
      veiculos.add(veiculo);
  }
```

## Gerar pedidos

```java
  for (int i = 0; i < 2; i++) {
      int id = i + 1;
      ArrayList<Veiculo> veiculosTest = new ArrayList<Veiculo>();
      veiculosTest.add(veiculos.get(0));
      veiculosTest.add(veiculos.get(1));
      Pedido pedido = new Pedido(clientes.get(i), veiculosTest);
      pedido.setId(id);
      pedidos.add(pedido);
  }
```

# Script para o vídeo

## Explicação do projeto
  - Qual é o problema...
  - Solução...
  - UML (Herança, abstração...)...

## Implementação
### Classes
  - Usuário
      - classe abstrata
      - apenas um construtor
      - get e set
      - um método abstrato
      - um método concreto e sobrescrita
  - Cliente
      - subclasse (existe uma superclasse)
      - apenas um construtor
      - get e set
      - implementação do método abstrato
      - um método concreto e sobrescrita e usar o método da superclasse
  - Veículo
      - dois construtores
      - get e set
      - um método concreto com sobrescrita
      - dois método concretos
  - Pedido
      - apenas um construtor
      - get e set
      - com o diferencial do ArrayList (porque não usar o vetor)
      - um método concreto com sobrescrita
      - dois método concretos
      - falar das diferenças de método com retorno, void que mostra em tela e void que só faz

### App
  - Reaproveitamento de código com métodos estáticos
  - Sistema de menu (replicação)
  - Tratamento de erro
  - Mostrar todos os sistemas de cadastro
  - Mostrar todos os sistemas de consulta
  - Mostrar todos os sistemas de alteração
  - Mostrar todos os sistemas de exclusão

### Mostrar o app rodando
  - Cadastro de 2 clientes
  - Cadastro de 2 veículos
  - Cadastro de 1 ou 2 pedidos
  - Fazer consultas
  - Alterar cadastros
  - Exclusão...
