<?php

    $nome = $_POST['nome'];
    $sobrenome = $_POST['sobrenome'];

    date_default_timezone_set('America/Sao_Paulo');
    $agora = date('d/m/Y h:i:s', time());
    echo "<h3>Dados recebidos no back-end em $agora</h3>";
    echo "<strong>Nome:</strong> <mark>$nome</mark><br />";
    echo "<strong>Sobrenome:</strong> <mark>$sobrenome</mark><br />";
