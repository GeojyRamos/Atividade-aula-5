package trabalho5;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.tool.schema.extract.internal.SequenceNameExtractorImpl;

public class Main {
	

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho5");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		int x = 1, potencia, anof, anom, km ;
		String marca, modelo, cor;
		Double preco;
		
		while(x != 2) {
			System.out.println("Informe a marca do veiculo:\n");
			marca = ler.nextLine();		
			
			System.out.println("Informe o modelo do veiculo:\n");
			modelo = ler.nextLine();
			
			System.out.println("Informe a cor do veiculo:\n");
			cor = ler.nextLine();
			
			System.out.println("Informe a potencia em CV do veiculo:\n");
			potencia = Integer.parseInt(ler.nextLine());			
			
			System.out.println("Informe o ano de fabricaçã do veiculo:\n");
			anof = Integer.parseInt(ler.nextLine());
			
			System.out.println("Informe o ano do modelo do veiculo:\n");
			anom = Integer.parseInt(ler.nextLine());					
			
			System.out.println("Informe o preço do veiculo:\n");
			preco = Double.parseDouble(ler.nextLine());
			
			System.out.println("Informe kilometragem do veiculo:\n");
			km = Integer.parseInt(ler.nextLine());
			
			Marca m = new Marca(null, marca);
			Modelo mo = new Modelo(null, modelo, potencia, m);			
			Automovel auto = new Automovel(null, anof, anom, cor, preco, km, mo);
			
			
			em.persist(m);
			em.persist(mo);
			em.persist(auto);
			
			System.out.println("Deseja inserir mais algum veiculo? (1= sim / 2 = não):\n");
			x = Integer.parseInt(ler.nextLine());
			
			
			
		}

		em.getTransaction().commit();
		
	    Query qryMarca = em.createQuery("select m from Marca m");
	    List<Marca> marcas = qryMarca.getResultList();
		System.out.println("** MARCAS CADASTRADAS **");
		for (Marca m : marcas) {
			System.out.println("Id: " + m.getId() + " Marca: " + m.getNome());
		}
		
		System.out.println("----------------------------------------");
		
		
	
		Query qryModelo = em.createQuery("select m from Modelo m");
		List<Modelo> modelos = qryModelo.getResultList();
		System.out.println("** MODELOS CADASTRADOS **");
		for (Modelo m : modelos) {
			System.out.println("Id: " + m.getId() + " Descrição: " + m.getDescricao() + " CV: " + m.getPotencia() +
								" Marca: " + m.getMarca_id().getNome());
		}

		System.out.println("----------------------------------------");		
		
		Query qryAutomovel = em.createQuery("select m from Automovel m");
		List<Automovel> autos = qryAutomovel.getResultList();
		System.out.println("** AUTOMOVEIS CADASTRADOS **");
		for (Automovel a : autos) {
			System.out.println("Id: " + a.getId() + " Ano/Modelo: " + a.getAnoFabricacao() + "/" + a.getAnoModelo() + 
								" Obs: " + a.getObservacoes() + " Preço: " + a.getPreco() + 
								" Km: " + a.getKilometragem() + " Modelo: " + a.getModelo_id().getDescricao());
		}
		
		em.close();
		emf.close();
	}

}


