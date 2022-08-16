package br.edu.iftm.upt.justificativa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.iftm.upt.justificativa.model.Cidadao;
import br.edu.iftm.upt.justificativa.model.Eleicao;
import br.edu.iftm.upt.justificativa.model.Juiz;
import br.edu.iftm.upt.justificativa.model.Justificativa;
import br.edu.iftm.upt.justificativa.model.Situacao;
import br.edu.iftm.upt.justificativa.repository.CidadaoRepository;
import br.edu.iftm.upt.justificativa.repository.EleicaoRepository;
import br.edu.iftm.upt.justificativa.repository.JuizRepository;
import br.edu.iftm.upt.justificativa.repository.JustificativaRepository;
import br.edu.iftm.upt.justificativa.service.JustificativaService;



@Controller
@RequestMapping("/eleicao")
public class JustificativaController {
	
	@Autowired
	private CidadaoRepository cidadaoRepository;
	
	@Autowired
	private EleicaoRepository eleicaoRepository;
	
	@Autowired
	private JuizRepository juizRepository;
	
	@Autowired
	private JustificativaRepository justificativaRepository;
	
	@Autowired
	private JustificativaService justificativaService;
	
	private static final Logger logger = LoggerFactory.getLogger(JustificativaController.class);
	
/*
=============================Metodo para cadastrar a justificativa =============================
*/
		@GetMapping("/criar")
		public String abrirCadastro(Model model) {
			logger.trace("Entrou no metodo abrirCadasatro");
			
			List<Cidadao> cidadaos = cidadaoRepository.findBySituacaoNot(Situacao.INATIVO);
			//buscou todas os cidadaos do repositorio
			
			List<Eleicao> eleicaos= eleicaoRepository.findBySituacaoNot(Situacao.INATIVO);
			
			logger.info("Cidadaos buscadas no BD: {}", cidadaos);
			
			model.addAttribute("cidadaos",cidadaos);
			model.addAttribute("eleicaos", eleicaos);
			//Colocou os cidadaos buscadas no model
			
			logger.trace("Encaminhando para a view eleicao/cadastrar");
			
			return "eleicao/cadastrar";
		}
		
		@PostMapping("/cadastrar")
		public String cadastrar(Justificativa justificativa, RedirectAttributes atributos) {
			logger.trace("Entrou no metodo cadastrar");
			
			logger.info("Justificativa recebida: {}", justificativa);

			justificativa= justificativaService.salvar(justificativa);
			
			logger.info("Justificativa salva: {}", justificativa);
			
			atributos.addFlashAttribute("mensagem","Justificativa cadastrada com sucesso");
			
			logger.trace("Redirecionando para a URL /mensagem");
			return "redirect:/mensagem";
		}
		
/*
=============================Metodo para pesquisar a justificativa =============================
*/
		
	@GetMapping("/pesquisar")
	public String abrirPesquisar(Model model,Justificativa justificativa, Juiz juiz, RedirectAttributes atributos) {
		logger.trace("Entrou no metodo abrirPesquisar");
		
		List<Justificativa> justificativas = justificativaRepository.buscarComCidadaoEleicao(Situacao.ABERTO);
		List<Juiz> juizes = juizRepository.findBySituacaoNot(Situacao.INATIVO);

		
		model.addAttribute("justificativas",justificativas);
		model.addAttribute("juizes",juizes);
		model.addAttribute("negado",Situacao.NEGADA);
		model.addAttribute("aceito",Situacao.ACEITA);
		
		
		logger.trace("Encaminhando para a view eleicao/pesquisar");
		return "eleicao/pesquisar";
	}
		
	@PostMapping("/pesquisar")
	public String pesquisar(Justificativa justificativa, RedirectAttributes atributos) {
		logger.trace("Entrou no metodo pesquisar");
		
		logger.info("Justificativa recebida: {}", justificativa);

		justificativa= justificativaService.alterar(justificativa);
		
		logger.info("Justificativa alterada: {}", justificativa);
		
		atributos.addFlashAttribute("mensagem","Justificativa analisada com sucesso");
		
		logger.trace("Redirecionando para a URL /mensagem");
		return "redirect:/mensagem";
	}

	/*
	 	@PostMapping("/buscarlote")
	public String abrirEscolhaLote(Aplicacao aplicacao, Model model) {
		//Estava dando erro no codigo da vacina, uma das solucoes seria public String abrirEscolhaLote(Pessoa pessoa,Long codigoPessoa, String nomePessoa, Vacina vacina, Model model) 
		
		 Logo poderia colocar:
		 pessoa.setCodigo(codigoPessoa)
		 pessoa.setNome(nomePessoa)
		 
		
		logger.trace("Entrou no metodo abrirEscolhaLote");
		
		logger.info("Aplicacao recebida: {}", aplicacao);
		logger.info("Pessoa da Aplicacao recebidoa: {}", aplicacao.getPessoa());
		logger.info("Profissao Pessoa da Aplicacao recebidoa: {}", aplicacao.getPessoa().getProfissao());
		logger.info("Lote da Aplicacao recebida: {}", aplicacao.getLote());
		logger.info("Vacina do Lote da Aplicacao recebida: {}", aplicacao.getLote().getVacina());
		
		List<Lote> lotes = loteRepository.buscarComVacina(aplicacao.getLote().getVacina());
		//foi implementado no loteQueriesImpl.java o buscarTodosComVacina para pegar o nome da vacina no lote
		model.addAttribute("lotes",lotes);
			
		logger.trace("Encaminhando para a view aplicacoes/escolherlote");
		return "aplicacoes/escolherlote";
	}
	 */

}
