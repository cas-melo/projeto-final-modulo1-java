package contato;

import java.util.ArrayList;
import java.util.List;

public class Contato {


    public static int proximoId = 1;
    private int id;
    private String nome;
    private String sobrenome;
    private List<Telefone> telefones;


    public Contato(int proximoId, String nome, String sobrenome) {
        this.id = Contato.proximoId;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefones = new ArrayList<>();
    }

    public static int getProximoId() {
        return proximoId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }


    public void adicionarTelefone(Telefone telefone) {
        if (!telefones.contains(telefone)) {
            this.telefones.add(telefone);
        }
    }


    public void removerTelefone(Telefone telefone) {
        this.telefones.remove(telefone);
    }


    public String detalhesContato() {
        return "ID: " + id + "\nNome: " + nome + "\nSobrenome: " + sobrenome + "\nTelefones: " + telefones;
    }
}
