<?php

    $nome = $_POST['nome'];
    $sobrenome = $_POST['sobrenome'];
    $linguagem = $_POST['linguagem'];
    $endereco = $_POST['endereco'];

    date_default_timezone_set('America/Sao_Paulo');
    $agora = date('d/m/Y h:i:s', time());
    echo "<h3>Dados recebidos no back-end em $agora</h3>";
    echo "<strong>Nome:</strong> <mark>$nome</mark><br />";
    echo "<strong>Sobrenome:</strong> <mark>$sobrenome</mark><br />";
    echo "<strong>Linguagem preferida:</strong> <mark>$linguagem</mark><br />";
    echo "<strong>Endereço:</strong>";
    echo "<pre>$endereco</pre>";
