
## Gerar clientes

```java
  for (int i = 0; i < 3; i++) {
      int id = i + 1;
      Cliente cliente = new Cliente("cliente " + id, "cliente" + id + "@gmail.com", "123456789");
      cliente.setId(id);
      clientes.add(cliente);
  }
```
