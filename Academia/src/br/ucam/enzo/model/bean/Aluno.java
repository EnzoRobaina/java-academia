package br.ucam.enzo.model.bean;

public class Aluno extends Pessoa {

	private String modalidade;
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}

	@Override
	public void setNome(String nome) {
		// TODO Auto-generated method stub
		super.setNome(nome);
	}

	@Override
	public String getDataNasc() {
		// TODO Auto-generated method stub
		return super.getDataNasc();
	}

	@Override
	public void setDataNasc(String dataNasc) {
		// TODO Auto-generated method stub
		super.setDataNasc(dataNasc);
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	
	
}
