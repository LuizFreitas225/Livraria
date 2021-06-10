package model;




import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;






public class Livro implements Cloneable{

	Integer id;
	@NotEmpty(message = "O autor deve ser preenchido.")
	private String autor;
	@NotEmpty(message = "A descricao deve ser preenchida.")
	private String descricao;
	@NotNull(message = "A preço deve ser informado.")
	private Integer preco ;
	@NotNull(message = "A data de publicação deve ser informado.")
    @Past(message = "A data deve estar no passado.")
    private LocalDate dataPublicacao;
	@NotEmpty(message = "O nome deve ser preenchida.")
	private String nome;
	@NotNull(message = "A quantidade de páginas deve ser preenchida.")
	private Integer qtPaginas;
	@NotNull(message = "A quantidade em estoque deve ser preenchida")
	private Integer estoque;
	@NotNull
	private Capa capa;
	@NotNull
	private Categoria categoria;
	



	

	public Livro(Integer id, String autor,
			@NotNull(message = "O email não pode ser nulo.") @NotEmpty(message = "A descricao deve ser preenchida.") String descricao,
			@NotEmpty(message = "A preço deve ser informado.") Integer preco,
			//@Past(message = "A data deve estar no passado.") LocalDate dataPublicacao,
			@NotEmpty(message = "O nome deve ser preenchida.") String nome,
			@NotEmpty(message = "A quamtidade de páginas deve ser preenchida.") Integer qtPaginas,
			@NotNull Capa capa,
			@NotNull Categoria categoria) {
		super();
		this.id = id;
		this.autor = autor;
		this.descricao = descricao;
		this.preco = preco;
		//this.dataPublicacao = dataPublicacao;
		this.nome = nome;
		this.qtPaginas = qtPaginas;
		this.capa = capa;
		this.categoria = categoria;
	}

  

	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Integer getPreco() {
		return preco;
	}



	public void setPreco(Integer preco) {
		this.preco = preco;
	}



	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}



	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Integer getEstoque() {
		return estoque;
	}



	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}



	public Integer getQtPaginas() {
		return qtPaginas;
	}



	public void setQtPaginas(Integer qtPaginas) {
		this.qtPaginas = qtPaginas;
	}



	public Capa getCapa() {
		return capa;
	}



	public void setCapa(Capa capa) {
		this.capa = capa;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	@Override
	public String toString() {
		return "Livro [id=" + id + ", autor=" + autor + ", descricao=" + descricao + ", preco=" + preco
				+ ", dataPublicacao=" +", nome=" + nome + ", qtPaginas=" + qtPaginas + ", capa="
				+ capa + ", categoria=" + categoria + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Livro getClone() {
		try {
			return (Livro) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
