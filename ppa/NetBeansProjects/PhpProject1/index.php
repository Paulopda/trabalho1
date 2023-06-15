<?php
$servername = "db4free.net";
$username = "paulo10";
$password = "Pa80731501";
$dbname = "trab_pooj";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Falha na conexão: " . $conn->connect_error);
}

$nome = $_POST['nome'];
$email = $_POST['email'];

$sql = "INSERT INTO clientes (nome, email) VALUES ('$nome', '$email')";

if ($conn->query($sql) === TRUE) {
    echo "Cliente cadastrado com sucesso!";
} else {
    echo "Erro ao cadastrar o cliente: " . $conn->error;
}

$conn->close();
?>
