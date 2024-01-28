package contato;

public class Telefone {

    private static Long id;
    private String ddd;
    private Long numero;


    public Telefone(Long id, String ddd, Long numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public static Long getId() {
        return id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }


    @Override
    public String toString() {
        return "ID: " + id + "\nDDD: " + ddd + "\nNúmero: " + numero;
    }
}
