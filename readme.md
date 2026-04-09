<div align="center"><img width="70%" src="https://cdn.discordapp.com/attachments/1017139709090209824/1119770279384711208/mine.jpg"></div>


<div align="left">
    <h1 align="center">Mine and Craft</h1>
    <h2 align="center"> Proposta do trabalho </h2>
        <p> A proposta desse trabalho foi a utilização de vários dos conceitos aprendidos ao longo do semestre sobre orientação a objetos.</p>
        <p> Além disso, foi utilizado o padrão Singleton para instância de apenas um objeto de uma determinada classe.</p>
        <p> Sobre o tema, o trabalho buscou uma abstração mais simples de um dos jogos mais conhecidos e jogados: o Minecraft. Nessa aplicação, nos abstemos ao escopo bidimensional e funcionalidades mais básicas: geração de mundo e personagem, posicionamento e destruição de blocos.</p>
        <br>
    <h2 align="center">Classes</h2>
    <p><strong>Janela : </strong> nessa classe está, basicamente, a instância dos blocos, movimentação do personagem e posicionamento e destruição dos blocos, tudo isso obtido a partir de outras classes, através da composição.
    </p>
    <p><strong>Main: </strong> essa classe serve apenas para instanciar a classe janela, mantendo o código modularizado.</p>
    <p><strong>MyPanels: </strong> sendo uma herança de um JPanel convencional, a classe MyPanel possui coleções de assets para os blocos e para o personagem, funções para modificar a imagem de um painel, funções para geração automática e randômica de mundo seguindo alguns parâmetros, função para atribuição da hotbar e destruição e construção.</p>
    <p><strong>Steve: </strong> essa classe trata mais especificamente do personagem que, como todo o projeto, é feito a partir de painéis e tem 2 blocos de altura. Nela estão contidos variáveis de controle, funções para surgimento do personagem aleatoriamente em qualquer bloco da superfície, funções para estabeler restrições para a movimentação e o mais importante de tudo: sempre é preciso associar o pé à cabeça.</p>
    <p>Ps: a física nesse projeto é inexistente. A picareta por algum motivo não aparece na hotbar e fica cinza quando não utilizada e vermelha quando utilizada.</p>
</div>
