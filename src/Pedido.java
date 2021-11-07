import java.util.ArrayList;

public class Pedido {
  private int id;
  private long totalPedido;
  private Cliente cliente;
  private ArrayList<Veiculo> veiculos;
  private String formaDePagamento;
  private boolean pedidoFinalizado = false;


  public Pedido(Cliente cliente, ArrayList<Veiculo> veiculos) {
    this.cliente = cliente;
    this.veiculos = veiculos;
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public long getTotalPedido() {
    return totalPedido;
  }
  
  public void setTotalPedido(long totalPedido) {
    this.totalPedido = totalPedido;
  }
  
  public String getFormaDePagamento() {
    return formaDePagamento;
  }

  public void setFormaDePagamento(String formaDePagamento) {
    this.formaDePagamento = formaDePagamento;
  }
  
  public ArrayList<Veiculo> getVeiculos() {
    return veiculos;
  }
  
  public void setVeiculos(ArrayList<Veiculo> veiculos) {
    this.veiculos = veiculos;
  }
  
  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public boolean isPedidoFinalizado() {
    return pedidoFinalizado;
  }
  
  public void setPedidoFinalizado(boolean pedidoFinalizado) {
    this.pedidoFinalizado = pedidoFinalizado;
  }

  @Override
  public String toString() {
    return "Pedido [cliente=" + cliente + ", formaDePagamento=" + formaDePagamento + ", id=" + id + ", totalPedido="
    + totalPedido + ", veiculos=" + veiculos + "]";
  }
  
  public void calcularTotalPedido() {
    for (Veiculo veiculo : veiculos) {
      totalPedido += veiculo.getPreco();
    }
    
  }
  
}
