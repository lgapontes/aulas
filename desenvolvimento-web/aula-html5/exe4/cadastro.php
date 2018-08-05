<?php

    $nome = $_POST["nome"];
    $nascimento = $_POST["nascimento"];

    if ( !isset($nome) || strlen($nome) == 0 ) {
        echo "O campo nome é obrigatório!";
        die();
    }

    if ( !isset($nascimento) || strlen($nascimento) == 0 ) {
        $nascimento = "Não informado";
    }

?>

<h4>Dados recebidos:</h4>
<strong>Nome:</strong> <?= $nome ?>
<br />
<strong>Data de nascimento:</strong> <?= $nascimento ?>
<br /><br />
<em>Amigo cadastrado com sucesso!</em>
