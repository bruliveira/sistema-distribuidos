import socket
import threading
from datetime import datetime

def conexao_cliente(client_address, data, sock):
    while (True):  
        mensagem = data.decode()
        if mensagem != '0':
            data_atual = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
            sock.sendto(data_atual.encode(), client_address)
        else:
            sock.sendto('0'.encode(), client_address)
            break

# Criando um socket UDP
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

server_address = ('localhost', 20001)
print("Iniciando servidor na porta %s %s" % server_address)

sock.bind(server_address)

while True:
    data, client_address = sock.recvfrom(2048)
    conexao_cliente(client_address, data, sock)
