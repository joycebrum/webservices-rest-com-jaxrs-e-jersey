package br.com.alura.loja;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;
import junit.framework.Assert;

public class ClienteTest {
	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {
		
			ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
	        URI uri = URI.create("http://localhost:8080/");
	        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);

			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://localhost:8080");
	        String conteudo = target.path("/carrinhos").request().get(String.class);
	        Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
	        Assert.assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());

	        server.stop();
	}
	
	@Test
    public void testaQueABuscaPeloPrimeiroProjetoFunciona() {
		ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
        URI uri = URI.create("http://localhost:8080/");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
        
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/");
		String conteudo = target.path("/projetos").request().get(String.class);
		Assert.assertTrue(conteudo.contains("<id>1"));
		
		server.stop();
    }
}