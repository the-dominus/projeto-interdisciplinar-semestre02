
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
      Veiculo veiculo = new Veiculo(000 + id, (long) 0.0 + id, "Marca" + id, "Modelo" + id, "Cor" + id);
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
