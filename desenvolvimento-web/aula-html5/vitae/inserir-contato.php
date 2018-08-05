<?php

    $nome = $_POST["nome"];
    $email = $_POST["email"];
    $hamburguer = $_POST["hamburguer"];
    $termos = $_POST["termos"];

?>

<h4>Dados recebidos:</h4>
<strong>Nome:</strong> <?= $nome ?>
<br />
<strong>E-mail:</strong> <?= $email ?>
<br />
<strong>Hamburguer preferido:</strong> <?= $hamburguer ?>
<br />
<strong>Aceitou os termos:</strong> <?= (strcmp($termos,"on") == 0 ? "Sim" : "Não") ?>
<br /><br />
<em>Contato cadastrado com sucesso!</em>
