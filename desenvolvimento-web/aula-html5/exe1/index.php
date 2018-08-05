<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8" />
        <title>Desenvolvimento Web</title>
    </head>
    <body>

        <?php
            $nome = $_GET['nome'];
            $sobrenome = $_GET['sobrenome'];

            if ( isset($nome) ):

                date_default_timezone_set('America/Sao_Paulo');
                $agora = date('d/m/Y h:i:s', time());
                echo "<h3>Dados recebidos no back-end em $agora</h3>";
                echo "<strong>Nome:</strong> <mark>$nome</mark><br />";
                echo "<strong>Sobrenome:</strong> <mark>$sobrenome</mark><br />";

            else:
        ?>

        <form>
            Nome:
            <input type="text" name="nome" />
            <br />
            Sobrenome:
            <input type="text" name="sobrenome" />
            <br />
            <input type="submit" value="Enviar" />
        </form>

    <?php endif; ?>

    </body>
</html>
