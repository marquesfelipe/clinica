package br.com.ftech.clinica.util;


public class Mensagem {

	public enum TipoMensagem {
		ERRO("alert alert-danger"),
		AVISO("alert alert-warning"),
		SUCESSO("alert alert-success");
		
		private String classeCss;
		
		private TipoMensagem(String classeCss){
			this.classeCss = classeCss;
		}
		public String getClasseCss() {
			return classeCss;
		}
		public void setClasseCss(String classeCss) {
			this.classeCss = classeCss;
		}
	}
	
	private String texto;
	private TipoMensagem tipoMensagem;
	
	public Mensagem(String texto, TipoMensagem tipoMensagem) {
		this.texto = texto;
		this.tipoMensagem = tipoMensagem;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public TipoMensagem getTipoMensagem() {
		return tipoMensagem;
	}
	public void setTipoMensagem(TipoMensagem tipoMensagem) {
		this.tipoMensagem = tipoMensagem;
	}
}