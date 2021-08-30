package com.gft.exercicio.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@NotEmpty(message = "Nome é obrigatória")
	@Size(max = 60, message = "A descrição não pode conter mais de 60 caracteres")
	private String nome;
	
	@NotNull(message = "Salário é obrigatório")
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	@DecimalMax(value = "9999999999.99", message = "Valor não pode ser maior que 9.999.999.999.99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal salario;
	
	@Enumerated(EnumType.STRING)
	private StatusProfessor status;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public StatusProfessor getStatus() {
		return status;
	}

	public void setStatus(StatusProfessor status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Professor other = (Professor) obj;
		if (codigo != other.codigo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
}
