package br.dev.classificadoraIP.model;

public class Classificadora {

		private String ip;
		public String classe;
		private String mascaraDecimal;
		private String mascaraBinarial;
		private String quantidadeIPS;
		private int subredes;
		private int cidr;

		
		public int getsubredes() {
			return subredes;
	}
		
		private String mascaraDecimal() {
			return mascaraDecimal;
		}

		public String mascaraBinarial() {
			return mascaraBinarial;
		}
		
		public int getclasse() {
			this.classe = classe;
		}
		
		public int getquantidadeIPS() {
			this.quantidadeIPS = quantidadeIPS;
		}
		
		public int getip() {
			this.ip = ip;
		}
		
		public int setip(String ip) {
			this.ip = ip;
		}
		
		public void calcularClasse() {
			
			int primeiroocteto
		}
}
